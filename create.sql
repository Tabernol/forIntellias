create table fruits (fruit_id number(19,0) generated as identity, fruit_name varchar2(255 char), fruit_price double precision not null, primary key (fruit_id));
create table my_user (user_id number(19,0) generated as identity, user_amount number(10,0) not null, user_name varchar2(255 char), user_surname varchar2(255 char), primary key (user_id));
create table fruits (fruit_id number(19,0) generated as identity, fruit_name varchar2(255 char), fruit_price double precision not null, primary key (fruit_id));
create table my_user (user_id number(19,0) generated as identity, user_amount number(10,0) not null, user_name varchar2(255 char), user_surname varchar2(255 char), primary key (user_id));
