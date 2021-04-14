-- Data Definition Language (DDL)
DROP DATABASE IF EXISTS ghud;

CREATE DATABASE ghud;

DROP TABLE IF EXISTS headspace CASCADE;

CREATE TABLE thought (
    id SERIAL PRIMARY KEY,
    tldr TEXT NOT NULL
);

CREATE TABLE soul (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

TRUNCATE TABLE thought;

CREATE TABLE thought (
    id SERIAL PRIMARY KEY,
    tldr TEXT NOT NULL
);

CREATE TABLE vibe (
    id SERIAL PRIMARY KEY,
    tldr TEXT NOT NULL,
    purpose TEXT NOT NULL
);

ALTER TABLE vibe ADD FK_vibe_soul NUMBER NOT NULL FOREIGN KEY REFERENCES soul(id); 

CREATE TABLE headspace (
    id SERIAL PRIMARY KEY,
    location TEXT NOT NULL,
    frame TEXT NOT NULL,

    FK_headspace_thought NUMBER NOT NULL
        FOREIGN KEY REFERENCES thought(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
        
    FK_headspace_vibe NUMBER NOT NULL
        FOREIGN KEY REFERENCES vibe(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Data Manipulation Language (DML: CRUD)
INSERT INTO soul (name) VALUES ('jenny');

INSERT INTO vibe (tldr, purpose, FK_vibe_soul)
    VALUES ('say hi', 'check-in', 1);

INSERT INTO thought VALUES ('hmm...');

UPDATE vibe SET tldr = 'say hello' WHERE id = 1;

DELETE thought WHERE tldr LIKE 'hmm...';

-- Data Control Language (DCL)
GRANT SELECT, INSERT, UPDATE, DELETE, ALTER, REFERENCES ON thought TO project1;
GRANT SELECT, INSERT, UPDATE, DELETE, ALTER, REFERENCES ON vibe TO project1;
GRANT SELECT, INSERT, UPDATE, DELETE, ALTER, REFERENCES ON soul TO project1;
GRANT SELECT, INSERT, UPDATE, DELETE, ALTER, REFERENCES ON headspace TO project1;

REVOKE ALL, ALTER, REFERENCES ON thought FROM public;
REVOKE ALL, ALTER, REFERENCES ON vibe FROM public;
REVOKE ALL, ALTER, REFERENCES ON soul FROM public;
REVOKE ALL, ALTER, REFERENCES ON headspace FROM public;