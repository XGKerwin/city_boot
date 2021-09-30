package com.city.returnJson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 关鑫
 * @date 2021/8/27 15:12 星期五
 * @Description com.city.returnJson
 */

@Data
@NoArgsConstructor
public class ReturnObject {

    private Integer code = 200;
    private Integer total;
    private String message = "";
    private Object data;

    public ReturnObject(Integer code,String message, Integer total, Object result) {
        this.code = code;
        this.total = total;
        this.message = message;
        this.data = result;
    }

    public ReturnObject(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
