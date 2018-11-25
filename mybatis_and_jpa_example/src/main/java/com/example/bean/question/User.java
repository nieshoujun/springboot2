package com.example.bean.question;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    public User(){
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private Date birthday;
    @Column(nullable = false)
    private String sex;
    @Column(nullable = false)
    private String address;
}
