package com.hz.web.ResponseEntiry;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;


@Getter
@Setter
@Accessors(chain = true)
public class RestfulRet implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code = "200";
    private String msg = "success";
    private Object data;
}