/**
 * 
 */
package fr.afcepf.al24.bank.dao.api;

import java.util.Date;

import fr.afcepf.al24.bank.entites.Client;

/**
 * @author Stagiaire
 *
 */
public interface IDaoClient {
	public Client ajouterClient(Long numeroIdentite, String nom, String prenom, Date dateNaissance, String motDePasse);
	public boolean SupprimerClient(Client client);
	public Client rechercherClientparId(Integer id);
}
