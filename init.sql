create database myproject;

create table staff_basic(
staff_id int primary key auto_increment,
staff_name varchar(20) not null,
staff_tel varchar(20) not null,
staff_path varchar(50),
staff_salary int not null,
staff_age int,
staff_sex enum('男','女'),
staff_status int default '1',
staff_check int default '0',
staff_remarks varchar(100)
)

create table company_basic(
company_id int primary key auto_increment,
company_name varchar(20) not null,
company_path varchar(40) not null,
company_contacts varchar(20) not null,
company_tel varchar(30) not null,
company_pass int default '0',
company_create_time varchar(50) not null
)

create table lease_record(
lease_id int primary key auto_increment,
lease_mar int not null,
lease_com int not null,
lease_price double not null,
lease_create_time varchar(50) not null
)

create table materials_basic(
mat_id int primary key auto_increment,
mat_name varchar(20) not null,
mat_count int not null,
mat_out int default '0',
mat_residue int not null,
mat_unit varchar(10) not null
)

create table lease_capital(
cap_id int primary key auto_increment,
cap_count int not null,
cap_price double not null,
cap_mat int not null
)