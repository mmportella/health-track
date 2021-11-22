-- Gerado por Oracle SQL Developer Data Modeler 21.2.0.183.1957
--   em:        2021-11-20 17:40:46 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE t_alimento (
    id_alimento        NUMBER(10) NOT NULL,
    dt_alimento        TIMESTAMP(0),
    categoria          VARCHAR2(30),
    kcal               NUMBER(4),
    descricao          VARCHAR2(30),
    usuario_id_usuario NUMBER(9) NOT NULL
);

ALTER TABLE t_alimento ADD CONSTRAINT alimento_pk PRIMARY KEY ( id_alimento );

CREATE TABLE t_atividade (
    id_atividade       NUMBER(10) NOT NULL,
    dt_atividade       TIMESTAMP(0),
    categoria          VARCHAR2(20),
    kcal               NUMBER(4),
    descricao          VARCHAR2(20),
    usuario_id_usuario NUMBER(9) NOT NULL
);

ALTER TABLE t_atividade ADD CONSTRAINT atividade_pk PRIMARY KEY ( id_atividade );

CREATE TABLE t_peso (
    id_peso            NUMBER(10) NOT NULL,
    peso               NUMBER(4, 1),
    dt_pesagem         DATE,
    usuario_id_usuario NUMBER(9) NOT NULL
);

ALTER TABLE t_peso ADD CONSTRAINT peso_pk PRIMARY KEY ( id_peso );

CREATE TABLE t_pressao (
    id_pressao         NUMBER(10) NOT NULL,
    pressao_sistolica  NUMBER(3),
    pressao_diastolica NUMBER(3),
    dt_medicao         DATE,
    usuario_id_usuario NUMBER(9) NOT NULL
);

ALTER TABLE t_pressao ADD CONSTRAINT pressao_pk PRIMARY KEY ( id_pressao );

CREATE TABLE t_usuario (
    id_usuario    NUMBER(9) NOT NULL,
    nome_usuario  VARCHAR2(20),
    dt_nascimento DATE,
    genero        VARCHAR2(1),
    altura        NUMBER(3),
    email         VARCHAR2(60),
    senha         VARCHAR2(30)
);

ALTER TABLE t_usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE t_alimento
    ADD CONSTRAINT alimento_usuario_fk FOREIGN KEY ( usuario_id_usuario )
        REFERENCES t_usuario ( id_usuario );

ALTER TABLE t_atividade
    ADD CONSTRAINT atividade_usuario_fk FOREIGN KEY ( usuario_id_usuario )
        REFERENCES t_usuario ( id_usuario );

ALTER TABLE t_peso
    ADD CONSTRAINT peso_usuario_fk FOREIGN KEY ( usuario_id_usuario )
        REFERENCES t_usuario ( id_usuario );

ALTER TABLE t_pressao
    ADD CONSTRAINT pressao_usuario_fk FOREIGN KEY ( usuario_id_usuario )
        REFERENCES t_usuario ( id_usuario );


CREATE SEQUENCE  "RM87099"."SEQ_USUARIO"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 6 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

CREATE SEQUENCE  "RM87099"."SEQ_PRESSAO"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 19 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

CREATE SEQUENCE  "RM87099"."SEQ_PESO"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 29 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

CREATE SEQUENCE  "RM87099"."SEQ_ATIVIDADE"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 10 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

CREATE SEQUENCE  "RM87099"."SEQ_ALIMENTO"  MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 14 NOCACHE  NOORDER  NOCYCLE  NOKEEP  NOSCALE  GLOBAL ;

-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                              9
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
