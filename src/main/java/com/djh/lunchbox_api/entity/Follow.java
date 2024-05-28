package com.djh.lunchbox_api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "follows")
@Data
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

    @ManyToOne
    @JoinColumn(name = "followee_id")
    private User followee;
}
