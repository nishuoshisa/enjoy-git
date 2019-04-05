package net.wanho.util;

import lombok.Data;

/**
 * Created by 胡梦娟 on 2018/11/27.
 */
@Data
public class JsonResult {
    private Integer code;
    private String msg;
    private Object data;
}
