package com.city.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author XGKerwin
 * @since 2021-09-17
 */
public class Doctors implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "doctorId", type = IdType.AUTO)
    private String doctorId;

    @TableField("hospitalId")
    private String hospitalId;

    @TableField("deptId")
    private String deptId;

    private String doctorname;

    @TableField("descs")
    private String descs;

    private String tag;

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Doctors{" +
                "doctorId=" + doctorId +
                ", hospitalId=" + hospitalId +
                ", deptId=" + deptId +
                ", doctorname=" + doctorname +
                ", desc=" + descs +
                ", tag=" + tag +
                "}";
    }
}
