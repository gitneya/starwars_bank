/**
 * 
 */
package fr.afcepf.al24.bank.service;

import java.util.Date;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al24.bank.dao.api.IDaoCarteBancaire;
import fr.afcepf.al24.bank.dao.api.IDaoCompte;
import fr.afcepf.al24.bank.dao.api.IDaoTransactionBancaire;
import fr.afcepf.al24.bank.entites.CarteBancaire;
import fr.afcepf.al24.bank.entites.Compte;
import fr.afcepf.al24.bank.entites.TransactionBancaire;

/**
 * @author Stagiaire
 *
 */
@Transactional
@Component
@WebService(targetNamespace="http://service.bank.al24.afcepf.fr/", 
endpointInterface="fr.afcepf.al24.bank.service.ITransactionBancaire")
public class TransactionBancaireImpl implements ITransactionBancaire {

	Logger log = Logger.getLogger(ValiderCarteBancaireImpl.class);
	@Autowired
	private IDaoCarteBancaire daoCarte;
	@Autowired
	private IDaoTransactionBancaire daoTransaction;
	@Autowired
	private IDaoCompte daoCompte;
	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.service.ITransactionBancaire#effectuerTransaction(fr.afcepf.al24.bank.entites.Compte, fr.afcepf.al24.bank.entites.Compte, java.lang.Double)
	 */
	//Les cartes ont été validées précédemment !!
	@Override
	public boolean effectuerTransaction(Long numeroCarteDebit,
			Date dateFinValiditeDebit, Integer cryptogrammeDebit,
			Long numeroCarteCredit, Date dateFinValiditeCredit,
			Integer cryptogrammeCredit, Double montant) {
		boolean transactionValide = false;
		//Vérifier le solde sur le compte à débiter
		CarteBancaire carteDebit = daoCarte.rechercherCarte(numeroCarteDebit, cryptogrammeDebit, dateFinValiditeDebit);
		CarteBancaire carteCredit = daoCarte.rechercherCarte(numeroCarteCredit, cryptogrammeCredit, dateFinValiditeCredit);
		if (carteDebit != null && carteCredit != null) {
			Compte compteDebit = carteDebit.getCompte();
			Compte compteCredit = carteCredit.getCompte();
			
			//Créer la transaction
			if (compteDebit.getSolde() - montant >= 0) { 
				TransactionBancaire t = new TransactionBancaire();
				t.setMontant(montant);
				t.setCompteAcrediter(compteCredit);
				t.setCompteAdebiter(compteDebit);
				daoTransaction.ajouterTransaction(t);
				//Mettre à jour les soldes des comptes
				compteCredit.setSolde(compteCredit.getSolde() + montant);
				compteDebit.setSolde(compteDebit.getSolde() - montant);
				daoCompte.mettreAjourCompte(compteCredit);
				daoCompte.mettreAjourCompte(compteDebit);
				transactionValide = true;
				log.info("TransactionBancaireImpl.effectuerTransaction : La transaction est Valide");
				log.info("************************************************************************");
			} else {
				transactionValide = false; //Pour etre sur !!!
				log.info("TransactionBancaireImpl.effectuerTransaction : La transaction est invalide (solde insuffisant)");
				log.info("**********************************************************************************************");
			}
		}

		return transactionValide;
	}

}
