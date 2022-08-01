package api;

import com.github.javafaker.Faker;

public class UserData {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String status;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getGender() {
        return gender;
    }
    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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


