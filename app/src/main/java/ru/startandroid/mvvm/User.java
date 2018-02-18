package ru.startandroid.mvvm;

class User {

    private  int id;
    private String name, username, email, phone, website;

    public User(int id, String name, String username, String email, String phone, String website) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
    }

    @Override
    public String toString() {
        return this.name + " " + this.username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    /*address: {
        street: "Kulas Light",
                suite: "Apt. 556",
                city: "Gwenborough",
                zipcode: "92998-3874",
                geo: {
            lat: "-37.3159",
                    lng: "81.1496"
        }
    },*/
    /*company: {
        name: "Romaguera-Crona",
                catchPhrase: "Multi-layered client-server neural-net",
                bs: "harness real-time e-markets"
    }*/
}
