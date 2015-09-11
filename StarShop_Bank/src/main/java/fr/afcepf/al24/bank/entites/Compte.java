/**
 * 
 */
package fr.afcepf.al24.bank.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Stagiaire
 *
 */
@Entity
@Table(name="compte")
public class Compte {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "COMPTE_ID", unique = true, nullable = false)
	private Integer id;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLIENT_ID",nullable=false)
	private Client client;
	@Column(name = "COMPTE_SOLDE", unique = false, nullable = false)
	private Double solde;
	@OneToMany
	Set<CarteBancaire> listeCarteBancaire = new HashSet<CarteBancaire>(0);
	//FIXME: Set ou List ??
	@OneToMany
	Set<TransactionBancaire> listeTransaction = new HashSet<TransactionBancaire>(0);
	/**
	 * 
	 */
	public Compte() {
	}
	/**
	 * @param client
	 * @param solde
	 * @param listeCarteBancaire
	 */
	public Compte(Client client, Double solde) {
		this.client = client;
		this.solde = solde;
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
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}
	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}
	/**
	 * @return the solde
	 */
	public Double getSolde() {
		return solde;
	}
	/**
	 * @param solde the solde to set
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}
	/**
	 * @return the listeCarteBancaire
	 */
	public Set<CarteBancaire> getListeCarteBancaire() {
		return listeCarteBancaire;
	}
	/**
	 * @param listeCarteBancaire the listeCarteBancaire to set
	 */
	public void setListeCarteBancaire(Set<CarteBancaire> listeCarteBancaire) {
		this.listeCarteBancaire = listeCarteBancaire;
	}
	/**
	 * @return the listeTransaction
	 */
	public Set<TransactionBancaire> getListeTransaction() {
		return listeTransaction;
	}
	/**
	 * @param listeTransaction the listeTransaction to set
	 */
	public void setListeTransaction(Set<TransactionBancaire> listeTransaction) {
		this.listeTransaction = listeTransaction;
	}
	
}
