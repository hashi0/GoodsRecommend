create database if not exists grms default character set utf8mb4 collate utf8mb4_general_ci;

use grms;

create table if not exists users
(
    user_id  int primary key comment '用户id',
    password varchar(20) default null comment '用户密码'
);

create table if not exists products
(
    product_id    int primary key comment '商品id',
    product_name  varchar(128) default null comment '商品名称',
    department_id int          default null comment '部门id（一级品类id）',
    department    varchar(32)  default null comment '部门名（一级品类名）',
    aisle_id      int          default null comment '货架id（二级品类id）',
    aisle         varchar(32)  default null comment '货架名（二级品类名）'
);

create table if not exists orders
(
    order_id               int          default null comment '订单id',
    user_id                int          default null comment '产生该订单的用户id',
    product_id             int          default null comment '产生该订单的商品id',
    product_name           varchar(128) default null comment '商品名称',
    add_to_cart_order      int          default null comment '添加到购物篮中的商品序号',
    reordered              int          default null comment '复购',
    order_number           int          default null comment '该用户的订单序号',
    order_dow              int          default null comment '星期order of week',
    order_hour_of_day      int          default null comment '小时',
    days_since_prior_order float        default null comment '离上次order的天数'
);

create table if not exists results
(
    user_id      int          default null comment '用户id',
    product_id   int          default null comment '商品id',
    product_name varchar(128) default null comment '商品名称',
    department   varchar(32)  default null comment '部门名（一级品类名）',
    aisle        varchar(32)  default null comment '货架名（二级品类名）',
    exp          int          default null comment '推荐指数'
);