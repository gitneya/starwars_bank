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
import fr.afcepf.al24.bank.dto.TransactionDto;
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
	public List<TransactionDto> retournerLestransactionsParClient(Client client) {
		log.info("DaoTransactionBancaireImpl.retournerLestransactionsParClient d'Id:" + client.getId());
		log.info("************************************************************************");
		List<TransactionDto> listeDto = new ArrayList<TransactionDto>();
		if (client != null) {
			List<Compte> listeCompte = new ArrayList<Compte>();
			//listeCompte = client.getListeCompte()
			//String requete = "FROM TransactionBancaire c WHERE c.compteAcrediter=:paramId1 OR c.compteAdebiter=:paramId1 ORDER BY c.dateTransaction";
			String requete1 = "SELECT t FROM TransactionBancaire AS t"
					+ " join t.compteAcrediter AS cred WHERE cred.client.id=:paramId1";
			//UNION marche pas en HQL !!! donc deux requetes distinctes
			String requete2 = "SELECT t FROM TransactionBancaire AS t join t.compteAdebiter AS deb WHERE deb.client.id=:paramId1";
			
			Query hql = entityManager.createQuery(requete1);			
			hql.setParameter("paramId1", client.getId().intValue());
			
			try {
				List<TransactionBancaire> liste = new ArrayList<TransactionBancaire>();
				liste = (List<TransactionBancaire>) hql.getResultList();
				Query hql2 = entityManager.createQuery(requete2);			
				hql2.setParameter("paramId1", client.getId().intValue());
				liste.addAll((List<TransactionBancaire>) hql2.getResultList());
				Double montantCredit;
				Double montantDebit;
				String detail;
				
				for (TransactionBancaire t : liste) {
					Compte cptCredit = t.getCompteAcrediter();
					Compte cptDebit = t.getCompteAdebiter();
					montantCredit = null;
					montantDebit = null;
					detail = "";
					if (cptCredit.getClient().getId() == client.getId()) {
						//On credite le client
						montantCredit = t.getMontant();
					} else {
						//On debite le client
						montantDebit = t.getMontant();
						detail = "Bénéficiaire : " + cptCredit.getClient().getNom();
					}
					
					TransactionDto dto = new TransactionDto(t.getId(),t.getDateTransaction(), montantDebit, montantCredit, detail);
					listeDto.add(dto);
				}
				
				
			} catch (Exception e) {
				log.info("DaoTransactionBancaireImpl.retournerLestransactionsParClient");
				log.info("*******************************************************************");
				listeDto = null;
			}
		}
		return listeDto;
	}
}
