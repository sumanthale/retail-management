


insert into PRODUCT(id,price,description,name,image,rating) values (1001,100, 'Iphone', 'Apple', 'url', 2);
insert into PRODUCT(id,price,description,name,image,rating) values (1002,100, 'Andriod', 'Google', 'url', 2);
insert into PRODUCT(id,price,description,name,image,rating) values (1003,100, 'Windows', 'MicroSoft', 'url', 2);

insert into vendor(id,delivery_charge,name,rating) values (2001, 100 ,'Sumanth', 2);
insert into vendor(id,delivery_charge,name,rating) values (2002, 150 ,'ale', 5);
insert into vendor(id,delivery_charge,name,rating) values (2003, 200 ,'sunny', 2);


insert into Cart(id,product_id,vendor_id,deliverydate, zipcode) values (3001,1001, 2001, 'code', 'date');
insert into Cart(id,product_id,vendor_id,deliverydate, zipcode) values (3002,1002, 2002, 'code', 'date');
insert into Cart(id,product_id,vendor_id,deliverydate, zipcode) values (3003,1003, 2003, 'code', 'date');


 insert into product_vendor(expected_date,stock,product_id,vendor_id) values ('today',2,1001,2001);
 insert into product_vendor(expected_date,stock,product_id,vendor_id) values ('today',2,1001,2002);
 insert into product_vendor(expected_date,stock,product_id,vendor_id) values ('today',2,1001,2003);
 insert into product_vendor(expected_date,stock,product_id,vendor_id) values ('today',2,1002,2001);
 insert into product_vendor(expected_date,stock,product_id,vendor_id) values ('today',2,1002,2002);