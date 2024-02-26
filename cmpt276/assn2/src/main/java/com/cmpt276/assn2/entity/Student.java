package com.cmpt276.assn2.entity;

import jakarta.persistence.*;

@Entity
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String name;
  private Double weight;
  private Double height;
  private String hairColor;
  private Double gpa;

  // Default constructor
  public Student() {
  }

  // Constructor with all parameters
  public Student(String name, Double weight, Double height, String hairColor, Double gpa) {
    this.name = name;
    this.weight = weight;
    this.height = height;
    this.hairColor = hairColor;
    this.gpa = gpa;
  }

  // Getters and setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public String getHairColor() {
    return hairColor;
  }

  public void setHairColor(String hairColor) {
    this.hairColor = hairColor;
  }

  public Double getGpa() {
    return gpa;
  }

  public void setGpa(Double gpa) {
    this.gpa = gpa;
  }
}

// package com.cmpt276.assn2.entity;

// public class Student {

// }
