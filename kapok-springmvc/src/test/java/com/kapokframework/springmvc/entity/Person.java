package com.kapokframework.springmvc.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kapokframework.springmvc.jackson.deser.DateDeserializers;
import com.kapokframework.springmvc.jackson.deser.DateTimeDeserializers;
import com.kapokframework.springmvc.jackson.ser.DateSerializers;
import com.kapokframework.springmvc.jackson.ser.DateTimeSerializers;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Will WM. Zhang
 * @since 2017-01-04 15:59
 */
public class Person implements Serializable {

    @NotNull(message = "id不能为空")
    private Long id;

    @NotNull(message = "名称不能为空")
    private String name;

    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonSerialize(using = DateSerializers.DATE.class)
    @JsonDeserialize(using = DateDeserializers.DATE.class)
    private Date dateOfBirth;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = DateTimeSerializers.DATE_TIME.class)
    @JsonDeserialize(using = DateTimeDeserializers.DATE_TIME.class)
    private DateTime createTime;

    @Valid
    private Car car;

    @Valid
    private List<Car> cars;

    public Person() {
    }

    public Person(String name, String gender, Date dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public DateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(DateTime createTime) {
        this.createTime = createTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "[name:" + this.name + ",gender:" + this.gender + ",dateOfBirth:" + this.dateOfBirth + ",createTime:" + this.createTime + "]";
    }
}
