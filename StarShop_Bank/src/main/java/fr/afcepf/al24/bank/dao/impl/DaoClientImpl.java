/**
 * 
 */
package fr.afcepf.al24.bank.dao.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al24.bank.dao.api.IDaoClient;
import fr.afcepf.al24.bank.entites.Client;

/**
 * @author Stagiaire
 *
 */
@Repository(value="daoClient")
@Transactional
public class DaoClientImpl implements IDaoClient {

	private Logger log = Logger.getLogger(DaoClientImpl.class);
	
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

	@Override
	public Client rechercherClientparNomMotDePasse(String nom, String motDePasse) {

		Client client = null;
		log.info("DaoClientImpl.rechercherClientparNomMotDePasse");
		log.info("**********************************************");
		if (!nom.equals("") && !motDePasse.equals("")) {
			String requete = "FROM client c WHERE c.nom=:paramNom"
					+ " AND c.motDePasse=:paramMotDePasse";
			Query hql = entityManager.createQuery(requete);
			hql.setParameter("paramNom", nom);
			hql.setParameter("paramMotDePasse", motDePasse);
			
			try {
				client = (Client) hql.getSingleResult();
			} catch (Exception e) {
				log.info("DaoClientImpl.rechercherClientparNomMotDePasse : client introuvable");
				log.info("*******************************************************************");
				client = null;
			}
		}

		return client;
	}

}
