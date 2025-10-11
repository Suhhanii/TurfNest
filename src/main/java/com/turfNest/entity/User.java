package com.turfNest.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="userdata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId ;

    @Column(nullable=false)
    private String first_name;

     @Column(nullable=false)
    private String last_name;

    @Column(nullable=false,unique = true)
    private String email;
    
    @Column(nullable=false)
    private String contact;

    private String address;

    @Column(nullable=false)
    private String password;
    
    private String account_type;
    


}


