/**
 * 
 */
package fr.afcepf.al24.bank.entites;

import java.io.Serializable;
import java.util.Collection;

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
@Entity//(name="compte")
@Table(name="compte")
public class Compte implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "COMPTE_ID", unique = true, nullable = false)
	private Integer id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLIENT_ID",nullable=false)
	private Client client;
	
	@Column(name = "COMPTE_SOLDE", unique = false, nullable = false)
	private Double solde;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="compte")
	Collection<CarteBancaire> listeCarteBancaire;
	
	//FIXME: Set ou List ??
	@OneToMany(fetch=FetchType.LAZY,mappedBy="compteAdebiter")
	Collection<TransactionBancaire> listeTransaction;
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
	public Collection<CarteBancaire> getListeCarteBancaire() {
		return listeCarteBancaire;
	}
	/**
	 * @param listeCarteBancaire the listeCarteBancaire to set
	 */
	public void setListeCarteBancaire(Collection<CarteBancaire> listeCarteBancaire) {
		this.listeCarteBancaire = listeCarteBancaire;
	}
	/**
	 * @return the listeTransaction
	 */
	public Collection<TransactionBancaire> getListeTransaction() {
		return listeTransaction;
	}
	/**
	 * @param listeTransaction the listeTransaction to set
	 */
	public void setListeTransaction(Collection<TransactionBancaire> listeTransaction) {
		this.listeTransaction = listeTransaction;
	}
	
}
