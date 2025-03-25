package com.naver.hello.objectmapper;

public class User {
    private String name;
    private int age;
    public User(){}
    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
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
    public static class Builder {
        private String name;
        private int age;
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public User build() {
            return new User(this);
        }
    }
}
