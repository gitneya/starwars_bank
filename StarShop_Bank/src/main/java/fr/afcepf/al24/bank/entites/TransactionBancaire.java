/**
 * 
 */
package fr.afcepf.al24.bank.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name="transaction")
public class TransactionBancaire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "TRANSACTION_ID", unique = true, nullable = false)
	private Integer id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMPTE_ID_DEBIT",nullable=false)
	private Compte compteAdebiter;
	@Column(name = "TRANSACTION_MONTANT", unique = false, nullable = false)
	private Double montant;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMPTE_ID_CREDIT",nullable=false)
	private Compte compteAcrediter;
	/**
	 * 
	 */
	public TransactionBancaire() {
	}

	/**
	 * @param compteAdebiter
	 * @param montant
	 * @param compteAcrediter
	 * @param typeTransaction
	 */
	public TransactionBancaire(Compte compteAdebiter, Double montant,
			Compte compteAcrediter) {
		this.compteAdebiter = compteAdebiter;
		this.montant = montant;
		this.compteAcrediter = compteAcrediter;
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
	 * @return the compteAdebiter
	 */
	public Compte getCompteAdebiter() {
		return compteAdebiter;
	}
	/**
	 * @param compteAdebiter the compteAdebiter to set
	 */
	public void setCompteAdebiter(Compte compteAdebiter) {
		this.compteAdebiter = compteAdebiter;
	}
	/**
	 * @return the montant
	 */
	public Double getMontant() {
		return montant;
	}
	/**
	 * @param montant the montant to set
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	/**
	 * @return the compteAcrediter
	 */
	public Compte getCompteAcrediter() {
		return compteAcrediter;
	}
	/**
	 * @param compteAcrediter the compteAcrediter to set
	 */
	public void setCompteAcrediter(Compte compteAcrediter) {
		this.compteAcrediter = compteAcrediter;
	}
}
