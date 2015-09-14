/**
 * 
 */
package fr.afcepf.al24.bank.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Stagiaire
 *
 */
@Entity//(name="carteBancaire")
@Table(name="carteBancaire")
public class CarteBancaire implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "CARTE_ID", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "CARTE_NUMERO", unique = true, nullable = false)
	private Long numero;
	
	@Column(name = "CARTE_CRYPTO", unique = false, nullable = false)
	private Integer cryptogramme;
	
	@Column(name = "CARTE_DATE_EMMISSION", unique = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateEmmission;
	
	@Column(name = "CARTE_DATEFIN", unique = false, nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateFinValidite;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMPTE_ID",nullable=false)
	private Compte compte;
	
	/**
	 * 
	 */
	public CarteBancaire() {
	}
	/**
	 * @param numero
	 * @param cryptogramme
	 * @param dateEmmission
	 * @param dateFinValidite
	 * @param compte
	 */
	public CarteBancaire(Long numero, Integer cryptogramme, Date dateEmmission,
			Date dateFinValidite) {
		this.numero = numero;
		this.cryptogramme = cryptogramme;
		this.dateEmmission = dateEmmission;
		this.dateFinValidite = dateFinValidite;
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
	 * @return the cryptogramme
	 */
	public Integer getCryptogramme() {
		return cryptogramme;
	}
	/**
	 * @param cryptogramme the cryptogramme to set
	 */
	public void setCryptogramme(Integer cryptogramme) {
		this.cryptogramme = cryptogramme;
	}
	/**
	 * @return the dateFinValidite
	 */
	public Date getDateFinValidite() {
		return dateFinValidite;
	}
	/**
	 * @param dateFinValidite the dateFinValidite to set
	 */
	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}
	
	/**
	 * @return the dateEmmission
	 */
	public Date getDateEmmission() {
		return dateEmmission;
	}

	/**
	 * @param dateEmmission the dateEmmission to set
	 */
	public void setDateEmmission(Date dateEmmission) {
		this.dateEmmission = dateEmmission;
	}

	/**
	 * @return the compte
	 */
	public Compte getCompte() {
		return compte;
	}
	/**
	 * @param compte the compte to set
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}

}
