create database bankmanagementsystem;

use bankmanagementsystem;

create table signup(formno varchar(20),name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20),email varchar(30), marital_status varchar(20), address varchar(40), city varchar(25), pincode varchar(20), state varchar(25));

-- 4 - Create the second table to store more information of user

create table signuptwo(formno varchar(20), religion varchar(20), category varchar(20), income varchar(20), education varchar(20), occupation varchar(20), pan varchar(20), aadhar varchar(20), seniorcitizen varchar(20), existingaccount varchar(20));

-- 5 - Create the third table to store the account information of user

create table signupthree(formno varchar(20), accountType varchar(40), cardnumber varchar(25), pin varchar(10), facility varchar(100)); 

-- 6 - Create the Login table to store login information

create table login(formno varchar(20), cardnumber varchar(25), pin varchar(10));

-- 7 - Now create bank table to store transactions related information 

create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));

create table balance(pin varchar(10),amount int) ;


