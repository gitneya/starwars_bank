/**
 * 
 */
package fr.afcepf.al24.bank.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al24.bank.dao.api.IDaoTransactionBancaire;
import fr.afcepf.al24.bank.entites.Client;
import fr.afcepf.al24.bank.entites.Compte;
import fr.afcepf.al24.bank.entites.TransactionBancaire;

/**
 * @author Stagiaire
 *
 */
@Repository(value="daoTransactionBancaire")
@Transactional
public class DaoTransactionBancaireImpl implements IDaoTransactionBancaire {
	
	private Logger log = Logger.getLogger(DaoTransactionBancaireImpl.class);
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoTransactionBancaire#ajouterTransaction(fr.afcepf.al24.bank.entites.TransactionBancaire)
	 */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * 
	 */
	public DaoTransactionBancaireImpl() {
	}

	@Override
	public TransactionBancaire ajouterTransaction(TransactionBancaire t) {
		entityManager.persist(t);
		entityManager.flush();
		return null;
	}

	@Override
	public List<TransactionBancaire> retournerLestransactionsParClient(Client client) {
		log.info("DaoTransactionBancaireImpl.retournerLestransactionsParClient d'Id:" + client.getId());
		log.info("************************************************************************");
		List<TransactionBancaire> liste = null;
		if (client != null) {
			List<Compte> listeCompte = new ArrayList<Compte>();
			//listeCompte = client.getListeCompte()
			//String requete = "FROM TransactionBancaire c WHERE c.compteAcrediter=:paramId1 OR c.compteAdebiter=:paramId1 ORDER BY c.dateTransaction";
					String requete = "FROM TransactionBancaire as c INNER JOIN c.compteAcrediter";
			
			//String requete = "FROM TransactionBancaire";
			Query hql = entityManager.createQuery(requete);
			
			//hql.setParameter("paramId1", client.g);
			
			try {
				liste = new ArrayList<TransactionBancaire>();
				liste = (List<TransactionBancaire>) hql.getResultList();
			} catch (Exception e) {
				log.info("DaoTransactionBancaireImpl.retournerLestransactionsParClient");
				log.info("*******************************************************************");
				liste = null;
			}
		}
		return liste;
	}
}
