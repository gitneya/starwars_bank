/**
 * 
 */
package fr.afcepf.al24.bank.dao.api;

import fr.afcepf.al24.bank.entites.CarteBancaire;
import fr.afcepf.al24.bank.entites.Client;
import fr.afcepf.al24.bank.entites.Compte;

/**
 * @author Stagiaire
 *
 */
public interface IDaoCompte {
	public Compte creerCompte(Client client);
	public boolean supprimerCompte(Client client);
	public Compte rechercherCompteParCarte(CarteBancaire carte);
	public Compte mettreAjourCompte(Compte c);
}
