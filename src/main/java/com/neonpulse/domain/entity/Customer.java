package com.neonpulse.domain.entity;

import com.neonpulse.domain.valueobject.Email;

public class Customer {
  private final String id;
  private String name;
  private Email email; // Atributo blindado por el Value Object

  public Customer(String id, String name, Email email){
    this.id = id;
    this.name = name;
    this.email = email;
  }

  // Metodo con semantica de negocio para actualizar información
  public void updateContactInfo(String newName, Email newEmail){
    this.name = newName;
    this.email = newEmail;
  }

  public String getId(){ 
    return this.id;
  }

  public String getName(){ 
    return this.name;
  }

  public Email getEmail(){ 
    return this.email;
  }

}