/*create table files (
id bigint not null auto_increment,
fileName varchar(255),
primary key (id)
);*/
/*create table statistics (
id bigint not null auto_increment,
fileId bigint not null,
longWord varchar(255),
shortWord varchar(255),
lengthRow int,
avgLengthRow decimal(5,2),
primary key (id),
index (fileId),
foreign key (fileId) references files(id)
on delete cascade
);*/

/*create table statistics (
fileName varchar(255),
rowNum int,
longWord varchar(255),
shortWord varchar(255),
lengthRow int,
avgLengthRow decimal(5,2),
primary key (fileName, rowNum)
);*/
select * from statistics;