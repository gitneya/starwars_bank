/**
 * 
 */
package fr.afcepf.al24.bank.mbean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al24.bank.dao.api.IDaoTransactionBancaire;
import fr.afcepf.al24.bank.entites.TransactionBancaire;

/**
 * @author Stagiaire
 *
 */
@ManagedBean(name="transactionBean")
@SessionScoped
public class TransactionBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<TransactionBancaire> listetransaction;

	@ManagedProperty(value="#{daoTransactionBancaire}")
	private IDaoTransactionBancaire daoTransactionBancaire;

	@ManagedProperty(value="#{loginBean}")
	private LoginBean loginBean;

	@PostConstruct
	public void init() {
		if (loginBean != null && loginBean.getClient() != null) {
			listetransaction = daoTransactionBancaire.retournerLestransactionsParClient(loginBean.getClient());
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
	public List<TransactionBancaire> getListetransaction() {
		return listetransaction;
	}

	/**
	 * @param listetransaction the listetransaction to set
	 */
	public void setListetransaction(List<TransactionBancaire> listetransaction) {
		this.listetransaction = listetransaction;
	}

	/**
	 * @param daoTransactionBancaire the daoTransactionBancaire to set
	 */
	public void setDaoTransactionBancaire(
			IDaoTransactionBancaire daoTransactionBancaire) {
		this.daoTransactionBancaire = daoTransactionBancaire;
	}
}
