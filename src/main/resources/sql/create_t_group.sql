create table T_GROUP (
  GROUP_ID int(11) not null auto_increment,
  GROUP_NAME varchar(127) not null,
  primary key (GROUP_ID),
  unique key GROUP_NAME_UNIQUE (GROUP_NAME)
)