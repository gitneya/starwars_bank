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
@WebService(targetNamespace="http://validation.bank.al24.afcepf.fr/")
//@SOAPBinding(style=Style.RPC)
@SOAPBinding(style=Style.DOCUMENT) //Par défaut
//URL pour visualiser le fichier XSD : http://localhost:8080/Webservice_App/CalculateurFinance?xsd=1
public interface IValiderCarteBancaire {
	public boolean validerCarte(@WebParam(name="numeroCarte") Long numeroCarte,@WebParam(name="dateFinValidite") Date dateFinValidite,@WebParam(name="cryptogramme") Integer cryptogramme);
}
