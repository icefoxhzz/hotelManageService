package com.hz.web.ResponseEntiry;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceDict implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String val;
    int service_type;
    String service_val;
    float price;
}
