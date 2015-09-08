/**
 * 
 */
package fr.afcepf.al24.bank.entites;

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
	@Column(name="TRANSACTION_DATE",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTransaction;
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
		this.dateTransaction = new Date();
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
	/**
	 * @return the dateTransaction
	 */
	public Date getDateTransaction() {
		return dateTransaction;
	}
	/**
	 * @param dateTransaction the dateTransaction to set
	 */
	public void setDateTransaction(Date dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
}
