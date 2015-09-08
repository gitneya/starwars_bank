/**
 * 
 */
package fr.afcepf.al24.bank.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al24.bank.dao.api.IDaoCompte;
import fr.afcepf.al24.bank.entites.CarteBancaire;
import fr.afcepf.al24.bank.entites.Client;
import fr.afcepf.al24.bank.entites.Compte;

/**
 * @author Stagiaire
 *
 */
@Component
@Transactional
public class DaoCompteImpl implements IDaoCompte {

	@PersistenceContext
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoCompte#creerCompte(fr.afcepf.al24.bank.entites.Client)
	 */
	@Override
	public Compte creerCompte(Client client) {
		// TODO Auto-generated method stub
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
		return null;
	}

}
