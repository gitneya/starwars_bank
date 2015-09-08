/**
 * 
 */
package fr.afcepf.al24.bank.dao.api;

import java.math.BigInteger;
import java.util.Date;

import fr.afcepf.al24.bank.entites.Client;

/**
 * @author Stagiaire
 *
 */
public interface IDaoClient {
	public Client ajouterClient(Long numeroIdentite, String nom, String prenom, Date dateNaissance);
	public boolean SupprimerClient(Client client);
	public Client rechercherClientparNumIdentite(BigInteger numeroIdentite);
}
