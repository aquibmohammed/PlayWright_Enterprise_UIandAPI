package com.pm.framework.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BrandsResponse {

        @JsonProperty("responseCode")
        private int responseCode;

        @JsonProperty("brands")
        private List<Brand> brands;

        public int getResponseCode() {
            return responseCode;
        }

        public List<Brand> getBrands() {
            return brands;
        }

        public static class Brand {

            private int id;
            private String brand;

            public int getId() {
                return id;
            }

            public String getBrand() {
                return brand;
            }
        }
    }