create database if not exists grms default character set utf8mb4 collate utf8mb4_general_ci;

use grms;

create table if not exists users (
    id     int primary key auto_increment comment '用户id',
    passwd varchar(20)       default null comment '用户密码',
    name   varchar(20)       default null comment '姓名',
    age    int               default null,
    gender enum ('nan','nv') default null
);

create table if not exists goods (
    id          int primary key auto_increment comment '商品id',
    name        varchar(20)  default null comment '商品名称',
    price       double(10,2) default null comment '商品价格',
    description text comment '商品描述'
);

create table if not exists orders (
    id  int primary key auto_increment comment '订单id',
    uid int default null comment '产生该订单的用户id',
    gid int default null comment '产生该订单的商品id'
);

create table if not exists results (
    id  int primary key auto_increment comment '推荐结果id',
    uid int default null comment '用户id',
    gid int default null comment '商品id',
    exp int default null comment '推荐指数'
);
