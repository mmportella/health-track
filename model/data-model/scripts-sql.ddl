-- Gerado por Oracle SQL Developer Data Modeler 21.2.0.183.1957
--   em:        2021-08-20 19:24:47 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE t_hlt_agua (
    dt_agua                  DATE NOT NULL,
    nr_registro_dia          NUMBER(2) NOT NULL,
    t_hlt_usuario_id_usuario NUMBER(8) NOT NULL,
    qt_consumida             NUMBER(4) NOT NULL
);

ALTER TABLE t_hlt_agua
    ADD CONSTRAINT agua_pk PRIMARY KEY ( dt_agua,
                                         nr_registro_dia,
                                         t_hlt_usuario_id_usuario );

CREATE TABLE t_hlt_alimento (
    id_alimento  NUMBER(8) NOT NULL,
    ds_alimento  VARCHAR2(30) NOT NULL,
    nr_gr_porcao NUMBER(4, 1) NOT NULL,
    nr_kcal_gr   NUMBER(4, 3) NOT NULL,
    nr_carbo_gr  NUMBER(4, 3) NOT NULL,
    nr_prot_gr   NUMBER(4, 3) NOT NULL,
    nr_gord_gr   NUMBER(4, 3) NOT NULL
);

ALTER TABLE t_hlt_alimento ADD CONSTRAINT alimento_pk PRIMARY KEY ( id_alimento );

CREATE TABLE t_hlt_ativo (
    id_ativo NUMBER(8) NOT NULL,
    ds_ativo VARCHAR2(30) NOT NULL
);

ALTER TABLE t_hlt_ativo ADD CONSTRAINT ativo_pk PRIMARY KEY ( id_ativo );

CREATE TABLE t_hlt_coracao (
    dt_coracao               DATE NOT NULL,
    t_hlt_usuario_id_usuario NUMBER(8) NOT NULL,
    nr_bpm                   NUMBER(3),
    nr_sistolica             NUMBER(3),
    nr_diastolica            NUMBER(3)
);

ALTER TABLE t_hlt_coracao ADD CONSTRAINT coracao_pk PRIMARY KEY ( t_hlt_usuario_id_usuario,
                                                                  dt_coracao );

CREATE TABLE t_hlt_exercicio (
    dt_exercicio               DATE NOT NULL,
    nr_registro_dia            NUMBER(2) NOT NULL,
    t_hlt_usuario_id_usuario   NUMBER(8) NOT NULL,
    t_hlt_tipo_ex_id_exercicio NUMBER(8) NOT NULL,
    duracao                    NUMBER NOT NULL,
    nr_kcal_total              NUMBER(4) NOT NULL
);

ALTER TABLE t_hlt_exercicio
    ADD CONSTRAINT exercicio_pk PRIMARY KEY ( dt_exercicio,
                                              t_hlt_usuario_id_usuario,
                                              t_hlt_tipo_ex_id_exercicio,
                                              nr_registro_dia );

CREATE TABLE t_hlt_humor (
    dt_humor                 DATE NOT NULL,
    t_hlt_usuario_id_usuario NUMBER(8) NOT NULL,
    nivel_humor              NUMBER(1) NOT NULL
);

ALTER TABLE t_hlt_humor ADD CONSTRAINT humor_pk PRIMARY KEY ( dt_humor,
                                                              t_hlt_usuario_id_usuario );

CREATE TABLE t_hlt_medicamento (
    dt_remedio               DATE NOT NULL,
    nr_registro_dia          NUMBER(2) NOT NULL,
    t_hlt_usuario_id_usuario NUMBER(8) NOT NULL,
    t_hlt_ativo_id_ativo     NUMBER(8) NOT NULL,
    qt_dose                  NUMBER(8, 2) NOT NULL,
    horario                  DATE NOT NULL
);

ALTER TABLE t_hlt_medicamento
    ADD CONSTRAINT medicamento_pk PRIMARY KEY ( dt_remedio,
                                                nr_registro_dia,
                                                t_hlt_usuario_id_usuario,
                                                t_hlt_ativo_id_ativo );

CREATE TABLE t_hlt_peso (
    dt_peso                  DATE NOT NULL,
    t_hlt_usuario_id_usuario NUMBER(8) NOT NULL,
    nr_peso                  NUMBER(5, 2) NOT NULL,
    nr_perc_gordura          NUMBER(3, 1),
    nr_perc_musculo          NUMBER(3, 1),
    nr_perc_visc             NUMBER(3, 1)
);

ALTER TABLE t_hlt_peso ADD CONSTRAINT peso_pk PRIMARY KEY ( dt_peso,
                                                            t_hlt_usuario_id_usuario );

CREATE TABLE t_hlt_refeicao (
    dt_refeicao              DATE NOT NULL,
    nr_registro_refeicao     NUMBER(2) NOT NULL,
    t_hlt_usuario_id_usuario NUMBER(8) NOT NULL,
    ds_refeicao              VARCHAR2(20) NOT NULL,
    nr_total_kcal            NUMBER(6, 2) NOT NULL,
    nr_total_carbo           NUMBER(6, 2) NOT NULL,
    nr_total_prot            NUMBER(6, 2) NOT NULL,
    nr_total_gord            NUMBER(6, 2) NOT NULL
);

ALTER TABLE t_hlt_refeicao
    ADD CONSTRAINT refeicao_pk PRIMARY KEY ( dt_refeicao,
                                             t_hlt_usuario_id_usuario,
                                             nr_registro_refeicao );

CREATE TABLE t_hlt_refeicao_alimento (
    t_hlt_refeicao_dt_refeicao    DATE NOT NULL,
    refeicao_usuario_id_usuario   NUMBER(8) NOT NULL,
    refeicao_nr_registro_refeicao NUMBER(2) NOT NULL,
    t_hlt_alimento_id_alimento    NUMBER(8) NOT NULL,
    qt_consumida                  NUMBER(6, 2) NOT NULL
);

ALTER TABLE t_hlt_refeicao_alimento
    ADD CONSTRAINT refeicao_alimento_pk PRIMARY KEY ( t_hlt_refeicao_dt_refeicao,
                                                      refeicao_usuario_id_usuario,
                                                      refeicao_nr_registro_refeicao,
                                                      t_hlt_alimento_id_alimento );

CREATE TABLE t_hlt_tipo_ex (
    id_exercicio   NUMBER(8) NOT NULL,
    ds_exercicio   VARCHAR2(30) NOT NULL,
    nr_kcal_minuto NUMBER(2) NOT NULL
);

ALTER TABLE t_hlt_tipo_ex ADD CONSTRAINT tipo_ex_pk PRIMARY KEY ( id_exercicio );

CREATE TABLE t_hlt_usuario (
    id_usuario    NUMBER(8) NOT NULL,
    email         VARCHAR2(50) NOT NULL,
    senha         VARCHAR2(20) NOT NULL,
    nome          VARCHAR2(20) NOT NULL,
    sobrenome     VARCHAR2(30) NOT NULL,
    dt_nascimento DATE NOT NULL,
    altura        NUMBER(3, 2) NOT NULL,
    genero        CHAR(1) NOT NULL,
    nr_ddd        NUMBER(2),
    nr_celular    NUMBER(9)
);

ALTER TABLE t_hlt_usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE t_hlt_agua
    ADD CONSTRAINT agua_usuario_fk FOREIGN KEY ( t_hlt_usuario_id_usuario )
        REFERENCES t_hlt_usuario ( id_usuario );

ALTER TABLE t_hlt_refeicao_alimento
    ADD CONSTRAINT alimento_ref_fk FOREIGN KEY ( t_hlt_alimento_id_alimento )
        REFERENCES t_hlt_alimento ( id_alimento );

ALTER TABLE t_hlt_coracao
    ADD CONSTRAINT coracao_usuario_fk FOREIGN KEY ( t_hlt_usuario_id_usuario )
        REFERENCES t_hlt_usuario ( id_usuario );

ALTER TABLE t_hlt_exercicio
    ADD CONSTRAINT exercicio_tipo_ex_fk FOREIGN KEY ( t_hlt_tipo_ex_id_exercicio )
        REFERENCES t_hlt_tipo_ex ( id_exercicio );

ALTER TABLE t_hlt_exercicio
    ADD CONSTRAINT exercicio_usuario_fk FOREIGN KEY ( t_hlt_usuario_id_usuario )
        REFERENCES t_hlt_usuario ( id_usuario );

ALTER TABLE t_hlt_humor
    ADD CONSTRAINT humor_usuario_fk FOREIGN KEY ( t_hlt_usuario_id_usuario )
        REFERENCES t_hlt_usuario ( id_usuario );

ALTER TABLE t_hlt_medicamento
    ADD CONSTRAINT medicamento_ativo_fk FOREIGN KEY ( t_hlt_ativo_id_ativo )
        REFERENCES t_hlt_ativo ( id_ativo );

ALTER TABLE t_hlt_medicamento
    ADD CONSTRAINT medicamento_usuario_fk FOREIGN KEY ( t_hlt_usuario_id_usuario )
        REFERENCES t_hlt_usuario ( id_usuario );

ALTER TABLE t_hlt_peso
    ADD CONSTRAINT peso_usuario_fk FOREIGN KEY ( t_hlt_usuario_id_usuario )
        REFERENCES t_hlt_usuario ( id_usuario );

ALTER TABLE t_hlt_refeicao_alimento
    ADD CONSTRAINT refeicao_ali_fk FOREIGN KEY ( t_hlt_refeicao_dt_refeicao,
                                                 refeicao_usuario_id_usuario,
                                                 refeicao_nr_registro_refeicao )
        REFERENCES t_hlt_refeicao ( dt_refeicao,
                                    t_hlt_usuario_id_usuario,
                                    nr_registro_refeicao );

ALTER TABLE t_hlt_refeicao
    ADD CONSTRAINT refeicao_usuario_fk FOREIGN KEY ( t_hlt_usuario_id_usuario )
        REFERENCES t_hlt_usuario ( id_usuario );



-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            12
-- CREATE INDEX                             0
-- ALTER TABLE                             23
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
