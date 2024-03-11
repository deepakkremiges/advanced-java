package com.ndml_assignment.assignment.utility;

import java.beans.JavaBean;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import lombok.Data;

@JavaBean
@Data
public class ApiRequest {

    private String token;
    private Map<String, Object> data;
    private String reqId;
    private Instant client_ts;
    private String client_type;

    public ApiRequest(String token, Map<String, Object> data, String reqId, String client_ts, String client_type) {
        this.token = token;
        this.data = data;
        this.reqId = generateRanId();
        this.client_ts = Instant.now();
        this.client_type = client_type;
    }

    @Override
    public String toString() {
        return "ApiRequest [token=" + token + ", data=" + data + ", reqId=" + reqId + ", client_ts=" + client_ts
                + ", client_type=" + client_type + "]";
    }

    public static String generateRanId(){
        return UUID.randomUUID().toString();
    }
}

