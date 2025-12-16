CREATE TABLE complicated_entity
(
    id_numeric  BIGINT  NOT NULL,
    id_extended VARCHAR NOT NULL,
    name        VARCHAR,
    CONSTRAINT pk_complicated_entity PRIMARY KEY (id_numeric, id_extended)
);