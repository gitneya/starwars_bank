/**
 * 
 */
package fr.afcepf.al24.bank.dao.api;

import java.util.List;

import fr.afcepf.al24.bank.entites.Client;
import fr.afcepf.al24.bank.entites.TransactionBancaire;

/**
 * @author Stagiaire
 *
 */
public interface IDaoTransactionBancaire {
	
	public TransactionBancaire ajouterTransaction(TransactionBancaire t);
	public List<TransactionBancaire> retournerLestransactionsParClient(Client client);
}
