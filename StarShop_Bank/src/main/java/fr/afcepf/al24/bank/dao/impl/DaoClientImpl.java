/**
 * 
 */
package fr.afcepf.al24.bank.dao.impl;

import java.math.BigInteger;
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
	public Client ajouterClient(Long numeroIdentification, String nom, String prenom, Date dateNaissance) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoClient#SupprimerClient(fr.afcepf.al24.bank.entites.Client)
	 */
	@Override
	public boolean SupprimerClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoClient#rechercherClientparNumIdentite(java.math.BigInteger)
	 */
	@Override
	public Client rechercherClientparNumIdentite(BigInteger numeroIdentite) {
		// TODO Auto-generated method stub
		return null;
	}

}
