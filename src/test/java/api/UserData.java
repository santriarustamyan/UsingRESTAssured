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

    public void setEmail(String email) {
        this.email = email;
    }

    public String setGender() {
        if (Math.random() > 0.5)
            return "male";
        else
            return "female";
    }
    public String setStatus() {
        if (Math.random() > 0.5)
            return "active";
        else
            return "inactive";
    }

    public UserData() {
        Faker faker = new Faker();
        this.name = faker.name().fullName();
        this.email = faker.internet().emailAddress();
        this.gender = setGender();
        this.status = setStatus();
    }


}
