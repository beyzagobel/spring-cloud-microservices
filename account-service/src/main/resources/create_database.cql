CREATE KEYSPACE IF NOT EXISTS account_service WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };


CREATE TABLE accounts(
    id text PRIMARY KEY ,
    account_username text,
    account_email text,
    account_password text,
    account_created_at date,
    account_is_active Boolean
);

select * from accounts