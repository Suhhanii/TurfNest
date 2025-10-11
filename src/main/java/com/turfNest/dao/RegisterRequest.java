package com.turfNest.dao;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String first_name;
    private String last_name;
    private String email;
    private String contact;
    private String address;
    private String password;
    private String account_type;


}
