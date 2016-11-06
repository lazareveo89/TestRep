create table statistics (
fileName varchar(255),
rowNum int,
longWord varchar(255),
shortWord varchar(255),
lengthRow int,
avgLengthRow decimal(5,2),
primary key (fileName, rowNum)
);