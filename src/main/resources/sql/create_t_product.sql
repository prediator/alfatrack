create table T_PRODUCT (
  PRODUCT_ID int(11) not null auto_increment,
  PRODUCT_NAME varchar(127) not null,
  GROUP_ID int(11) not null,
  PRODUCT_PRICE decimal(10,2) not null,
  primary key (PRODUCT_ID),
  unique key PRODUCT_NAME_UNIQUE (PRODUCT_NAME),
  key FK_GROUP_ID (GROUP_ID),
  constraint FK_GROUP_ID foreign key (GROUP_ID) references T_GROUP (GROUP_ID)
)