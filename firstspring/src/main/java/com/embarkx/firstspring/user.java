package com.embarkx.firstspring;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class user {
    @id
    int id;
    String Name;
    String Email;

    public user(int id, String name, String email) {
        this.id = id;
        Name = name;
        Email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
