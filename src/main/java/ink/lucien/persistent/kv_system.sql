CREATE TABLE kv_system (
    `key` VARCHAR(32),
    `value` TEXT NOT NULL,
    PRIMARY KEY (`key`)
) ENGINE = InnoDB;
INSERT INTO test.kv_system (`key`, value) VALUES ('Hello', 'World!');
