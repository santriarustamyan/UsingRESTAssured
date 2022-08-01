package api;

import com.github.javafaker.Faker;

public class UserData {
    public int id;
    public String name;
    public String email;
    public String gender;
    public String status;

    public UserData() {
        Faker faker = new Faker();
        this.name = faker.name().fullName();
        this.email = faker.internet().emailAddress();
        this.gender = "male";
        this.status = "active";
    }

    public UserData(String email) {
        Faker faker = new Faker();
        this.name = faker.name().fullName();
        this.email = email;
        this.gender = "male";
        this.status = "active";
    }





}


