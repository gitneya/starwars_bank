/**
 * 
 */
package fr.afcepf.al24.bank.mbean;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.apache.log4j.Logger;

import fr.afcepf.al24.bank.dao.api.IDaoClient;
import fr.afcepf.al24.bank.entites.Client;

/**
 * @author Stagiaire
 *
 */
@ManagedBean(name="creationCompteBean")
public class CreationCompteBean implements Serializable {

	/**
	 * 
	 */
	private Logger log = Logger.getLogger(CreationCompteBean.class);
	private static final long serialVersionUID = -4142694722301955587L;
	
	private String nom;
	private String prenom;
	private String motdepasse;
	private Long numero;
	private Date dateNaissance;
	
	@ManagedProperty(value="#{daoClient}")
	private IDaoClient daoClient;

	Client client;
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the motdepasse
	 */
	public String getMotdepasse() {
		return motdepasse;
	}
	/**
	 * @param motdepasse the motdepasse to set
	 */
	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}
	/**
	 * @return the daoClient
	 */
	public IDaoClient getDaoClient() {
		return daoClient;
	}
	/**
	 * @param daoClient the daoClient to set
	 */
	public void setDaoClient(IDaoClient daoClient) {
		this.daoClient = daoClient;
	}
	/**
	 * @return the numero
	 */
	public Long getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	/**
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	/**
	 * 
	 */
	public String creerCompte() {
		String pageRetournee = "main";
		client = daoClient.ajouterClient(numero, nom, prenom, dateNaissance, motdepasse);
		if (client != null) {
			log.info("CreationCompteBean.creerCompte : Création d'un client : " + client.getNom());
			pageRetournee = "login";
		}
		
		return pageRetournee;
	}
}
