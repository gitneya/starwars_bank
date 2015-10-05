# Création d'un client
USE bankDB;

#Activer les logs des requetes
#SET global general_log = 1;
#SET global log_output = 'table';
#SELECT * FROM mysql.general_log;

#Desactiver les logs des requetes
#SET global general_log = 0;

insert client(CLIENT_DATENAISSANCE, CLIENT_NOM,CLIENT_NUMERO_IDENTITE,CLIENT_PRENOM,CLIENT_MOTDEPASSE) values ("1975-12-24","Dupond","1","Eric","Eric");
insert compte(COMPTE_SOLDE,CLIENT_ID) SELECT 5000,CLIENT_ID FROM client WHERE CLIENT_NOM="Dupond";
insert carteBancaire(CARTE_CRYPTO,CARTE_DATE_EMMISSION,CARTE_DATEFIN,CARTE_NUMERO,COMPTE_ID) select "999","1980-01-25","1982-01-01","9", 1;
# Création d'un client
insert client(CLIENT_DATENAISSANCE, CLIENT_NOM,CLIENT_NUMERO_IDENTITE,CLIENT_PRENOM,CLIENT_MOTDEPASSE) values ("1970-09-01","Durand","2","Paul","Paul");
insert compte(COMPTE_SOLDE,CLIENT_ID) SELECT 5000,CLIENT_ID FROM client WHERE CLIENT_NOM="Durand";
insert carteBancaire(CARTE_CRYPTO,CARTE_DATE_EMMISSION,CARTE_DATEFIN,CARTE_NUMERO,COMPTE_ID) select "888","2013-10-01","2015-10-01","8", 2;
# Création du compte Magazin
insert client(CLIENT_DATENAISSANCE, CLIENT_NOM,CLIENT_NUMERO_IDENTITE,CLIENT_PRENOM,CLIENT_MOTDEPASSE) values ("1985-12-24","Manufacture","3","Manufacture","Manufacture");
insert compte(COMPTE_SOLDE,CLIENT_ID) SELECT 5000,CLIENT_ID FROM client WHERE CLIENT_NOM="Manufacture";
insert carteBancaire(CARTE_CRYPTO,CARTE_DATE_EMMISSION,CARTE_DATEFIN,CARTE_NUMERO,COMPTE_ID) select "111","2015-01-01","2017-01-01","1", 3;
# Création d'client
insert client(CLIENT_DATENAISSANCE, CLIENT_NOM,CLIENT_NUMERO_IDENTITE,CLIENT_PRENOM,CLIENT_MOTDEPASSE) values ("1980-12-24","Martin","4","Pierre","Pierre");
insert compte(COMPTE_SOLDE,CLIENT_ID) SELECT 50000,CLIENT_ID FROM client WHERE CLIENT_NOM="Martin";
insert carteBancaire(CARTE_CRYPTO,CARTE_DATE_EMMISSION,CARTE_DATEFIN,CARTE_NUMERO,COMPTE_ID) select "666","2015-01-01","2017-01-01","1234567891234567", 4;

#Création de transaction
# TODO insert transactionbancaire(transaction_date,transaction_montant,COMPTE_ID_credit,COMPTE_ID_debit) SELECT "2015-01-01 10:00:00",250