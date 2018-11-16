package com.dzh.netlibrary;

import android.text.TextUtils;


import com.dzh.netlibrary.network.NetworkHeader;
import com.dzh.netlibrary.network.NetworkRequest;
import com.dzh.netlibrary.util.Logger;
import com.dzh.netlibrary.util.UUIDUtil;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;

public class DzhHttpLogger implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final String logVersion = "100";

    public DzhHttpLogger() {
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String logMsg = "";
        NetworkRequest requestLog = new NetworkRequest();
        ArrayList<NetworkHeader> headersLog = new ArrayList();
        String uuid = UUIDUtil.generator();
        requestLog.setUuid(uuid);
        requestLog.setVersion("100");
        Request request = chain.request();
        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;
        Connection connection = chain.connection();
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        logMsg = logMsg + "Request: \n  " + request.method() + ' ' + request.url() + "\n";
        requestLog.setRequestUrl(request.url().toString());
        requestLog.setRequestMethod(request.method());
        logMsg = logMsg + "  protocol: " + protocol + "\n";
        if (hasRequestBody) {
            logMsg = logMsg + "Request Headers:\n";
            if (requestBody.contentType() != null) {
                logMsg = logMsg + "  Content-Type: " + requestBody.contentType() + "\n";
            }

            if (requestBody.contentLength() != -1L) {
                logMsg = logMsg + "  Content-Length: " + requestBody.contentLength() + "\n";
            }
        }

        Headers headers = request.headers();
        String headerType = "";

        for(int i = 0; i < headers.size(); ++i) {
            String name = headers.name(i);
            if (name.equals("type")) {
                headerType = headers.value(i);
            }

            if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                logMsg = logMsg + "  " + name + ": " + headers.value(i) + "\n";
                NetworkHeader entity = new NetworkHeader();
                entity.setUuid(uuid);
                entity.setHeaderType("request");
                entity.setHeaderKey(name);
                entity.setHeaderValue(headers.value(i));
                headersLog.add(entity);
            }
        }

        if (!hasRequestBody) {
            logMsg = logMsg + "Request Body: (0-byte body) \n\n";
            requestLog.setRequestBody("0-byte body");
            requestLog.setRequestContentLength(String.valueOf(0));
        } else if (this.bodyEncoded(request.headers())) {
            logMsg = logMsg + "Request Body: (encoded body omitted)\n\n";
            requestLog.setRequestBody("encoded body omitted");
        } else {
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                if (!contentType.subtype().equals("json") && !contentType.subtype().equals("x-www-form-urlencoded")) {
                    logMsg = logMsg + "Request Body: (encoded body omitted)\n\n";
                    requestLog.setRequestBody("encoded body omitted");
                } else {
                    Buffer buffer = new Buffer();
                    requestBody.writeTo(buffer);
                    Charset charset = contentType.charset(UTF8);
                    if (this.isPlaintext(buffer)) {
                        String content = buffer.readString(charset);
                        logMsg = logMsg + "Request Body: (" + requestBody.contentLength() + "-byte body) \n";
                        if (!TextUtils.isEmpty(headerType) && headerType.equals("uploadLog")) {
                            try {
                                if (content.length() > 100) {
                                    logMsg = logMsg + "  " + content.substring(0, 100) + "......\n\n";
                                }
                            } catch (Exception var28) {
                                var28.printStackTrace();
                            }
                        } else {
                            logMsg = logMsg + "  " + content + "\n\n";
                        }

                        requestLog.setRequestBody(content);
                        requestLog.setRequestContentLength(String.valueOf(requestBody.contentLength()));
                    } else {
                        logMsg = logMsg + "Request Body: (binary " + requestBody.contentLength() + "-byte body omitted)\n\n";
                        requestLog.setRequestBody("binary " + requestBody.contentLength() + "-byte body omitted");
                    }
                }
            } else {
                logMsg = logMsg + "Request Body: (contentType is null)\n\n";
                requestLog.setRequestBody("contentType is null");
            }
        }

        long startNs = System.nanoTime();

        Response response;
        try {
            response = chain.proceed(request);
        } catch (Exception var27) {
            logMsg = logMsg + "Response: \n  HTTP FAILED: " + var27 + "\n";
            Logger.getLogger().e(logMsg);
            throw var27;
        }

        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
        requestLog.setRequestTime(String.valueOf(response.sentRequestAtMillis()));
        requestLog.setResponseTime(String.valueOf(response.receivedResponseAtMillis()));
        requestLog.setPeriod(String.valueOf(response.receivedResponseAtMillis() - response.sentRequestAtMillis()));
        ResponseBody responseBody = response.body();
        long contentLength = responseBody.contentLength();
        logMsg = logMsg + "Response: (" + tookMs + "ms)\n  " + response.code() + ' ' + response.message() + "\n";
        requestLog.setResponseStatus(String.valueOf(response.code()));
        requestLog.setResponseMessage(response.message());
        logMsg = logMsg + "Response Headers:\n";
        Headers respHeaders = response.headers();
        int i = 0;

        for(int count = respHeaders.size(); i < count; ++i) {
            logMsg = logMsg + "  " + respHeaders.name(i) + ": " + respHeaders.value(i) + "\n";
            NetworkHeader entity = new NetworkHeader();
            entity.setUuid(uuid);
            entity.setHeaderType("response");
            entity.setHeaderKey(respHeaders.name(i));
            entity.setHeaderValue(respHeaders.value(i));
            headersLog.add(entity);
        }

         if (this.bodyEncoded(response.headers())) {
            logMsg = logMsg + "Response Body: (encoded body omitted)";
            requestLog.setResponseBody("encoded body omitted");
        } else {
            if (contentLength == -1L) {
                logMsg = logMsg + "Response Body: (chunked)\n";
                requestLog.setResponseBody("chunked");
            } else {
                logMsg = logMsg + "Response Body: (" + contentLength + "-byte body)\n";
                requestLog.setResponseContentLength(String.valueOf(contentLength));
            }

            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                if (!contentType.subtype().equals("json") && !contentType.subtype().equals("plain")) {
                    logMsg = logMsg + "";
                } else {
                    BufferedSource source = responseBody.source();
                    source.request(9223372036854775807L);
                    Buffer buffer = source.buffer();
                    if (!this.isPlaintext(buffer)) {
                        logMsg = logMsg + "\n";
                        logMsg = logMsg + "  (binary " + buffer.size() + "-byte body omitted)";
                        requestLog.setResponseBody("binary " + buffer.size() + "-byte body omitted");
                        Logger.getLogger().d(logMsg);
                        return response;
                    }

                    if (contentLength != 0L) {
                        String content = buffer.clone().readString(charset);
                        logMsg = logMsg + content;
                    }
                }
            }
        }

        Logger.getLogger().d(logMsg);
        return response;
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }

    private boolean isPlaintext(Buffer buffer) throws EOFException {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64L ? buffer.size() : 64L;
            buffer.copyTo(prefix, 0L, byteCount);

            for(int i = 0; i < 16 && !prefix.exhausted(); ++i) {
                if (Character.isISOControl(prefix.readUtf8CodePoint())) {
                    return false;
                }
            }

            return true;
        } catch (EOFException var6) {
            return false;
        }
    }
}
