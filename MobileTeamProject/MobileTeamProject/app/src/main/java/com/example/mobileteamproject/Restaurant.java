package com.example.mobileteamproject;

public class Restaurant {
    Integer image;
    String name;
    String explanation;
    String location;
    String call;

    public Restaurant(Integer image, String name, String explanation, String location, String call){
        this.image = image;
        this.name = name;
        this.explanation = explanation;
        this.location = location;
        this.call = call;
    }

    public Integer getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getCall() {
        return call;
    }
}
