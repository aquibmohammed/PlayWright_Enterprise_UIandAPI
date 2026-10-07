package com.pm.framework.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProductsResponse {
    @JsonProperty("responseCode")
    private int responseCode;
    @JsonProperty("products")
    private List<Product> products;

    public int getResponseCode() {
        return responseCode;
    }

    public List<Product> getProducts() {
        return products;
    }

    public static class Product{
        private int id;
        private String name;
        private String price;
        private String brand;
        private Category category;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public String getBrand() {
            return brand;
        }

        public Category getCategory() {
            return category;
        }
    }

    public static class Category {

        private UserType usertype;
        private String category;

        public UserType getUsertype() {
            return usertype;
        }

        public String getCategory() {
            return category;
        }
    }

    public static class UserType {

        private String usertype;

        public String getUsertype() {
            return usertype;
        }
    }
}

