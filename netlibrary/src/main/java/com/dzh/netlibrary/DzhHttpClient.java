package com.dzh.netlibrary;


import com.dzh.netlibrary.util.AppUtil;
import com.dzh.netlibrary.util.CustomHeaderInterceptor;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;

public class DzhHttpClient {
    private static OkHttpClient httpClient = null;

    public DzhHttpClient() {
    }

    public static OkHttpClient getHttpClient() {
        return getClient();
    }


    private static OkHttpClient getClient() {
        if (httpClient == null) {
            Builder builder = new Builder();
            List<Interceptor> interceptors = builder.interceptors();
            interceptors.add(new CustomHeaderInterceptor(AppUtil.applicationContext));
            interceptors.add(new DzhHttpLogger());
            builder.connectTimeout(10L, TimeUnit.SECONDS);
            builder.readTimeout(20L, TimeUnit.SECONDS);
            builder.writeTimeout(20L, TimeUnit.SECONDS);
            builder.retryOnConnectionFailure(true);

            try {
                SSLContext sslContext = SSLContext.getInstance("SSL");
                sslContext.init((KeyManager[])null, new TrustManager[]{new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }
                }}, new SecureRandom());
                SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
                builder.sslSocketFactory(sslSocketFactory);
                builder.hostnameVerifier(new HostnameVerifier() {
                    public boolean verify(String hostname, SSLSession session) {
                        return true;
                    }
                });
            } catch (KeyManagementException | NoSuchAlgorithmException var4) {
                var4.printStackTrace();
            }

            httpClient = builder.build();
        }

        return httpClient;
    }

}
