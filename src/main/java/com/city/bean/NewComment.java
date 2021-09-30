package com.city.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author XGKerwin
 * @since 2021-09-17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewComment implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("searchValue")
    private String searchValue;

    @TableField("createBy")
    private String createBy;

    @TableField("createTime")
    private String createTime;

    @TableField("updateBy")
    private String updateBy;

    @TableField("updateTime")
    private String updateTime;

    private String remark;

    @TableField("userId")
    private String userId;

    @TableField("pressId")
    private String pressId;

    private String content;

    @TableField("nickName")
    private String nickName;

    @TableField("userName")
    private String userName;

    private String avatar;

    private String time;

    public NewComment(String userId, String pressId, String content) {
        this.userId = userId;
        this.pressId = pressId;
        this.content = content;
    }

}
