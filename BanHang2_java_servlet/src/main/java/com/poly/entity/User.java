package com.poly.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="`users`")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="username")
    private String username;
    @Column
    private String password;
    @Column
    private String address;
    @Column 
    private int admin;
    @Column 
    private String sdt;
    @Column
    private String email;
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
    
    
}
