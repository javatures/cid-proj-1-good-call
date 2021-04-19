-- Data Definition Language (DDL)
DROP DATABASE IF EXISTS ghud;

CREATE DATABASE ghud;

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

CREATE TABLE thought (
    id SERIAL PRIMARY KEY,
    tldr TEXT NOT NULL,
    vibe_id INT,
    frame TEXT NOT NULL
        CHECK (
            (location = 'love') or
            (location = 'live') or
            (location = 'learn') or
            (location = 'earn')
        ),
    location TEXT NOT NULL
        CHECK (
            (frame = 'top of mind') or
            (frame = 'front and center') or
            (frame = 'bottom line')
        ),
    
    CONSTRAINT fk_thought_vibe
        FOREIGN KEY(vibe_id)
            REFERENCES vibe(id)
            ON DELETE CASCADE
    
);

INSERT INTO soul (name)
    VALUES
        ('stretch ego'),
        ('seth from above'),
        ('chanarah'),
        ('steve')
;

INSERT INTO vibe (soul_id, tldr, purpose)
    VALUES
        (2, 'when can we regroup on deliverables?', 'get project back on track'),
        (1, 'how did recording session go?', 'keep project moving')
;

INSERT INTO thought (tldr, vibe_id, location, frame)
    VALUES
        ('gotta do my taxes',, 'bottom line', 'earn'),
        ('finish project1',, 'front and center', 'learn'),
        ('finish been saiyan song', 1, 'front and center', 'learn'),
        ('finish peace of pi song', 2, 'front and center', 'learn')
;