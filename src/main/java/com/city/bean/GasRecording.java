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
public class GasRecording implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String petrol;

    private String petrolmoney;

    private String time;

    private String mileage;

    private String price;

    private String volume;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPetrol() {
        return petrol;
    }

    public void setPetrol(String petrol) {
        this.petrol = petrol;
    }

    public String getPetrolmoney() {
        return petrolmoney;
    }

    public void setPetrolmoney(String petrolmoney) {
        this.petrolmoney = petrolmoney;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "GasRecording{" +
        "id=" + id +
        ", petrol=" + petrol +
        ", petrolmoney=" + petrolmoney +
        ", time=" + time +
        ", mileage=" + mileage +
        ", price=" + price +
        ", volume=" + volume +
        "}";
    }
}
