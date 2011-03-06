package com.pogodin.jdbcTM;

import java.util.Set;
import java.util.HashSet;

public class Driver {
  private Long id;
  private String name;
  private String surname;
  private int age;
  private Set busses = new HashSet();

  public Driver() {
  }
  public void setBusses(Set busses) {
    this.busses = busses;
  }
   public Set getBusses() {
    return busses;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public Long getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public String getSurname() {
    return surname;
  }
  public int getAge() {
    return age;
  }
}
