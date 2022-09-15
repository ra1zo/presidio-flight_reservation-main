package com.presidio.presidio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User extends AbstractEntity {


    @Column(nullable = false,unique=true ,length=45)
    private String email;

    @Column(nullable = false,length=64)
    private String password;

    @Column(nullable = false,length=20)
    private String fullName;

    public User() {
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



}
