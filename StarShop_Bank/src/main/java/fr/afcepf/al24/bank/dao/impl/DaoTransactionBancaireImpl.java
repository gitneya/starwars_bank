/**
 * 
 */
package fr.afcepf.al24.bank.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al24.bank.dao.api.IDaoTransactionBancaire;
import fr.afcepf.al24.bank.entites.TransactionBancaire;

/**
 * @author Stagiaire
 *
 */
@Component
@Transactional
public class DaoTransactionBancaireImpl implements IDaoTransactionBancaire {

	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoTransactionBancaire#ajouterTransaction(fr.afcepf.al24.bank.entites.TransactionBancaire)
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public TransactionBancaire ajouterTransaction(TransactionBancaire t) {
		entityManager.persist(t);
		return null;
	}

}
