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
public class WrittenJudgement implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String pes;

    private String number;

    @TableField("userName")
    private String userName;

    @TableField("jszFileNumber")
    private String jszFileNumber;

    @TableField("jszNumber")
    private String jszNumber;

    @TableField("quasiDrivingType")
    private String quasiDrivingType;

    private String tel;

    private String cph;

    @TableField("vehicleType")
    private String vehicleType;

    @TableField("fzOffice")
    private String fzOffice;

    @TableField("violationDate")
    private String violationDate;

    private String behavior;

    private String address;

    private String money;

    private String integral;

    @TableField("punishOffice")
    private String punishOffice;

    @TableField("punishDate")
    private String punishDate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPes() {
        return pes;
    }

    public void setPes(String pes) {
        this.pes = pes;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJszFileNumber() {
        return jszFileNumber;
    }

    public void setJszFileNumber(String jszFileNumber) {
        this.jszFileNumber = jszFileNumber;
    }

    public String getJszNumber() {
        return jszNumber;
    }

    public void setJszNumber(String jszNumber) {
        this.jszNumber = jszNumber;
    }

    public String getQuasiDrivingType() {
        return quasiDrivingType;
    }

    public void setQuasiDrivingType(String quasiDrivingType) {
        this.quasiDrivingType = quasiDrivingType;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCph() {
        return cph;
    }

    public void setCph(String cph) {
        this.cph = cph;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFzOffice() {
        return fzOffice;
    }

    public void setFzOffice(String fzOffice) {
        this.fzOffice = fzOffice;
    }

    public String getViolationDate() {
        return violationDate;
    }

    public void setViolationDate(String violationDate) {
        this.violationDate = violationDate;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getPunishOffice() {
        return punishOffice;
    }

    public void setPunishOffice(String punishOffice) {
        this.punishOffice = punishOffice;
    }

    public String getPunishDate() {
        return punishDate;
    }

    public void setPunishDate(String punishDate) {
        this.punishDate = punishDate;
    }

    @Override
    public String toString() {
        return "WrittenJudgement{" +
        "id=" + id +
        ", pes=" + pes +
        ", number=" + number +
        ", userName=" + userName +
        ", jszFileNumber=" + jszFileNumber +
        ", jszNumber=" + jszNumber +
        ", quasiDrivingType=" + quasiDrivingType +
        ", tel=" + tel +
        ", cph=" + cph +
        ", vehicleType=" + vehicleType +
        ", fzOffice=" + fzOffice +
        ", violationDate=" + violationDate +
        ", behavior=" + behavior +
        ", address=" + address +
        ", money=" + money +
        ", integral=" + integral +
        ", punishOffice=" + punishOffice +
        ", punishDate=" + punishDate +
        "}";
    }
}
