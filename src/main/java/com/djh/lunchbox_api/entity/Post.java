package com.djh.lunchbox_api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.ZonedDateTime;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imageUrl;

    private ZonedDateTime eat_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
