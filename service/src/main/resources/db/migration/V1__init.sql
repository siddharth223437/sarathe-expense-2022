-- DROP ALL OBJECTS;
create sequence hibernate_sequence start with 1 increment by 1;

create table house
(
    house_id  INT not null,
    house_name varchar(30) not null,
    street1 varchar(30) not null,
    street2 varchar(30)  null,
    city varchar(30) not null,
    state varchar(30) not null,
    country varchar(30) not null,
    postal_code varchar(10) not null,
    address_type varchar(10) not null,
    created_by  varchar(30) not null ,
    created_ts  timestamp(9) not null ,
    last_upd_by varchar(30) not null ,
    last_upd_ts timestamp(9) not null
);

alter table house add constraint house_pk primary key (house_id);

create table member
(
    member_id INT not null,
    username varchar(30) not null,
    first_name varchar(30) not null,
    middle_name varchar(30) ,
    last_name varchar(30) not null,
    email varchar(30) not null,
    dob varchar(30) not null,
    age INT not null,
    phone_number varchar(10) not null,
    house_id  INT not null,
    is_active varchar(20) not null,
    created_by  varchar(30) not null ,
    created_ts  timestamp(9) not null ,
    last_upd_by varchar(30) not null ,
    last_upd_ts timestamp(9) not null
);

alter table member add constraint member_pk primary key (member_id);
alter table member add constraint house_member_fk foreign key (house_id) references house (house_id);

create table roles
(
    role_id INT not null,
    role_name varchar(30) not null,
    created_by  varchar(30) not null ,
    created_ts  timestamp(9) not null ,
    last_upd_by varchar(30) not null ,
    last_upd_ts timestamp(9) not null
);

alter table roles add constraint role_pk primary key  (role_id);

create table member_role
(
    member_id INT not null,
    role_id INT not null
);
alter table member_role add constraint member_role_pk primary key  (member_id, role_id);
alter table member_role add constraint member_role_fk1 foreign key (member_id) references member;
alter table member_role add constraint member_role_fk2 foreign key (role_id) references roles;

create table expense
(
    expense_id INT not null,
    transaction_id varchar(45) not null unique ,
    amount float not null,
    category varchar(30) not null,
    notes varchar(30),
    payment_type varchar(30) not null,
    expense_date varchar(30) not null,
    expense_paid_by varchar(30) not null,
    member_id INT not null,
    created_by  varchar(30) not null ,
    created_ts  timestamp(9) not null ,
    last_upd_by varchar(30) not null ,
    last_upd_ts timestamp(9) not null
);

alter table expense add constraint expense_pk primary key (expense_id);
alter table expense add constraint expense_member_fk foreign key (member_id) references member (member_id);