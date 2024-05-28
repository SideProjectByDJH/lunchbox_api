package com.djh.lunchbox_api.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "menu_posts")
@Data
public class MenuPost {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;
}
