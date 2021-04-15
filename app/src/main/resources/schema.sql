-- Data Definition Language (DDL)
DROP DATABASE IF EXISTS ghud;

CREATE DATABASE ghud;

CREATE TABLE thought (
    id SERIAL PRIMARY KEY,
    tldr TEXT NOT NULL
);

CREATE TABLE soul (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL
);

CREATE TABLE vibe (
    id SERIAL PRIMARY KEY,
    soul_id INT NOT NULL,
    tldr TEXT NOT NULL,
    purpose TEXT NOT NULL,
    
    CONSTRAINT fk_vibe_soul
        FOREIGN KEY(soul_id)
            REFERENCES soul(id)
            ON DELETE CASCADE
);

CREATE TABLE headspace (
    id SERIAL PRIMARY KEY,
    thought_id INT NOT NULL,
    vibe_id INT,
    location TEXT NOT NULL
        CHECK (
            (location = 'love') or
            (location = 'live') or
            (location = 'learn') or
            (location = 'earn')
        ),
    frame TEXT NOT NULL
        CHECK (
            (frame = 'top of mind') or
            (frame = 'front and center') or
            (frame = 'bottom line')
        ),

    CONSTRAINT fk_headspace_thought
        FOREIGN KEY(thought_id)
            REFERENCES thought(id)
            ON DELETE CASCADE,
    
    CONSTRAINT fk_headspace_vibe
        FOREIGN KEY(vibe_id)
            REFERENCES vibe(id)
            ON DELETE CASCADE
);

INSERT INTO thought (tldr)
    VALUES
        ('gotta do my taxes'),
        ('finish project1'),
        ('finish been saiyan song'),
        ('finish peace of pi song')
;

INSERT INTO soul (name)
    VALUES
        ('stretch ego'),
        ('seth from above'),
        ('chanarah'),
        ('steve')
;

INSERT INTO headspace (thought_id, location, frame)
    VALUES
        (1, 'live', 'top of mind')
;