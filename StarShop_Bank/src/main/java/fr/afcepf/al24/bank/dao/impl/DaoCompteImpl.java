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

import fr.afcepf.al24.bank.dao.api.IDaoCompte;
import fr.afcepf.al24.bank.entites.CarteBancaire;
import fr.afcepf.al24.bank.entites.Client;
import fr.afcepf.al24.bank.entites.Compte;

/**
 * @author Stagiaire
 *
 */
@Repository(value="daoCompte")
@Transactional
public class DaoCompteImpl implements IDaoCompte {

	private Logger log = Logger.getLogger(DaoCompteImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoCompte#creerCompte(fr.afcepf.al24.bank.entites.Client)
	 */
	@Override
	public Compte creerCompte(Client client) {
		Compte compte = new Compte();
		compte.setClient(client);
		entityManager.persist(compte);
		entityManager.flush();
		return null;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoCompte#supprimerCompte(fr.afcepf.al24.bank.entites.Client)
	 */
	@Override
	public boolean supprimerCompte(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoCompte#rechercherCompteParCarte(fr.afcepf.al24.bank.entites.CarteBancaire)
	 */
	@Override
	public Compte rechercherCompteParCarte(CarteBancaire carte) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte mettreAjourCompte(Compte c) {
		entityManager.merge(c);
		entityManager.flush();
		return null;
	}

	@Override
	public Double retournerSolde(Client client) {
		List<Compte> liste = new ArrayList<Compte>();
		Double solde = null;
		
		if (client != null) {
			String requete = "FROM Compte AS cpt WHERE cpt.client.id=:paramId";
			
			try {
				Query hql = entityManager.createQuery(requete);			
				hql.setParameter("paramId", client.getId().intValue());
				liste = (List<Compte>) hql.getResultList();
				if (liste.size() == 1) {
					solde = liste.get(0).getSolde();
					log.info("DaoCompteImpl.retournerSolde : client:" + client.getNom() + " Solde : " + solde);
				} else {
					//TODO
					log.info("DaoCompteImpl.retournerSolde : le programme ne gère pas plusieurs compte : TODO");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		return solde;
	}

}
