/**
 * 
 */
package fr.afcepf.al24.bank.dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al24.bank.dao.api.IDaoClient;
import fr.afcepf.al24.bank.entites.Client;

/**
 * @author Stagiaire
 *
 */
@Component
@Transactional
public class DaoClientImpl implements IDaoClient {

	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoClient#ajouterClient(java.lang.String, java.lang.String, java.util.Date)
	 */
	@Override
	public Client ajouterClient(Long numeroIdentification, String nom, String prenom, Date dateNaissance, String motDePasse) {
		Client client = new Client(numeroIdentification, nom, prenom, dateNaissance, motDePasse);
		if (client != null) {
			entityManager.persist(client);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoClient#SupprimerClient(fr.afcepf.al24.bank.entites.Client)
	 */
	@Override
	public boolean SupprimerClient(Client client) {
		entityManager.remove(client);
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoClient#rechercherClientparNumIdentite(java.math.BigInteger)
	 */
	@Override
	public Client rechercherClientparId(Integer id) {
		entityManager.find(Client.class, id);
		return null;
	}

}
