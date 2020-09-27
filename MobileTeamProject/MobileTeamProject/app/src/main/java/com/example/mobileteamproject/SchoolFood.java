package com.example.mobileteamproject;

public class SchoolFood {
    private String foodName;
    private String category;
    private String kinds;
    private String restaurantName;
    private Integer price;

    public SchoolFood(String foodName, String category, String kinds, String restaurantName, Integer price){

        this.foodName = foodName;
        this.category = category;
        this.kinds = kinds;
        this.restaurantName = restaurantName;
        this.price = price;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getCategory() {
        return category;
    }

    public String getKinds() {
        return kinds;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public Integer getPrice() {
        return price;
    }
}
