
--   tipo:      Oracle Database 11g

CREATE TABLE t_hlt_activity (
    dt_activity                  DATE NOT NULL,
    nr_activity                  NUMBER(2) NOT NULL,
    t_hlt_user_id_user           NUMBER NOT NULL,
    t_hlt_actv_type_id_actv_type NUMBER(8) NOT NULL,
    nr_duration                  NUMBER(3) NOT NULL,
    nr_kcal                      NUMBER(4) NOT NULL
);

ALTER TABLE t_hlt_activity
    ADD CONSTRAINT activity_pk PRIMARY KEY ( dt_activity,
                                             nr_activity,
                                             t_hlt_user_id_user,
                                             t_hlt_actv_type_id_actv_type );

CREATE TABLE t_hlt_actv_type (
    id_actv_type NUMBER(8) NOT NULL,
    ds_actv_type VARCHAR2(40) NOT NULL,
    nr_kcal_hour NUMBER(4, 1) NOT NULL
);

ALTER TABLE t_hlt_actv_type ADD CONSTRAINT actv_type_pk PRIMARY KEY ( id_actv_type );

CREATE TABLE t_hlt_food (
    id_food       NUMBER(8) NOT NULL,
    ds_food       VARCHAR2(30) NOT NULL,
    nr_gr_portion NUMBER(4, 1) NOT NULL,
    nr_kcal_gr    NUMBER(5, 3) NOT NULL,
    nr_carb_gr    NUMBER(4, 3) NOT NULL,
    nr_prot_gr    NUMBER(4, 3) NOT NULL,
    nr_fat_gr     NUMBER(4, 3) NOT NULL
);

ALTER TABLE t_hlt_food ADD CONSTRAINT food_pk PRIMARY KEY ( id_food );

CREATE TABLE t_hlt_heart (
    dt_heart           DATE NOT NULL,
    nr_bpm             NUMBER(3),
    nr_systolic        NUMBER(3),
    nr_diastolic       NUMBER(3),
    t_hlt_user_id_user NUMBER NOT NULL
);

ALTER TABLE t_hlt_heart ADD CONSTRAINT heart_pk PRIMARY KEY ( dt_heart,
                                                              t_hlt_user_id_user );

CREATE TABLE t_hlt_meal (
    dt_meal            DATE NOT NULL,
    nr_meal            NUMBER(2) NOT NULL,
    t_hlt_user_id_user NUMBER NOT NULL,
    ds_meal            VARCHAR2(20) NOT NULL,
    nr_kcal            NUMBER(6, 2) NOT NULL,
    nr_carb            NUMBER(6, 2) NOT NULL,
    nr_prot            NUMBER(6, 2) NOT NULL,
    nr_fat             NUMBER(6, 2) NOT NULL
);

ALTER TABLE t_hlt_meal
    ADD CONSTRAINT meal_pk PRIMARY KEY ( dt_meal,
                                         nr_meal,
                                         t_hlt_user_id_user );

CREATE TABLE t_hlt_meal_food (
    t_hlt_meal_t_hlt_user_id_user NUMBER NOT NULL,
    t_hlt_meal_dt_meal            DATE NOT NULL,
    t_hlt_meal_nr_meal            NUMBER(2) NOT NULL,
    t_hlt_food_id_food            NUMBER(8) NOT NULL,
    qt_consumed                   NUMBER(6, 2) NOT NULL
);

ALTER TABLE t_hlt_meal_food
    ADD CONSTRAINT meal_food_pk PRIMARY KEY ( t_hlt_meal_dt_meal,
                                              t_hlt_meal_nr_meal,
                                              t_hlt_meal_t_hlt_user_id_user,
                                              t_hlt_food_id_food );

CREATE TABLE t_hlt_user (
    id_user      NUMBER NOT NULL,
    ds_email     VARCHAR2(60) NOT NULL,
    ds_password  VARCHAR2(60) NOT NULL,
    ds_name      VARCHAR2(60) NOT NULL,
    dt_birthdate DATE NOT NULL,
    nr_height    NUMBER(3) NOT NULL,
    ds_gender    CHAR(1) NOT NULL
);

ALTER TABLE t_hlt_user ADD CONSTRAINT user_pk PRIMARY KEY ( id_user );

CREATE TABLE t_hlt_weight (
    dt_weight          DATE NOT NULL,
    t_hlt_user_id_user NUMBER NOT NULL,
    nr_weight          NUMBER(4, 1) NOT NULL,
    nr_bodyfat         NUMBER(3, 1),
    nr_muscle          NUMBER(3, 1),
    nr_visceral        NUMBER(3, 1)
);

ALTER TABLE t_hlt_weight ADD CONSTRAINT weight_pk PRIMARY KEY ( dt_weight,
                                                                t_hlt_user_id_user );

ALTER TABLE t_hlt_activity
    ADD CONSTRAINT activity_type_fk FOREIGN KEY ( t_hlt_actv_type_id_actv_type )
        REFERENCES t_hlt_actv_type ( id_actv_type );

ALTER TABLE t_hlt_activity
    ADD CONSTRAINT activity_user_fk FOREIGN KEY ( t_hlt_user_id_user )
        REFERENCES t_hlt_user ( id_user );

ALTER TABLE t_hlt_meal_food
    ADD CONSTRAINT food_meal_fk FOREIGN KEY ( t_hlt_meal_dt_meal,
                                              t_hlt_meal_nr_meal,
                                              t_hlt_meal_t_hlt_user_id_user )
        REFERENCES t_hlt_meal ( dt_meal,
                                nr_meal,
                                t_hlt_user_id_user );

ALTER TABLE t_hlt_heart
    ADD CONSTRAINT heart_user_fk FOREIGN KEY ( t_hlt_user_id_user )
        REFERENCES t_hlt_user ( id_user );

ALTER TABLE t_hlt_meal_food
    ADD CONSTRAINT meal_food_fk FOREIGN KEY ( t_hlt_food_id_food )
        REFERENCES t_hlt_food ( id_food );

ALTER TABLE t_hlt_meal
    ADD CONSTRAINT meal_user_fk FOREIGN KEY ( t_hlt_user_id_user )
        REFERENCES t_hlt_user ( id_user );

ALTER TABLE t_hlt_weight
    ADD CONSTRAINT weight_user_fk FOREIGN KEY ( t_hlt_user_id_user )
        REFERENCES t_hlt_user ( id_user );


CREATE SEQUENCE SQ_USER
INCREMENT BY 1
START WITH 1
MAXVALUE 99999999
NOCACHE
NOORDER
NOCYCLE;