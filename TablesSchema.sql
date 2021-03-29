
DELETE if EXISTS  UbuntuServerProject;
CREATE DATABASE UbuntuServerProject;
USE UbuntuServerProject;

/*If you want to see the information of tables
    put in the prompt show tables and see all the tables created,
    if you want to see the settings of specific table, put
    describe {table name}
 */

create table user_preferences(

    currently_status varchar(15) not null,
    code_preferences varchar(200) not null,
    ranking int default 0,
    experience TEXT

);

create table users (
    
    user_id int(11) PRIMARY KEY auto_increment,
    user_name varchar(50) not null,
    user_last_name varchar(50) not null,
    user_crated datetime(6) not null,
    user_birth datetime(6) not null,
    user_status varchar(10) not null,
    user_phone_number varchar(25) null,
    user_gender varchar(10) not null,
    user_email varchar(30) not null,
    user_password varchar(120) not null
);
create table post_preferences (
    
    post_id int(11) PRIMARY KEY auto_increment,
    post_content TEXT,
    post_date date,
    post_modify_date date,
    user_id int ,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);



/**
    the "likes" methods if fot every user
    a lot of user can "like" any post and 
    one like is for one user

    @OneToMany liked post
    
    rule:
        if the post has been liked by you,
        and again like the post, then, the like
        stored is removed from the database
        
 */







