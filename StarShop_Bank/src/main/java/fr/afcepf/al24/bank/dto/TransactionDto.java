/**
 * 
 */
package fr.afcepf.al24.bank.dto;

import java.util.Date;

/**
 * @author Stagiaire
 *
 */
public class TransactionDto {

	private Integer numero;
	private Date dateTransaction;
	private Double montantDebit;
	private Double montantCredit;
	private String detail;
	
	
	/**
	 * @param dateTransaction
	 * @param montantDebit
	 * @param montantCredit
	 * @param detail
	 */
	public TransactionDto(Integer numero, Date dateTransaction, Double montantDebit,
			Double montantCredit, String detail) {
		this.numero = numero;
		this.dateTransaction = dateTransaction;
		this.montantDebit = montantDebit;
		this.montantCredit = montantCredit;
		this.detail = detail;
	}
	/**
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
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
	/**
	 * @return the montantDebit
	 */
	public Double getMontantDebit() {
		return montantDebit;
	}
	/**
	 * @param montantDebit the montantDebit to set
	 */
	public void setMontantDebit(Double montantDebit) {
		this.montantDebit = montantDebit;
	}
	/**
	 * @return the montantCredit
	 */
	public Double getMontantCredit() {
		return montantCredit;
	}
	/**
	 * @param montantCredit the montantCredit to set
	 */
	public void setMontantCredit(Double montantCredit) {
		this.montantCredit = montantCredit;
	}
	/**
	 * @return the detail
	 */
	public String getDetail() {
		return detail;
	}
	/**
	 * @param detail the detail to set
	 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
