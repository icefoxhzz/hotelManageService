package com.hz.web.ResponseEntiry;

import lombok.Data;

import java.io.Serializable;

@Data
public class CommonDict implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String val;
}
