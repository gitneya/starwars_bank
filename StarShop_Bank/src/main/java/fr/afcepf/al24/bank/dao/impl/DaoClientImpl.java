/**
 * 
 */
package fr.afcepf.al24.bank.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al24.bank.dao.api.IDaoClient;
import fr.afcepf.al24.bank.entites.Client;

/**
 * @author Stagiaire
 *
 */
//@Repository(value="daoClient")
@Component(value="daoClient")
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
			/*
			String requeteHQL = "FROM client c WHERE c.nom=:paramNom"
					+ " AND c.motDePasse=:paramMotDePasse";
			*/
			
			String requeteJPQL = "SELECT c FROM Client c WHERE c.nom=:paramNom AND c.motDePasse=:paramMotDePasse";
			Query jpql = entityManager.createQuery(requeteJPQL, Client.class);
			jpql.setParameter("paramNom", nom);
			jpql.setParameter("paramMotDePasse", motDePasse);
			try {
				//client = (Client) hql.getSingleResult();
				List<Client>  listeClients = (List<Client>) jpql.getResultList();
				int size = listeClients.size();
				if (size == 1) {
					client = listeClients.get(0);
				} else {
						log.info("DaoClientImpl.rechercherClientparNomMotDePasse : La requete e retournée plusieurs resultats");	
				}
				
				entityManager.close();
				
			} catch (NoResultException e1) { 
				log.info("DaoClientImpl.rechercherClientparNomMotDePasse : client introuvable : " + e1.getClass() + " " + e1.getMessage());
				log.info("*******************************************************************");
				client = null;
			} catch (Exception e) {
				e.printStackTrace();
				client = null;
			}
		}

		return client;
	}

}
