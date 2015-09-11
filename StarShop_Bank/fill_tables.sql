# Création d'un client
insert client(client_datenaissance, client_nom,client_numero_identite,client_prenom,client_motdepasse) values ("1975-12-24","Dupond","1","Eric","Eric");
insert compte(compte_solde,client_id) SELECT 5000,Client_id FROM client WHERE client_nom="Dupond";
insert cartebancaire(carte_Crypto,carte_date_emmission,carte_datefin,carte_numero,compte_id) select "999","1980-01-25","1982-01-01","9", 1;
# Création d'un client
insert client(client_datenaissance, client_nom,client_numero_identite,client_prenom,client_motdepasse) values ("1970-09-01","Durand","2","Paul","Paul");
insert compte(compte_solde,client_id) SELECT 5000,Client_id FROM client WHERE client_nom="Durand";
insert cartebancaire(carte_Crypto,carte_date_emmission,carte_datefin,carte_numero,compte_id) select "888","2013-10-01","2015-10-01","8", 2;
# Création du compte Magazin
insert client(client_datenaissance, client_nom,client_numero_identite,client_prenom,client_motdepasse) values ("1985-12-24","Manufacture","3","Manufacture","Manufacture");
insert compte(compte_solde,client_id) SELECT 5000,Client_id FROM client WHERE client_nom="Manufacture";
insert cartebancaire(carte_Crypto,carte_date_emmission,carte_datefin,carte_numero,compte_id) select "111","2015-01-01","2017-01-01","1", 3;