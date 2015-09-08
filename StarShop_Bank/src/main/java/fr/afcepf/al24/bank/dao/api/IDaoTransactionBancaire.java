/**
 * 
 */
package fr.afcepf.al24.bank.dao.api;

import fr.afcepf.al24.bank.entites.TransactionBancaire;

/**
 * @author Stagiaire
 *
 */
public interface IDaoTransactionBancaire {
	public TransactionBancaire ajouterTransaction(TransactionBancaire t);
}
