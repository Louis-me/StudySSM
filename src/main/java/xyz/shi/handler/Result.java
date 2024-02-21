package xyz.shi.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
//统一结果返回
@Data
public class Result {

    private boolean success;

    private int code;

    private String message;

    private Object data;
}