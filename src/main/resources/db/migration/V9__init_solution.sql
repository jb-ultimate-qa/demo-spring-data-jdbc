CREATE SEQUENCE IF NOT EXISTS solution_alias_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS solution_default_seq START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE IF NOT EXISTS solution_named_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE solution_alias
(
    id          BIGINT NOT NULL,
    description VARCHAR,
    CONSTRAINT pk_solution_alias PRIMARY KEY (id)
);

CREATE TABLE solution_default
(
    id          BIGINT NOT NULL,
    description VARCHAR,
    CONSTRAINT pk_solution_default PRIMARY KEY (id)
);

CREATE TABLE solution_named
(
    id          BIGINT NOT NULL,
    description VARCHAR,
    CONSTRAINT pk_solution_named PRIMARY KEY (id)
);