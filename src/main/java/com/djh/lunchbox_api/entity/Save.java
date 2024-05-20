package com.djh.lunchbox_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Save {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
}
