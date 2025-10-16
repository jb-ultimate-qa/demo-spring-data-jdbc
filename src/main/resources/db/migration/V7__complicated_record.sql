CREATE TABLE complicated_record
(
    id_num      BIGINT  NOT NULL,
    id_ext      VARCHAR NOT NULL,
    description VARCHAR,
    CONSTRAINT pk_complicated_record PRIMARY KEY (id_num, id_ext)
);