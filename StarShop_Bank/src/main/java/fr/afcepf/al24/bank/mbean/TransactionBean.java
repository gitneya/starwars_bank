/**
 * 
 */
package fr.afcepf.al24.bank.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al24.bank.dao.api.IDaoCompte;
import fr.afcepf.al24.bank.dao.api.IDaoTransactionBancaire;
import fr.afcepf.al24.bank.dto.TransactionDto;

/**
 * @author Stagiaire
 *
 */
@ManagedBean(name="transactionBean")
//@SessionScoped
@RequestScoped
public class TransactionBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<TransactionDto> listetransaction;
	private Double solde;

	@ManagedProperty(value="#{daoTransactionBancaire}")
	private IDaoTransactionBancaire daoTransactionBancaire;

	@ManagedProperty(value="#{daoCompte}")
	private IDaoCompte daoCompte;
	
	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;

	@PostConstruct
	public void init() {
		initDonnees();
	}
	
	private void initDonnees() {
		if (loginBean != null && loginBean.getClient() != null) {
			listetransaction = daoTransactionBancaire.retournerLestransactionsParClient(loginBean.getClient());
			solde = daoCompte.retournerSolde(loginBean.getClient());
		}	
	}
	/**
	 * 
	 */
	public TransactionBean() {
	}

	/**
	 * @param loginBean the loginBean to set
	 */
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	/**
	 * @return the listetransaction
	 */
	public List<TransactionDto> getListetransaction() {
		return listetransaction;
	}

	/**
	 * @param listetransaction the listetransaction to set
	 */
	public void setListetransaction(List<TransactionDto> listetransaction) {
		this.listetransaction = listetransaction;
	}

	/**
	 * @param daoTransactionBancaire the daoTransactionBancaire to set
	 */
	public void setDaoTransactionBancaire(
			IDaoTransactionBancaire daoTransactionBancaire) {
		this.daoTransactionBancaire = daoTransactionBancaire;
	}
	/**
	 * @param daoCompte the daoCompte to set
	 */
	public void setDaoCompte(IDaoCompte daoCompte) {
		this.daoCompte = daoCompte;
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
}
