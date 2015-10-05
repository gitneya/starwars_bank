/**
 * 
 */
package fr.afcepf.al24.bank.entites;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Stagiaire
 *
 */
@Entity//(name="client")
@Table(name="client")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CLIENT_ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="CLIENT_NUMERO_IDENTITE", unique = true, nullable = false)
	private Long numeroIdentite ;
	
	@Column(name="CLIENT_NOM",nullable = false, length = 50)
	private String nom;
	
	@Column(name="CLIENT_PRENOM",nullable = false, length = 50)
	private String prenom;
	
	@Column(name="CLIENT_MOTDEPASSE",nullable = false, length = 50)
	private String motDePasse;
	
	@Column(name="CLIENT_DATENAISSANCE",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="client")
	Collection<Compte> listeCompte;

	/**
	 * 
	 */
	public Client() {
	}
	/**
	 * @param numeroIdentite
	 * @param nom
	 * @param prenom
	 * @param dateNaissance
	 */
	public Client(Long numeroIdentite, String nom, String prenom,
			Date dateNaissance, String paramMotDePasse) {
		this.numeroIdentite = numeroIdentite;
		this.nom = nom;
		this.prenom = prenom;
	    this.dateNaissance = dateNaissance;
	    motDePasse = paramMotDePasse;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the numeroIdentite
	 */
	public Long getNumeroIdentite() {
		return numeroIdentite;
	}

	/**
	 * @param numeroIdentite the numeroIdentite to set
	 */
	public void setNumeroIdentite(Long numeroIdentite) {
		this.numeroIdentite = numeroIdentite;
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
	 * @return the listeCompte
	 */
	public Collection<Compte> getListeCompte() {
		return listeCompte;
	}
	/**
	 * @param listeCompte the listeCompte to set
	 */
	public void setListeCompte(Collection<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}
}
