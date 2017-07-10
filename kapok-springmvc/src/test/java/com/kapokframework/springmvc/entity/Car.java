package com.kapokframework.springmvc.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kapokframework.springmvc.jackson.deser.DateDeserializers;
import com.kapokframework.springmvc.jackson.ser.DateSerializers;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Will WM. Zhang
 * @since 2017-01-04 16:02
 */
public class Car implements Serializable {

    private Long id;

    @NotNull(message = "品牌不能为空")
    private String brand;

    private String color;

    @NotNull(message = "座位数不能为空")
    private Integer seats;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializers.DATE.class)
    @JsonDeserialize(using = DateDeserializers.DATE.class)
    private Date dateOfProduction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Date getDateOfProduction() {
        return dateOfProduction;
    }

    public void setDateOfProduction(Date dateOfProduction) {
        this.dateOfProduction = dateOfProduction;
    }
}
