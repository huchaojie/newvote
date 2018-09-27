create database votedb;

use votedb;

--用户表
create table voteuser
(
  uid   int primary key auto_increment,
  uname varchar(50),
  pwd varchar(50)
)



  
--投票主题
create table votesubject
(
  vsid    int primary key auto_increment,       
  title   varchar( 2000),
  stype int
)



--投票内容对应的选项表
create table voteoption
(
  voteid     int primary key auto_increment,    
  voteoption    VARCHAR(2000) not null,   
  vsid     int not null, 
  voteorder  int not null  
)

alter table voteoption
    add constraint fk_voteoption
       foreign key( vsid) references votesubject(vsid);


--用户投票取值表
create table voteitem
(
  viid      int primary key auto_increment, 
  voteid      int  not null, 
  vsid     int not null, 
  uid int not null 
)




alter table voteitem
    add constraint fk_voteitem_voteid
       foreign key( voteid) references voteoption(voteid);
alter table voteitem
    add constraint fk_voteitem_vsid
       foreign key( vsid) references votesubject(vsid);
alter table voteitem
    add constraint fk_voteitem_uid
       foreign key( uid) references voteuser(uid);

