package com.poly.model;

import lombok.Data;

@Data
public class UserDTO {

    private Integer id;

    private String username;

    private String sdt;
    private String  address;

    private int admin;

    private String email;
}
