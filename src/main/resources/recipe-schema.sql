DROP TABLE IF EXISTS `recipe` CASCADE;
CREATE TABLE recipe (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(255),
    calories INTEGER NOT NULL,
    prep_time INTEGER NOT NULL,
    serving_size INTEGER NOT NULL,
    PRIMARY KEY (id)
);

