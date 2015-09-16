/**
 * 
 */
package fr.afcepf.al24.bank.mbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import fr.afcepf.al24.bank.dao.api.IDaoClient;
import fr.afcepf.al24.bank.entites.Client;

/**
 * @author Stagiaire
 *
 */
@ManagedBean(name="loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(LoginBean.class);

	private String nom;
	private String motDePasse;

	//Ne pas oublier la faces-config sinon injection ne marche pas !!!!!!!!
	@ManagedProperty(value="#{daoClient}")
	private IDaoClient daoClient;

	Client client;

	/**
	 * 
	 */
	public LoginBean() {
	}
	/**
	 * @param nom
	 * @param motDePasse
	 */
	public LoginBean(String nom, String motDePasse) {
		this.nom = nom;
		this.motDePasse = motDePasse;
	}
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
	 * @return the motDePasse
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * @param motDePasse the motDePasse to set
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	/**
	 * @param daoClient the daoClient to set
	 */
	public void setDaoClient(IDaoClient daoClient) {
		this.daoClient = daoClient;
	}
	
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	
	/**
	 * @return the estConnecte
	 */
	public boolean isEstConnecte() {
		return client != null;
	}
	
	public void afficheMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public String deconnexion() {
		log.info("LoginBean.Déconnexion : " + nom);
		client = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index.xhtml?faces-redirect=true";
	}

	public String connexion() {
		String pageRetournee = "login.xhtml";
		log.info("LoginBean.connexion : " + nom + " " + motDePasse);
		if (nom != null || motDePasse != null) {
			log.info("LoginBean.connexion : DAOClient " + daoClient);
			log.info("****************************************");
			client = daoClient.rechercherClientparNomMotDePasse(nom, motDePasse);
			if (client == null) {
				log.info("LoginBean.connexion : client introuvable");
				log.info("****************************************");
				afficheMessage("Cet utilisateur n'existe pas !");
			} else {
				pageRetournee = "consulterCompte.xhtml";
				log.info("LoginBean.connexion : client trouvé : " + pageRetournee);
				log.info("********************************************************");
			}
		}
		return pageRetournee;
	}
	
	public void buttonActionListenerConnexion(ActionEvent actionEvent) {

		afficheMessage("Connexion en cours");
		RequestContext requestContext = RequestContext.getCurrentInstance();

		log.info("LoginBean.buttonAction : " + actionEvent.getSource());
	}

	public void buttonActionDeconnexion(ActionEvent actionEvent) {

		afficheMessage("Déconnexion en cours");
		RequestContext requestContext = RequestContext.getCurrentInstance();

		log.info("LoginBean.buttonActionDeconnexion : " + actionEvent.getSource());
		deconnexion();
	}

}

