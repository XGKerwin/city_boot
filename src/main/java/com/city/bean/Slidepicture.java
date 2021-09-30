package com.city.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import org.springframework.stereotype.Controller;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author XGKerwin
 * @since 2021-09-17
 */
public class Slidepicture implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("imgUrl")
    private String imgUrl;

    @TableField("type")
    private String type;

    @TableField("createTime")
    private String createTime;

    @TableField("sort")
    private String sort;

    @TableField("display")
    private String display;

    @TableField("pressId")
    private String pressId;

    @Override
    public String toString() {
        return "Slidepicture{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", type='" + type + '\'' +
                ", createTime='" + createTime + '\'' +
                ", sort='" + sort + '\'' +
                ", display='" + display + '\'' +
                ", pressId='" + pressId + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getPressId() {
        return pressId;
    }

    public void setPressId(String pressId) {
        this.pressId = pressId;
    }
}
