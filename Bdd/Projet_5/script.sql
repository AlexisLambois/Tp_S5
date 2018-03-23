DROP TABLE IF EXISTS commandes;
DROP TABLE IF EXISTS fournisseurs;
DROP TABLE IF EXISTS produits;

CREATE TABLE fournisseurs(
	fno int,
	nom text,
	ville text,
	CONSTRAINT PK_fournisseurs PRIMARY KEY (fno)
);

CREATE TABLE produits(
	pno int,
	libelle text,
	prix int,
	CONSTRAINT PK_produits PRIMARY KEY (pno)
);

CREATE TABLE commandes(
	fno int,	
	pno int,
	cno serial,
	qute int,
	CONSTRAINT FK_fournisseurs FOREIGN KEY (fno) REFERENCES fournisseurs(fno) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT FK_produits FOREIGN KEY (pno) REFERENCES produits(pno) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT PK_commandes PRIMARY KEY (cno,pno,fno)
);
