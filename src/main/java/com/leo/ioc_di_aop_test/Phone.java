package com.leo.ioc_di_aop_test;

public class Phone {
    private String phoneBrand;
    private Integer phonePower;

    public Phone() {
    }

    public Phone(String phoneBrand, Integer phonePower) {
        this.phoneBrand = phoneBrand;
        this.phonePower = phonePower;
    }

    public String getPhoneBrand() {
        return phoneBrand;
    }

    public void setPhoneBrand(String phoneBrand) {
        this.phoneBrand = phoneBrand;
    }

    public Integer getPhonePower() {
        return phonePower;
    }

    public void setPhonePower(Integer phonePower) {
        this.phonePower = phonePower;
    }

    //打电话
    public void callTo(){
        System.out.println("打电话");
    }

    //充电
    public void powerUp(Integer consumePower){
        System.out.println("充电");
    }

    //耗电
    public void powerDown(Integer consumePower){
        System.out.println("耗电");
    }
}
