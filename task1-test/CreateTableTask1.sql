create table departments (id bigint not null AUTO_INCREMENT,
    
depName varchar(20),
    
depAddress varchar(20),
    
depRating int,
    
dateCreate timestamp,
    
depState boolean,
    
depAbout varchar(50),
    
primary key(id));