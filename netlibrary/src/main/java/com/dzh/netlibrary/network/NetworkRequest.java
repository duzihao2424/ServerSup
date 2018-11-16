//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dzh.netlibrary.network;

import java.io.Serializable;

public class NetworkRequest implements Serializable {
    private Long id;
    private String uuid;
    private String requestUrl;
    private String requestMethod;
    private String requestBody;
    private String requestContentLength;
    private String requestTime;
    private String responseBody;
    private String responseContentLength;
    private String responseStatus;
    private String responseMessage;
    private String responseTime;
    private String period;
    private String version;
    private String operateTime;

    public NetworkRequest() {
    }

    public NetworkRequest(Long id) {
        this.id = id;
    }

    public NetworkRequest(Long id, String uuid, String requestUrl, String requestMethod, String requestBody, String requestContentLength, String requestTime, String responseBody, String responseContentLength, String responseStatus, String responseMessage, String responseTime, String period, String version, String operateTime) {
        this.id = id;
        this.uuid = uuid;
        this.requestUrl = requestUrl;
        this.requestMethod = requestMethod;
        this.requestBody = requestBody;
        this.requestContentLength = requestContentLength;
        this.requestTime = requestTime;
        this.responseBody = responseBody;
        this.responseContentLength = responseContentLength;
        this.responseStatus = responseStatus;
        this.responseMessage = responseMessage;
        this.responseTime = responseTime;
        this.period = period;
        this.version = version;
        this.operateTime = operateTime;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getRequestMethod() {
        return this.requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public String getRequestBody() {
        return this.requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getRequestContentLength() {
        return this.requestContentLength;
    }

    public void setRequestContentLength(String requestContentLength) {
        this.requestContentLength = requestContentLength;
    }

    public String getRequestTime() {
        return this.requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getResponseBody() {
        return this.responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getResponseContentLength() {
        return this.responseContentLength;
    }

    public void setResponseContentLength(String responseContentLength) {
        this.responseContentLength = responseContentLength;
    }

    public String getResponseStatus() {
        return this.responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseTime() {
        return this.responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getPeriod() {
        return this.period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOperateTime() {
        return this.operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }
}
