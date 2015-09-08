/**
 * 
 */
package fr.afcepf.al24.bank.service;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Stagiaire
 *
 */
public class WSRetourTransaction implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean transactionValide;
	private Integer idTransaction;
	private Date dateTransaction;
	
	/**
	 * 
	 */
	public WSRetourTransaction() {
	}
	/**
	 * @param transactionValide
	 * @param idTransaction
	 * @param dateTransaction
	 */
	public WSRetourTransaction(boolean transactionValide,
			Integer idTransaction, Date dateTransaction) {
		super();
		this.transactionValide = transactionValide;
		this.idTransaction = idTransaction;
		this.dateTransaction = dateTransaction;
	}

	/**
	 * @return the transactionValide
	 */
	public boolean isTransactionValide() {
		return transactionValide;
	}
	/**
	 * @param transactionValide the transactionValide to set
	 */
	public void setTransactionValide(boolean transactionValide) {
		this.transactionValide = transactionValide;
	}
	/**
	 * @return the idTransaction
	 */
	public Integer getIdTransaction() {
		return idTransaction;
	}
	/**
	 * @param idTransaction the idTransaction to set
	 */
	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
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
