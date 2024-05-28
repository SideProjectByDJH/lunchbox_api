create table lunchbox.ingredients
(
    id              bigint       not null
        primary key,
    ingredient_name varchar(255) null
);

create table lunchbox.menus
(
    id        bigint       not null
        primary key,
    menu_name varchar(255) null
);

create table lunchbox.users
(
    enabled           bit          not null,
    id                bigint       not null
        primary key,
    email             varchar(255) null,
    nickname          varchar(255) null,
    password          varchar(255) null,
    profile_image_url varchar(255) null
);

create table lunchbox.follows
(
    followee_id bigint null,
    follower_id bigint null,
    id          bigint not null
        primary key
);

create table lunchbox.posts
(
    eat_date  datetime(6)  null,
    id        bigint       not null
        primary key,
    user_id   bigint       null,
    image_url varchar(255) null
);

create table lunchbox.ingredient_posts
(
    id            bigint not null
        primary key,
    ingredient_id bigint null,
    post_id       bigint null
);

create table lunchbox.likes
(
    id      bigint not null
        primary key,
    post_id bigint null,
    user_id bigint null
);

create table lunchbox.menu_posts
(
    id      bigint not null
        primary key,
    menu_id bigint null,
    post_id bigint null
);

create table lunchbox.saves
(
    id      bigint not null
        primary key,
    post_id bigint null,
    user_id bigint null
);

