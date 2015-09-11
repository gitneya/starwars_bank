/**
 * 
 */
package fr.afcepf.al24.bank.entites;

import java.text.ParseException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
@Entity
@Table(name="client")
public class Client {

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
	Set<Compte> listeCompte = new HashSet<Compte>(0);

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
	 * @param listeCompte
	 * @throws ParseException 
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
	public Set<Compte> getListeCompte() {
		return listeCompte;
	}
	/**
	 * @param listeCompte the listeCompte to set
	 */
	public void setListeCompte(Set<Compte> listeCompte) {
		this.listeCompte = listeCompte;
	}

}
