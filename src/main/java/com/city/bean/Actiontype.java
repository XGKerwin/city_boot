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
public class Actiontype implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "typeid", type = IdType.AUTO)
    private Integer typeid;

    private String typename;


    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public String toString() {
        return "Actiontype{" +
        "typeid=" + typeid +
        ", typename=" + typename +
        "}";
    }
}
