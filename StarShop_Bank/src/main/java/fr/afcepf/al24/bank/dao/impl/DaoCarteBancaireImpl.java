/**
 * 
 */
package fr.afcepf.al24.bank.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al24.bank.dao.api.IDaoCarteBancaire;
import fr.afcepf.al24.bank.entites.CarteBancaire;
import fr.afcepf.al24.bank.entites.Compte;

/**
 * @author Stagiaire
 *
 */
@Component
@Transactional
public class DaoCarteBancaireImpl implements IDaoCarteBancaire {

	private Logger log = Logger.getLogger(DaoCarteBancaireImpl.class);
	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.dao.api.IDaoCarteBancaire#rechercherCarte(java.math.BigInteger, java.lang.Integer, java.util.Date)
	 */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public CarteBancaire rechercherCarte(Long numero,
			Integer cryptogramme, Date dateValidite) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		log.info("DaoCarteBancaireImpl.rechercherCarte : numero=" + numero + " crypto=" + cryptogramme + " DateFin=" + sdf.format(dateValidite) );
		log.info("**********************************************************************************");
		String requete = "FROM carteBancaire c WHERE c.numero=:paramNumero"
				+ " AND c.dateFinValidite=:paramDateFin"
				+ " AND c.cryptogramme=:paramCrypto";
		Query hql = entityManager.createQuery(requete);
		hql.setParameter("paramNumero", numero);
		hql.setParameter("paramCrypto", cryptogramme);
		hql.setParameter("paramDateFin", dateValidite);
		CarteBancaire carte;
		try {
			carte = (CarteBancaire) hql.getSingleResult();
		} catch (Exception e) {
			log.info("DaoCarteBancaireImpl.rechercherCarte : carte introuvable");
			log.info("*************************************************");
			carte = null;
		}
		if (carte != null) {
			log.info("DaoCarteBancaireImpl.rechercherCarte : carte trouvée, numero=" + carte.getNumero() 
					+ " DateFin=" + carte.getDateFinValidite()
					+ " Crypto=" + carte.getCryptogramme());
			log.info("******************************************************************************************************");
		}
		entityManager.close();
		return carte;
	}

	@Override
	public CarteBancaire ajouterCarte(Compte compte, Long numero,
			Integer cryptogramme, Date dateEmmission, Date dateValidite) {
		if (compte != null) {
			CarteBancaire carte = new CarteBancaire(numero, cryptogramme, dateEmmission, dateValidite);
			entityManager.persist(carte);
		}
		return null;
	}

	@Override
	public boolean SupprimerCarte(CarteBancaire carte) {
		entityManager.remove(carte);
		return false;
	}

}
