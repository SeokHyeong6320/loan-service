create table USER_INFO
(
    usr_id      BIGINT auto_increment,
    usr_key     varchar(100) not null,
    usr_reg_num varchar(100) not null,
    usr_nm      varchar(20) not null,
    usr_inc_amt BIGINT      not null,
    constraint user_info_pk
        primary key (usr_id),
    constraint user_info_pk_2
        unique (usr_key)
);


create table PRODUCT_INFO
(
    prod_id       Bigint auto_increment,
    org_cd        varchar(5),
    prod_cd       varchar(3),
    prod_nm       varchar(100),
    prod_min_intr DOUBLE,
    prod_max_intr DOUBLE,
    constraint product_info_pk
        primary key (prod_id)
);