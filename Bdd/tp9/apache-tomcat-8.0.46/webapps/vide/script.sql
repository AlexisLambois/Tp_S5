DROP TABLE if EXISTS login;

CREATE TABLE login(
	nom text,
	mdp text,
	dat date,
	ip text,
	constraint pk_login primary key (nom)
);
