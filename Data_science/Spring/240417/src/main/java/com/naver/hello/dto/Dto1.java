package com.naver.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Dto1 {
    private String name;
    private int age;
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class Car {
        private String brand;
        @JsonProperty(value = "car_number")
        private String carNumber;

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCarNumber() {
            return carNumber;
        }

        public void setCarNumber(String carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + brand + '\'' +
                    ", carNumber='" + carNumber + '\'' +
                    '}';
        }
    }
}
