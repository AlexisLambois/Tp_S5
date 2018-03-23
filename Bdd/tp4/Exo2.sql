DROP TABLE IF EXISTS vol;
DROP TABLE IF EXISTS avion;
DROP TABLE IF EXISTS pilote;
DROP TABLE IF EXISTS ligne;

CREATE TABLE avion(
	ano serial,
	type text,
	places int CHECK ( places >= 100 and places <= 500),
	compagnie text,
	CONSTRAINT PK_avion PRIMARY KEY (ano)
);

CREATE TABLE pilote(
	pno serial,
	nom text,
	prenom text,
	adresse text DEFAULT 'Lille',
	CONSTRAINT PK_pilote PRIMARY KEY (pno)
);

CREATE TABLE ligne(
	lno serial,
	depart text,
	arrive text,
	CONSTRAINT PK_ligne PRIMARY KEY (lno)
);

CREATE TABLE vol(
	ano int,
	pno int,
	lno int,
	hdep time DEFAULT '12:00',
	harr time DEFAULT '14:00',
	CONSTRAINT FK_avion FOREIGN KEY (ano) REFERENCES avion(ano) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT FK_ligne FOREIGN KEY (lno) REFERENCES ligne(lno) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT FK_pilote FOREIGN KEY (pno) REFERENCES pilote(pno) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT PK_vol PRIMARY KEY (ano,pno,lno)
);

INSERT INTO pilote(nom,prenom) VALUES('Jean','Albert');
--INSERT INTO pilote(nom,prenom) VALUES('Phillipe','Baptiste');
--INSERT INTO pilote(nom,prenom) VALUES('Malo','Demoncul');
--INSERT INTO pilote(nom,prenom) VALUES('Enzo','Detoncul');
--INSERT INTO pilote(nom,prenom) VALUES('Hugo','Lecon');

INSERT INTO avion(type,places,compagnie) VALUES('A320',100,'Air France');
--INSERT INTO avion(type,places,compagnie) VALUES('A340',200,'Air Tarace');
--INSERT INTO avion(type,places,compagnie) VALUES('A520',150,'Air Moncul');
--INSERT INTO avion(type,places,compagnie) VALUES('A380',300,'Air Toncul');

INSERT INTO ligne(depart,arrive) VALUES('Lille','Berlin');
--INSERT INTO ligne(depart,arrive) VALUES('Marseille','Venise');
--INSERT INTO ligne(depart,arrive) VALUES('Nantes','Paris');
--INSERT INTO ligne(depart,arrive) VALUES('Lille','Paris');

INSERT INTO vol VALUES(1,1,1,'12:00','14:00');

DROP TABLE IF EXISTS copievol;

CREATE TEMP TABLE copievol AS(
	SELECT * FROM vol
);

DELETE FROM vol;

INSERT INTO pilote(nom,prenom) VALUES('Phillipe','Baptiste');
INSERT INTO pilote(nom,prenom) VALUES('Malo','Demoncul');

INSERT INTO avion(type,places,compagnie) VALUES('A340',200,'Air Tarace');
INSERT INTO avion(type,places,compagnie) VALUES('A520',150,'Air Moncul');

INSERT INTO ligne(depart,arrive) VALUES('Marseille','Venise');
INSERT INTO ligne(depart,arrive) VALUES('Nantes','Paris');

INSERT INTO vol(ano,pno,lno) 
SELECT ano,pno,lno
FROM pilote,ligne,avion;

ALTER TABLE avion ADD couleur text;
UPDATE avion SET couleur='rouge';
UPDATE avion SET couleur='bleu' WHERE ano=2;
UPDATE avion SET couleur='vert' WHERE ano=3;

ALTER TABLE pilote ADD email text;
ALTER TABLE pilote DROP email;

ALTER TABLE avion DROP couleur;

DROP TABLE IF EXISTS aeroport;

CREATE TABLE aeroport(
	ano serial,
	ville text,
	adresse text
);

INSERT INTO aeroport(ville,adresse) VALUES('Lille','20 rue de mon cul');
INSERT INTO aeroport(ville,adresse) VALUES('Paris','20 rue de mon cul');
INSERT INTO aeroport(ville,adresse) VALUES('Berlin','20 rue de mon cul');
INSERT INTO aeroport(ville,adresse) VALUES('Venise','20 rue de mon cul');

DELETE FROM aeroport;

DROP TABLE aeroport;

DROP VIEW IF EXISTS petitavion;

CREATE VIEW petitavion AS ( SELECT * FROM avion WHERE places BETWEEN 100 and 200);

--SELECT * FROM petitavion;

DROP VIEW IF EXISTS volclair;

CREATE VIEW volclair AS ( 
SELECT vol.ano,vol.pno,vol.lno,nom,prenom,type,compagnie,depart,arrive 
FROM vol 
INNER JOIN avion ON vol.ano=avion.ano
INNER JOIN pilote ON vol.pno=pilote.pno
INNER JOIN ligne ON vol.lno=ligne.lno
);
