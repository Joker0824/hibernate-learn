package com.swx.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * 持久化类,尽量使用包装类的类型
 */
@Entity
@Table(name = "person", schema = "hibernate", catalog = "")
public class PersonEntity {
  private int id;
  private String address;
  private String gender;
  private String name;
  private String dob;
  private String email;
  private String mobile;

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }


  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Basic
  @Column(name = "gender")
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Basic
  @Column(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Basic
  @Column(name = "dob")
  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }

  @Basic
  @Column(name = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Basic
  @Column(name = "mobile")
  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PersonEntity that = (PersonEntity) o;
    return id == that.id &&
            Objects.equals(address, that.address) &&
            Objects.equals(gender, that.gender) &&
            Objects.equals(name, that.name) &&
            Objects.equals(dob, that.dob) &&
            Objects.equals(email, that.email) &&
            Objects.equals(mobile, that.mobile);
  }

  @Override
  public String toString() {
    return "PersonEntity{" +
            "id=" + id +
            ", address='" + address + '\'' +
            ", gender='" + gender + '\'' +
            ", name='" + name + '\'' +
            ", dob='" + dob + '\'' +
            ", email='" + email + '\'' +
            ", mobile='" + mobile + '\'' +
            '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, address, gender, name, dob, email, mobile);
  }
}
