/**
 * 
 */
package fr.afcepf.al24.bank.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al24.bank.dao.api.IDaoCarteBancaire;
import fr.afcepf.al24.bank.entites.CarteBancaire;

/**
 * @author Stagiaire
 *
 */
@Transactional
@Component
@WebService(targetNamespace="http://service.bank.al24.afcepf.fr/", 
endpointInterface="fr.afcepf.al24.bank.service.IValiderCarteBancaire")
public class ValiderCarteBancaireImpl implements IValiderCarteBancaire {

	Logger log = Logger.getLogger(ValiderCarteBancaireImpl.class);
	@Autowired
	private IDaoCarteBancaire daoCarte;
	
	/* (non-Javadoc)
	 * @see fr.afcepf.al24.bank.service.IValiderCarteBancaire#validerCarte(java.math.BigInteger, java.util.Date, java.lang.Integer)
	 */
	@Override
	public boolean validerCarte(Long numeroCarte, Date dateFinValidite,
			Integer cryptogramme) {
		// date reçu en format xs:date : "YYYY-MM-DD"
		log.info("ValiderCarteBancaireImpl.validerCarte : numeroCarte=" + numeroCarte);
		CarteBancaire carte = daoCarte.rechercherCarte(numeroCarte, cryptogramme, dateFinValidite);
		if (carte != null) {
			Date dateCourante = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM");
			try {
				if (dateFormat.parse(dateFormat.format(carte.getDateFinValidite()))
						.compareTo(dateFormat.parse(dateFormat.format(dateCourante))) <= 0 ) {
					//Date invalide
					log.info("ValiderCarteBancaireImpl.validerCarte : numeroCarte=" + numeroCarte + " n'est plus valide (date expirée) !!!!!!!");
					log.info("**********************************************************************************************************");
					carte = null;
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}		
		
		return carte == null ? false : true;
	}

}
