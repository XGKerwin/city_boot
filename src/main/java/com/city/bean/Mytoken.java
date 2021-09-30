package com.city.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author XGKerwin
 * @since 2021-09-17
 */
public class Mytoken implements Serializable {

    private static final long serialVersionUID=1L;

    private String token;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mytoken{" +
        "token=" + token +
        ", id=" + id +
        "}";
    }
}
