package com.neonpulse.domain;

import com.neonpulse.domain.valueObject.Email;

public class Customer {
    private final String id;
    private String name;
    private Email email; //atributo blindado por el valueObject

    public Customer(String id, String name, Email email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void updateContactInfo(String newName, Email newEmail) {
        this.name = newName;
        this.email = newEmail;
    }

    public String getId() {
        return this.id;
    }

    public String getNAme() {
        return this.name;
    }

    public Email getEmail() {
        return this.email;
    }
}
