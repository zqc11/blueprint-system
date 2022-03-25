package com.silentsunshine.blueprintsystem.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhouqichun
 **/
@Data
@AllArgsConstructor
public class Result {
    private boolean success;
    private int code;
    private String msg;
    private Object data;

    public static Result success(Object data){
        return new Result(true, 2000, "成功", data);
    }

    public static Result failure(int code, String msg){
        return new Result(false, code, msg, null);
    }
}
