package com.example.springbootupdate.user;

import com.example.springbootupdate.entity.User;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String confirmationToken;
    private LocalDate createdDate;
    @OneToOne(targetEntity = User.class,fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name = "user_id")
    private User user;

    ConfirmationToken(User user){
        this.user=user;
        this.createdDate=LocalDate.now();
        this.confirmationToken= UUID.randomUUID().toString();
    }
}
