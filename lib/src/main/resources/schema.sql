-- Data Definition Language (DDL)
DROP DATABASE IF EXISTS ghud;

CREATE DATABASE ghud;

CREATE TABLE soul (
    soulId SERIAL PRIMARY KEY,
    soulName TEXT NOT NULL
);

CREATE TABLE vibe (
    vibeId SERIAL PRIMARY KEY,
    vibeSoulId INT NOT NULL,
    vibeTldr TEXT NOT NULL,
    vibePurpose TEXT NOT NULL,
    
    CONSTRAINT fk_vibe_soul
        FOREIGN KEY(vibeSoulId)
            REFERENCES soul(soulId)
            ON DELETE CASCADE
);

CREATE TABLE thought (
    thoughtId SERIAL PRIMARY KEY,
    thoughtTldr TEXT NOT NULL,
    thoughtVibeId INT,
    thoughtFrame TEXT NOT NULL
        CHECK (
            (thoughtFrame = 'love') or
            (thoughtFrame = 'live') or
            (thoughtFrame = 'learn') or
            (thoughtFrame = 'earn')
        ),
    thoughtLocation TEXT NOT NULL
        CHECK (
            (thoughtLocation = 'top of mind') or
            (thoughtLocation = 'front and center') or
            (thoughtLocation = 'bottom line')
        ),
    
    CONSTRAINT fk_thought_vibe
        FOREIGN KEY(thoughtVibeId)
            REFERENCES vibe(vibeId)
            ON DELETE CASCADE
    
);

-- Data Manipulation Language (DML)

INSERT INTO soul (soulName)
    VALUES
        ('stretch ego'),
        ('seth from above'),
        ('chanarah'),
        ('steve')
;

INSERT INTO vibe (vibeSoulId, vibeTldr, vibePurpose)
    VALUES
        (2, 'when can we regroup on deliverables?', 'get project back on track'),
        (1, 'how did recording session go?', 'keep project moving')
;

INSERT INTO thought (thoughtTldr, thoughtVibeId, thoughtLocation, thoughtFrame)
    VALUES
        ('gotta do my taxes',null, 'bottom line', 'earn'),
        ('finish project1',null, 'front and center', 'learn'),
        ('finish been saiyan song', 1, 'front and center', 'learn'),
        ('finish peace of pi song', 2, 'front and center', 'learn')
;