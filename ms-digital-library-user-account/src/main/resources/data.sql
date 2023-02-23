ALTER TABLE IF EXISTS user_account
    DROP CONSTRAINT IF EXISTS pk_user_account;
ALTER TABLE IF EXISTS user_account
    DROP CONSTRAINT IF EXISTS fk_accounts_ref_profiles;
ALTER TABLE IF EXISTS user_profile
    DROP CONSTRAINT IF EXISTS pk_user_profile;
DROP TABLE IF EXISTS user_account;
DROP SEQUENCE IF EXISTS user_account_seq;
DROP TABLE IF EXISTS user_profile;
DROP SEQUENCE IF EXISTS user_profile_seq;

create sequence user_account_seq
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;

create sequence user_profile_seq
    start with 1
    increment by 1
    maxvalue 99999
    minvalue 1;



create table user_profile
(
    user_profile_id int default nextval('user_profile_seq'),
    first_name      varchar(80)  not null,
    last_name       varchar(80)  not null,
    full_name       varchar(120) not null,
    email           varchar(80)  not null,
    CONSTRAINT pk_user_profile PRIMARY KEY (user_profile_id)
);

create table user_account
(
    user_account_id     int     default nextval('user_account_seq'),
    user_name           varchar(20)  not null,
    email               varchar(120) not null,
    password            varchar(100) not null,
    user_account_status BOOLEAN DEFAULT TRUE,
    user_profile_id     int          not null,
    CONSTRAINT pk_user_account PRIMARY KEY (user_account_id),
    CONSTRAINT fk_accounts_ref_profiles FOREIGN KEY (user_profile_id)
        REFERENCES public.user_profile (user_profile_id) ON DELETE CASCADE
);

insert into user_profile (first_name, last_name, full_name, email)
values ('VICTOR KEVIN', 'MATOS SECCE', 'VICTOR MATOS', 'VICTORKEVIN.MS@GMAIL.COM');

insert into user_account (user_name, email, password, user_account_status, user_profile_id)
values ('MSVICTOR', 'VICTORKEVIN.MS@GMAIL.COM', '7f7a118ce32efe4d17ad128f5be4f4878e11342ea3a51a2da51a79bd50ba046b',
        true, 1);
