CREATE TABLE dat104_obl2_gr12.participant (
	phonenumber CHAR(8) PRIMARY KEY NOT NULL, 
	firstname VARCHAR(20) NOT NULL, 
	surname VARCHAR(20) NOT NULL, 
	sex BOOLEAN NOT NULL, 
	paid BOOLEAN NOT NULL
);