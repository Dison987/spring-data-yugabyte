package com.yugabyte.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "employee")
public class Employee implements Persistable<String> {

@Id
private String id;
private String name;
private String email;

@Transient
private Boolean isInsert = true;

// Add Empty Constructor, Constructor, and Getters/Setters

public Employee() {}

public Employee(String id, String name, String email) {
  super();
  this.id = id;
  this.name = name;
  this.email = email;
}

@Override
public String getId() {
  return id;
}

public void setId(String id) {
  this.id = id;
}

public String getName() {
  return name;
}

public void setName(String name) {
  this.name = name;
}

public String getEmail() {
  return email;
}

public void setEmail(String email) {
  this.email = email;
}

@Override
public boolean isNew() {
  return isInsert;
}

}
