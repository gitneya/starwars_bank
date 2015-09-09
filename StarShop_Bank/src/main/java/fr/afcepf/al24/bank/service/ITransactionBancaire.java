/**
 * 
 */
package fr.afcepf.al24.bank.service;

import java.util.Date;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 * @author Stagiaire
 *
 */
@WebService(targetNamespace="http://transaction.bank.al24.afcepf.fr/")
//@SOAPBinding(style=Style.RPC)
@SOAPBinding(style=Style.DOCUMENT) //Par défaut
//URL pour visualiser le fichier XSD : http://localhost:8080/Webservice_App/CalculateurFinance?xsd=1
public interface ITransactionBancaire {
	public WSRetourTransaction effectuerTransaction(@WebParam(name="numeroCarteDebit") Long numeroCarteDebit,@WebParam(name="dateFinValiditeDebit") Date dateFinValiditeDebit,@WebParam(name="cryptogrammeDebit") Integer cryptogrammeDebit,
			@WebParam(name="numeroCarteCredit") Long numeroCarteCredit,@WebParam(name="dateFinValiditeCredit") Date dateFinValiditeCredit,@WebParam(name="cryptogrammeCredit") Integer cryptogrammeCredit, @WebParam(name="montant") Double montant );
}
