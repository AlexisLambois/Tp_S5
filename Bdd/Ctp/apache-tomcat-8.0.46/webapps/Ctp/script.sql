drop table if exists menu;
drop table if exists recettes;
drop table if exists ingredients;
drop table if exists plats;


create table plats(
    pno serial primary key,
    type char(1),
    libelle varchar(80),
    description text
);

create table ingredients(
    ino serial primary key,
    libelle varchar(80),
    prix decimal(6,2)
);

create table recettes(
    ino int,
    pno int,
    quantite decimal(7,3),
    primary key(ino, pno),
    foreign key(pno) references plats(pno),
    foreign key(ino) references ingredients(ino)
);

create table menu(
    mno serial primary key,
    entree int,
    plat int,
    dessert int,
    mail varchar(100),
    resa date,
    foreign key(entree)  references plats(pno),
    foreign key(plat)    references plats(pno),
    foreign key(dessert) references plats(pno)
);

insert into plats values
 (1, 'E', 'Mozzarella sticks', 'Beignets de Mozzarella fondants')
,(2, 'E', 'Onion rings', 'Oignons entiers frits, sauce au choix')
,(3, 'E', 'Crispy chicken', 'Poulets croustillants, sauce BBQ')
,(4, 'E', 'Beignets de calamars', 'Sauce tartare')
,(5, 'E', 'Planche charcuteries & fromages', 'Assortiment de charcuteries et fromages, cornichons, toasts')
,(6, 'E', 'Quesadillas', 'Tortillas, poulet mariné au tandoori, Cheddar, compotée d''oignons, tomate, coriandre, tortillas chips, guacamole, sauce salsa')
,(7, 'P', 'Salade Queen Victoria', 'Lardons, œuf poché, croûtons, pommes de terre sautées, mesclun, vinaigrette balsamique')
,(8, 'P', 'Salade Blue cheese', 'Jambon Serrano, oeuf poché pané, Bleu, artichaut, avocat, noix, tomate, salade, herbes fraîches, vinaigrette balsamique')
,(9, 'P', 'Salade du pub', 'Poulet tandoori, œuf au plat, Cheddar, avocat, tomate, romaine, sauce Philadelphia®')
,(10, 'P', 'Entrecôte', 'Pièce de bœuf de 250g environ, goûteuse et persillée')
,(11, 'P', 'Brochette de poulet mariné', 'Filet de poulet mariné de 280g environ, frites, salade')
,(12, 'P', 'Colossal burger', 'Triple steak haché de bœuf, triple Cheddar, triple poitrine fumée, compotée d''oignons, tomate, salade, sauce burger')
,(13, 'P', 'Black pepper burger', 'Steak haché de bœuf, poitrine fumée, Cheddar, compotée d’oignons, tomate, oignons rouges, sauce au poivre, buns')
,(14, 'D', 'Lemon pie cheesecake', 'Cheesecake, topping brownie' )
,(15, 'D', 'Moelleux au chocolat', '' )
,(16, 'D', 'Baba mojito', 'Baba au rhum façon mojito, sorbet Citron vert et ses zestes, Chantilly' )
,(17, 'D', 'Crêpe gourmande', 'Nutella®, copeaux de chocolat, crème glacée Vanille intense, sauce chocolat, Chantilly' )
,(18, 'D', 'Crêpe des îles', 'Dés de mangue poêlés, purée de mangue, crème pâtissière, amandes effilées, Chantilly' )
;

insert into ingredients values
 ( 1, 'Mozarella', 14.70)
,( 2, 'Farine de blé', 1.90)
,( 3, 'Chapelure de pain', 3.75)
,( 4, 'Oeuf', 0.31)
,( 5, 'Sel', 8.16)
,( 6, 'Poivre noir', 56.22)
,( 7, 'Huile', 2.17)
,( 8, 'Oignon', 2.6)
,( 9, 'Lait', 1.15)
,(10, 'Piment', 66)
,(11, 'Poulet', 15.52)
,(12, 'Ail', 1.37)
,(13, 'Paprika', 64)
,(14, 'Citron', 2.59)
,(15, 'Calamars', 15.35)
,(16, 'Levure chimique', 12.16)
,(17, 'Jambon de bayonne', 11.9)
,(18, 'Tomme de savoie', 19.33)
,(40, 'Cornichons', 4.91)
,(19, 'Beurre', 7.28)
,(20, 'Tomate', 4.15)
,(21, 'Tortilla', 8.62)
,(22, 'Lardons', 8.95)
,(23, 'Pomme de terre', 1.2)
,(24, 'Croûtons', 16.78)
,(25, 'Salade', 7.8)
,(26, 'Coeur d''artichaut', 29.60)
,(27, 'Bleu de Bresse', 7.8)
,(28, 'Cheddar', 14.5)
,(29, 'Avocat', 3.5)
,(30, 'Boeuf haché', 12.43)
,(31, 'Pièce de boeuf', 23.52)
,(32, 'Haricots verts', 8.54)
,(33, 'Sucre', 1.40)
,(34, 'Chocolat en plaque', 12.50)
,(35, 'Rhum', 28.13)
,(36, 'Glace vanille', 9.96)
,(37, 'Nutella',  5.5)
,(38, 'Chantilly', 8.96)
,(39, 'Mangue', 2.49)
;

insert into recettes(pno, ino, quantite) values 
 ( 1, 4, 1)
,( 1, 3, 0.02)
,( 1, 2, 0.02)
,( 1, 1, 0.15)
,( 1, 7, 0.5)

,( 2, 4, 1)
,( 2, 8, 1)
,( 2, 2, 0.155)
,( 2, 9, 0.235)
,( 2, 3, 0.080)
,( 2, 7, 1)
,( 2, 5, 0.005)
,( 2, 10, 1)

,( 3, 11, 0.3)
,( 3,  4, 2)
,( 3,  9, 0.5)
,( 3,  5, 0.005)
,( 3, 13, 0.015)
,( 3, 12, 0.03)
,( 3, 14, 0.25)
,( 3,  2, 0.05)

,( 4, 15, 0.4)
,( 4,  2, 0.125)
,( 4,  4, 1)
,( 4,  9, 0.01)
,( 4, 16, 0.5)
,( 4,  5, 0.005)

,( 5, 17, 0.1)
,( 5, 18, 0.1)
,( 5, 40, 0.05)
,( 5, 27, 0.05)
,( 5, 28, 0.05)

,( 6, 20, 0.075)
,( 6,  8, 1)
,( 6,  1, 0.3)
,( 6, 17, 0.05)
,( 6, 13, 0.005)
,( 6, 19, 0.02)
,( 6, 21, 0.2)

,( 7, 22, 0.1)
,( 7, 23, 0.1)
,( 7, 24, 0.05)
,( 7, 25, 0.15)

,( 8, 22, 0.1)
,( 8, 23, 0.1)
,( 8, 24, 0.05)
,( 8, 25, 0.15)
,( 8, 17, 0.1)
,( 8, 20, 0.15)
,( 8, 27, 0.06)
,( 8, 28, 0.05)

,( 9, 22, 0.1)
,( 9, 23, 0.1)
,( 9, 24, 0.05)
,( 9, 25, 0.15)
,( 9, 20, 0.15)
,( 9, 28, 0.05)
,( 9, 29, 0.5)

,(10, 31, 0.25)
,(10, 23, 0.15)
,(10, 32, 0.1)

,(11, 11, 0.28)
,(11, 25, 0.1)
,(11, 23, 0.15)

,(12, 30, 0.25)
,(12, 25, 0.1)
,(12, 23, 0.1)
,(12, 28, 0.1)
,(12, 20, 0.075)
,(12, 17, 0.05)
,(12,  8, 0.5)

,(13, 30, 0.1)
,(13, 25, 0.1)
,(13, 23, 0.1)
,(13, 28, 0.05)
,(13, 20, 0.075)
,(13,  8, 0.5)

,(14,  2, 0.180)
,(14, 19, 0.08)
,(14, 33, 0.135)
,(14,  4, 4)
,(14, 14, 3)

,(15, 34, 0.083)
,(15, 19, 0.058)
,(15, 33, 0.042)
,(15,  2, 0.025)
,(15,  4, 2)

,(16, 34, 0.075)
,(16, 33, 0.050)
,(16,  2, 0.060)
,(16,  4, 2)
,(16,  9, 0.045)
,(16, 35, 0.01)

,(17,  4, 1)
,(17,  9, 0.1)
,(17,  2, 0.1)
,(17, 33, 0.025)
,(17, 36, 0.08)
,(17, 37, 0.025)
,(17, 38, 0.025)

,(18,  4, 1)
,(18,  9, 0.1)
,(18,  2, 0.1)
,(18, 33, 0.025)
,(18, 39, 0.5)
,(18, 38, 0.025)

;


