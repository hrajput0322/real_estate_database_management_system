create database real_estate_database;
use real_estate_database;

create table property_to_sell(
property_id  int,
agent_id int,
seller_id int,
address varchar(100) ,
p_area numeric(10,2) ,
bhk int ,
listing_price numeric(20,5) ,
listing_date date,
bulit_date date ,
p_status varchar(10),
primary key(property_id,agent_id,seller_id)
);

create table property_to_rent(
property_id  int,
agent_id int,
seller_id int,
address varchar(100) ,
p_area numeric(10,2) ,
bhk int ,
listing_price numeric(20,5) ,
listing_date date,
bulit_date date ,
p_status varchar(10),
primary key(property_id,agent_id,seller_id)
);

create table agent(
agent_id int primary key,
a_name varchar(30),
a_password varchar(30),
phone_no numeric(10),
email varchar(30),
selling_commission numeric(5,2),
renting_commission numeric(5,2)
);

create table seller(
seller_id int,
agent_id int,
s_name varchar(30),
phone_no numeric(10),
email varchar(30),
primary key(seller_id,agent_id)
);
desc seller;

create table buyer(
buyer_id int,
agent_id int,
b_name varchar(30),
phone_no numeric(10),
email varchar(30),
primary key(buyer_id,agent_id)
);
desc buyer;

create table transactions(
transaction_id int primary key,
property_id  int,
agent_id int,
buyer_id int,
seller_id int,
transaction_amount numeric(20,5),
total_agent_commission numeric(20,5),
transaction_type varchar(10),
transaction_date date,
lease_period int
);
desc transactions;
desc property_to_rent;
desc property_to_sell;

alter table transactions add foreign key (agent_id) references agent(agent_id);
alter table transactions add foreign key (seller_id) references seller(seller_id);
alter table transactions add foreign key (buyer_id) references buyer(buyer_id);


alter table property_to_sell add foreign key (agent_id) references agent(agent_id);
alter table property_to_rent add foreign key (agent_id) references agent(agent_id);
alter table property_to_sell add foreign key (seller_id) references seller(seller_id);
alter table property_to_rent add foreign key (seller_id) references seller(seller_id);

alter table seller add foreign key (agent_id) references agent(agent_id);
alter table buyer add foreign key (agent_id) references agent(agent_id);


insert into agent values
(1, 'Hritik Pankaj', '1234', 9874563212, 'pankaj@gmail.com', 2, 2.5),
(2, 'Dhaneshwar Das', 'das27', 9874567894, 'dasrox@gmail.com', 2.5, 2.5),
(3, 'Hironami Kanto', 'qwertyhiro', 9456456784, 'hironamikanto@gmail.com', 5,5),
(4, 'Pratyush Anand', 'iloveop', 9456944567, 'pratyushgayanand@gmail.com', 3.5,3),
(5, 'Akshit Moorewala', 'akii96', 9457944567, 'akshitt@gmail.com', 3,2.5),
(6, 'Manish Kumar', 'manishkumar', 9557944567, 'manish@gmail.com', 2,2.5);

insert into buyer values
(1,4, 'Om Patil', 9874256312, 'patil@gmail.com'),
(2,1, 'Harish Verma', 9804257892, 'harish@gmail.com'),
(3,3, 'Aastha Sharma', 9696963314, 'aasthasharma@gmail.com'),
(4,3, 'Pooja Yadav', 9199563120, 'pooja@gmail.com'),
(5,2, 'Pushkar Jadhav', 9789456312, 'pushkar@gmail.com'),
(6,4, 'Vedant Kinni', 9874569312, 'pappi@gmail.com'),
(7,4, 'Aditi Mannikoth', 9478562312, 'aditi@gmail.com'),
(8,5, 'Pranjal Jadhav', 9748523312, 'pranjalmbbs@gmail.com'),
(9,1, 'Mayank Kumar', 9694256312, 'mayankkumar@gmail.com'),
(9,4, 'Mayank Kumar', 9694256312, 'mayankkumar@gmail.com');

insert into seller values
(1,4, 'Twisha Maitrey', 9321256312, 'maitrey@gmail.com'),
(1,2, 'Twisha Maitrey', 9321256302, 'maitrey@gmail.com'),
(1,3, 'Twisha Maitrey', 9321256312, 'maitrey@gmail.com'),
(2,3, 'Aastha Sharma', 9696963314, 'aasthasharma@gmail.com'),
(3,5, 'Mance Rayder', 9198563120, 'ryder@gmail.com'),
(4,1, 'Hardeep', 9569456312, 'pajji@gmail.com'),
(5,2, 'Harnoor Singh', 9896329312, 'harnoor@gmail.com'),
(6,4, 'Ved Vardhan', 9741562456, 'ved@gmail.com'),
(7,5, 'Kappish Jindal', 996321458, 'bhaiyaaa@gmail.com'),
(8,3, 'Michekla Da Silva', 9123256312, 'maichalirussia@gmail.com'),
(9,1, 'Manish Sisodia', 9741256312, 'manishreal@gmail.com'),
(10,4, 'Udit Pandey', 9789256378, 'pandeyreal@gmail.com'),
(11,4, 'Chaitanya Hedulkar', 9374526302, 'chaituu@gmail.com');

insert into property_to_sell values
(1,3,2,'A/102, Gokul enclave, Gokul Township, Virar(west), Mumbai-401303', 1200, 3,17000000,'2022-12-27', '1969-1-12', 'active'),
(2,1,4,'B/103, Modern Colony, Parek Nagar, Andheri(west), Mumbai-478210', 500, 1,3700000,'2021-08-12', '1970-04-12', 'active'),
(3,4,1,'D/1203, Laxmi Classic, Gkoul Township, Virar(west), Mumbai-401303', 3500, 3,32000000,'2021-08-27', '2020-02-02', 'active'),
(3,2,1,'D/1203, Laxmi Classic, Gkoul Township, Virar(west), Mumbai-401303', 3500, 3,32000000,'2021-08-27', '2020-02-02', 'active'),
(3,3,1,'D/1203, Laxmi Classic, Gkoul Township, Virar(west), Mumbai-401303', 3500, 3,32000000,'2021-08-27', '2020-02-02', 'active'),
(4,5,3,'C/202, 6th Block, Global City, Virar(east), Mumbai-401323', 600, 1,3500000,'2022-07-13', '2011-02-12', 'inactive'),
(5,1,9,'C/402, 12th Block, Global City, Virar(east), Mumbai-401323', 400, 1,2700000,'2022-03-24', '2011-02-12', 'inactive'),
(6,4,6,'c/403, Sector 5, Govind nagar, Goregaon(east), Mumbai-401234', 800, 2,6000000,'2020-07-27', '1969-01-24', 'inactive');

insert into property_to_rent values
(1,2,5,'A/201, Modern Colony, Parek Nagar, Andheri(west), Mumbai-478210', 750, 2, 25000, '2021-09-20','1970-04-12','inactive'),
(2,5,7,'H/1403, Evershine village, Vasai(west) Mumbai-401369', 500, 1, 15000, '2021-11-14','1982-08-22','inactive'),
(3,3,8,'A/1201, Evershine village, Vasai(west) Mumbai-401369', 2750, 3, 35000, '2022-11-20','1982-08-22','active'),
(4,4,10,'B/1403, Gokul Arcade, Gokul Township, Virar(west) Mumbai-401303', 1000, 2, 18000, '2021-09-20','1984-12-12','active'),
(5,4,11,'B/201, Gokul Arcade, Gokul Township, Virar(west) Mumbai-401303', 1000, 2, 15000, '2021-09-20','1984-12-12','inactive');

insert into transactions values
(1,4,5,8,3,3000000,90000,'sale','2022-12-12',NULL),
(2,5,1,2,9,2500000,50000,'sale','2022-09-27',NULL),
(3,6,4,1,6,4000000,140000,'sale','2021-01-17',NULL),
(4,1,2,5,5,24000,600,'rent','2021-11-19',11),
(5,2,5,8,7,12000,300,'rent','2021-12-31',11),
(6,5,4,6,11,14000,420,'rent','2021-11-16',15);

insert into agent values
(7, 'Nandan Batra', '1234567', 8874563212, 'nandan@gmail.com', 2, 2.5),
(8, 'Saransh Sharma', 'sar27', 8874567894, 'saransh@gmail.com', 2.5, 2.5),
(9, 'Sanvi Sharma', 'qwertyfds', 8456456784, 'sanvi@gmail.com', 5,5),
(10, 'Gautam Bhattacharya', 'fsdjh', 8456944567, 'gautam@gmail.com', 3.5,3),
(11, 'Siddhu Moosewala', 'gsgrwe', 8457944567, 'siddhu@gmail.com', 3,2.5),
(12, 'James Clear', 'riqeuq', 8557944567, 'james@gmail.com', 2,2.5);


insert into buyer values
(10,10, 'Rohit Sharma', 8874256312, 'rohit@gmail.com'),
(11,7, 'Shikhar Dhawan', 8804257892, 'shikhar@gmail.com'),
(12,10, 'Suresh Raina', 8696963314, 'suresh@gmail.com'),
(13,9, 'Virat Kohli', 8199563120, 'virat@gmail.com'),
(14,8, 'Yuvraj Singh', 8789456312, 'yuvraj@gmail.com'),
(15,10, 'M S Dhoni', 8874569312, 'dhoni@gmail.com'),
(16,10, 'Irfan Pathan', 8478562312, 'irphan@gmail.com'),
(17,11, 'Mohammad Shami', 8748523312, 'shami@gmail.com'),
(18,7, 'Zahir Khan', 8694256312, 'zahir@gmail.com'),
(18,10, 'Zahir Khan', 8694256312, 'zahir@gmail.com');

insert into seller values
(12,10, 'Prashant Saurabh', 8321256312, 'parshant@gmail.com'),
(12,8, 'Prashant Saurabh', 8321256302, 'parshant@gmail.com'),
(12,9, 'Prashant Saurabh', 8321256312, 'parshant@gmail.com'),
(13,9, 'Om Singh', 8696963314, 'omsingh@gmail.com'),
(14,11, 'Abhishek Gupta', 8198563120, 'abhishek@gmail.com'),
(15,7, 'Harsh Gupta', 8569456312, 'harsh@gmail.com'),
(16,8, 'Sumit Ansari', 8896329312, 'sumit@gmail.com'),
(17,10, 'Prachi Pandey', 8741562456, 'prachi@gmail.com'),
(18,11, 'Mallika Muskan', 896321458, 'mallika@gmail.com'),
(19,9, 'Kusmit Kaur', 8123256312, 'kusmit@gmail.com'),
(20,7, 'Madhurima', 8741256312, 'madhurima@gmail.com'),
(21,10, 'Arpita Singh', 8789256378, 'arpita@gmail.com'),
(22,10, 'Swati Gautam', 8374526302, 'swati@gmail.com');

insert into property_to_sell values
(7,9,13,'A/104, Gokul Garande, Gokul Township, Virar(west), Mumbai-401303', 1200, 3,17000000,'2022-12-27', '1969-1-12', 'active'),
(8,7,15,'B/106, Modern Colony, Parek Nagar, Andheri(west), Mumbai-478210', 500, 1,3700000,'2021-08-12', '1970-04-12', 'active'),
(9,10,12,'E/1024, Active Acres, Dhaba, Virar(west), Mumbai-401303', 3500, 3,32000000,'2021-08-27', '2020-02-02', 'active'),
(9,8,12,'E/1024, Active Acres, Dhaba, Virar(west), Mumbai-401303', 3500, 3,32000000,'2021-08-27', '2020-02-02', 'active'),
(9,9,12,'E/1024, Active Acres, Dhaba, Virar(west), Mumbai-401303', 3500, 3,32000000,'2021-08-27', '2020-02-02', 'active'),
(10,11,14,'D/204, Sector 8, Global City, Virar(east), Mumbai-401323', 600, 1,3500000,'2022-07-13', '2011-02-12', 'active'),
(11,7,20,'D/206, Arcade Club, Global City, Dadar(east), Mumbai-401363', 400, 1,2700000,'2022-03-24', '2011-02-12', 'active'),
(12,10,17,'A/403, Sector 5, Govind nagar, Goregaon(east), Mumbai-401234', 800, 2,6000000,'2020-07-27', '1969-01-24', 'active');


insert into property_to_rent values
(6,8,16,'B/407, Sunrise Colony, Shristi Nagar, Andheri(west), Mumbai-478210', 750, 2, 25000, '2021-09-20','1970-04-12','active'),
(7,11,18,'H/1469, Evershine village, Vasai(west) Mumbai-401369', 500, 1, 15000, '2021-11-14','1982-08-22','active'),
(8,9,19,'B/1209, Evershine village, Vasai(west) Mumbai-401369', 2750, 3, 35000, '2022-11-20','1982-08-22','active'),
(9,10,21,'C/1409, Gokul Arcade, Gokul Township, Virar(west) Mumbai-401303', 1000, 2, 18000, '2021-09-20','1984-12-12','active'),
(10,10,22,'E/201, Sector 12, Salt Lake, Virar(west) Mumbai-401303', 1000, 2, 15000, '2021-09-20','1984-12-12','active');

select * from property_to_rent;
select * from transactions;
delete from property_to_rent where property_id=50;
delete from seller where seller_id=134;

ALTER TABLE seller
MODIFY COLUMN phone_no numeric(15,0);

desc seller;
insert into seller values(57833,1,"Wefwef",8630875700,"whdqu@.com");

ALTER TABLE property_to_sell
RENAME COLUMN bulit_date to built_date;

select address, p_area, bhk, listing_price, listing_date, built_date from property_to_rent where address like "%" and p_area>=500 and bhk>=2 and listing_price between 0 and 25000;
select address, p_area, bhk, listing_price, listing_date, built_date from property_to_rent where address like '%' and p_area>=0 and bhk>=0 and listing_price between 0 and 25000;
select property_id, address, p_area, bhk, listing_price, listing_date, built_date from property_to_rent where address like '%' and p_area>=0 and bhk>=0 and listing_price between 0 and 35000 and agent_id=3 and p_status='active';


insert into property_to_rent values
(11,1,15,'C/229, Modern Colony, Shyam Nagar, Andheri(west), Mumbai-478210', 750, 2, 25000, '2021-09-20','1970-04-12','inactive'),
(12,1,17,'H/235, Nehru Colony, Vasai(west) Mumbai-401369', 500, 1, 15000, '2021-11-14','1982-08-22','inactive'),
(13,1,18,'A/331, Sunshine village, Andheri(west) Mumbai-401369', 2750, 3, 35000, '2023-04-10','1982-08-22','active'),
(14,1,20,'B/224, Gokul Arcade, Gokul Township, Virar(west) Mumbai-401303', 1000, 2, 18000, '2023-03-20','2023-01-02','active'),
(15,1,21,'D/212, Gokul Arcade, Gokul Township, Virar(west) Mumbai-401303', 950, 2, 13500, '2023-03-09','2023-01-15','inactive');

insert into property_to_sell values
(15,1,12,'C/105, Gokul enclave, Gokul Township, Virar(west), Mumbai-401303', 1200, 3,17000000,'2023-4-15', '2023-1-12', 'active');
(14,1,14,'D/229, Modern Colony, Parek Nagar, Andheri(west), Mumbai-478210', 500, 1,3700000,'2021-08-12', '1970-04-12', 'active'),
(13,1,9,'E/1213, Laxmi Classic, Gkoul Township, Virar(west), Mumbai-401303', 3500, 3,32000000,'2023-03-27', '2023-02-02', 'active'),
(13,2,9,'E/1213, Laxmi Classic, Gkoul Township, Virar(west), Mumbai-401303', 3500, 3,32000000,'2023-03-27', '2023-02-02', 'active'),
(13,3,9,'E/1213, Laxmi Classic, Gkoul Township, Virar(west), Mumbai-401303', 3500, 3,32000000,'2023-03-27', '2023-02-02', 'active'),
(18,2,13,'B/202, 6th Block, Global City, Virar(east), Mumbai-401323', 600, 1,3500000,'2022-07-13', '2011-02-12', 'inactive'),
(17,1,10,'D/402, 12th Block, Global City, Virar(east), Mumbai-401323', 400, 1,2700000,'2022-03-24', '2011-02-12', 'inactive'),
(16,1,12,'E/403, Sector 5, Govind nagar, Goregaon(east), Mumbai-401234', 800, 2,6000000,'2020-07-27', '1969-01-24', 'inactive');



use real_estate_database;
select seller_id from seller natural join property_to_rent where property_id=14;
insert into seller values (20,1,'Madhurima', 8741256312, 'madhurima@gmail.com');
update property_to_rent set p_status='active' where property_id=14;
select * from property_to_sell;
select * from buyer;
select * from transactions;
delete from buyer where buyer_id=534535 or buyer_id=534536 or buyer_id=534539 or buyer_id=674766;
delete from transactions where buyer_id=53 or buyer_id=55 or buyer_id=79;
select transactions.agent_id,property_id,agent.a_name,transactions.total_agent_commission,address,p_area, bhk, transaction_amount selling_price 
from transactions  join property_to_sell using(agent_id,property_id), agent  
where agent.agent_id=transactions.agent_id and transaction_type='sale';
update property_to_rent set p_status="active" where property_id=14;




#query1
select * from property_to_rent where p_status="active" and year(built_date)>2020 and address like "%Mumbai%";

#query2
select * from property_to_rent where listing_price>=30000 and listing_price<=500000 and address like "%Mumbai%";

#query3
select * from property_to_rent where listing_price<=15000 and address like "%Virar%" and bhk>1;


#query4
create view v2 as (select agent_id,count(agent_id) id_count,sum(transaction_amount) as total_amount from transactions 
where year(transaction_date)=2022 and transaction_type="sale" group by agent_id);
create view v3 as( select agent_id,id_count,total_amount from v2 where id_count=(select max(id_count) from v2));
select a_name,total_amount from agent natural join v3;

#query 5
create view v5 as
(select * from transactions natural join property_to_sell 
where year(transaction_date)=2022 and transaction_type="sale" and p_status="inactive");
create view v6 as
(select agent_id,transaction_amount,listing_date,transaction_date,datediff(transaction_date,listing_date) as on_market_time from v5);
create view v7 as
(select agent_id,avg(transaction_amount),avg(on_market_time) from v6 group by agent_id);
select * from v7;

#query6
select property_id,seller_id,address,p_area,bhk,listing_price,listing_date,bulit_date,p_status from property_to_rent 
where listing_price>=(select max(listing_price) from property_to_rent)
union 
select  property_id ,seller_id,address,p_area,bhk,listing_price,listing_date,built_date,p_status from property_to_sell 
where listing_price>=(select max(listing_price) from property_to_sell);