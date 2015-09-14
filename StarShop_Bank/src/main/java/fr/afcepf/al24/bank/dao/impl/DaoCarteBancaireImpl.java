/**
 * 
 */
package fr.afcepf.al24.bank.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
@Component(value="daoCarteBancaire")
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
		/*
		String requeteJPQL = "SELECT c FROM CarteBancaire c WHERE c.numero=:paramNumero"
				+ " AND c.dateFinValidite=:paramDateFin"
				+ " AND c.cryptogramme=:paramCrypto";
				*/
		String requeteJPQL = "SELECT c FROM CarteBancaire c LEFT JOIN FETCH c.compte"
				+ " WHERE c.numero=:paramNumero"
				+ " AND c.dateFinValidite=:paramDateFin"
				+ " AND c.cryptogramme=:paramCrypto";
		
		Query jpql = entityManager.createQuery(requeteJPQL);
		jpql.setParameter("paramNumero", numero);
		jpql.setParameter("paramCrypto", cryptogramme);
		jpql.setParameter("paramDateFin", dateValidite);
		CarteBancaire carte = null;
		try {
			//carte = (CarteBancaire) hql.getSingleResult();
			
			List<CarteBancaire>  listeCartes = (List<CarteBancaire>) jpql.getResultList();
			int size = listeCartes.size();
			if (size == 1) {
				carte = listeCartes.get(0);
				Compte compte = carte.getCompte();
			} else if (size > 1) {
					log.info("DaoCarteBancaireImpl.rechercherCarte : La requete a retourné plusieurs resultats.");	
			} else if (size == 0) {
				log.info("DaoCarteBancaireImpl.rechercherCarte : La requete n'a retourné aucun resultats.");
			}
		} catch (NoResultException e1) { 
			log.info("DaoCarteBancaireImpl.rechercherCarte : carte introuvable : " + e1.getClass() + " " + e1.getMessage());
			log.info("*************************************************");
			carte = null;
		} catch (Exception e) {
			e.printStackTrace();
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
			entityManager.flush();
		}
		return null;
	}

	@Override
	public boolean SupprimerCarte(CarteBancaire carte) {
		entityManager.remove(carte);
		entityManager.flush();
		return false;
	}

}
