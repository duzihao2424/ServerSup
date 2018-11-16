//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.dzh.netlibrary.network;

import java.io.Serializable;

public class NetworkHeader implements Serializable {
    private Long id;
    private String uuid;
    private String headerType;
    private String headerKey;
    private String headerValue;

    public NetworkHeader() {
    }

    public NetworkHeader(Long id) {
        this.id = id;
    }

    public NetworkHeader(Long id, String uuid, String headerType, String headerKey, String headerValue) {
        this.id = id;
        this.uuid = uuid;
        this.headerType = headerType;
        this.headerKey = headerKey;
        this.headerValue = headerValue;
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

    public String getHeaderType() {
        return this.headerType;
    }

    public void setHeaderType(String headerType) {
        this.headerType = headerType;
    }

    public String getHeaderKey() {
        return this.headerKey;
    }

    public void setHeaderKey(String headerKey) {
        this.headerKey = headerKey;
    }

    public String getHeaderValue() {
        return this.headerValue;
    }

    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }
}
