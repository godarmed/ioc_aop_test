package com.leo.ioc_di_aop_test;

import java.util.Arrays;

public class People {
    private String name;
    private Integer age;
    private Phone phone;

    public People() {
    }

    public People(String name, Integer age, Phone phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }
}
