/**
 * 
 */
package fr.afcepf.al24.bank.dao.api;

import java.util.Date;

import fr.afcepf.al24.bank.entites.CarteBancaire;
import fr.afcepf.al24.bank.entites.Compte;

/**
 * @author Stagiaire
 *
 */
public interface IDaoCarteBancaire {
	public CarteBancaire ajouterCarte(Compte compte,Long numero, Integer cryptogramme, Date dateEmmission, Date dateValidite);
	public boolean SupprimerCarte(CarteBancaire carte);
	public CarteBancaire rechercherCarte(Long numero, Integer cryptogramme, Date dateValidite);
}
