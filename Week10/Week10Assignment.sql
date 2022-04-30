CREATE DATABASE IF NOT EXISTS week10;

USE week10;

DROP TABLE IF EXISTS planes;

CREATE TABLE planes(
model VARCHAR(32) NOT NULL,
manufacturer VARCHAR(32) NOT NULL,
year YEAR,
price DECIMAL(11,2),
cruise_speed_kn INT,
flight_range_nmi INT,
PRIMARY KEY (model)
);

INSERT INTO planes VALUES ('Skyhawk','Cessna',2022,415000.00,124,640);
INSERT INTO planes VALUES ('Skylane','Cessna',2022,530000.00,145,915);
INSERT INTO planes VALUES ('Caravan','Cessna',2022,2355000.00,186,1070);
INSERT INTO planes VALUES ('Citation M2','Cessna',2022,5850000.00,404,1550);
INSERT INTO planes VALUES ('Citation Longitude','Cessna',2022,29900000.00,483,3500);
INSERT INTO planes VALUES ('Archer DX','Piper',2022,450000.00,123,848);
INSERT INTO planes VALUES ('Seneca','Piper',2022,1061000.00,200,828);
INSERT INTO planes VALUES ('M350','Piper',2022,1195000.00,213,1343);
INSERT INTO planes VALUES ('Bonanza G36','Beechcraft',2022,925000.00,174,920);
INSERT INTO planes VALUES ('King Air 360','Beechcraft',2022,7650000.00,312,1806);
INSERT INTO planes VALUES ('Carbon Cub SS','Cubcrafters',2020,265000.00,96,450);

-- SELECT * FROM planes;