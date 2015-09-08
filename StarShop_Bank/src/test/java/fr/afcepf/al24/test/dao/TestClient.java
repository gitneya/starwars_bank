/**
 * 
 */
package fr.afcepf.al24.test.dao;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.afcepf.al24.bank.dao.api.IDaoClient;
import fr.afcepf.al24.bank.dao.impl.DaoClientImpl;
import fr.afcepf.al24.bank.entites.Client;

/**
 * @author Stagiaire
 *
 */
public class TestClient {
	 /**
     * Outil de log.
     */
    private Logger log = Logger.getLogger(TestClient.class);
    /**
     * Interface d'accès aux données et son implémentation.
     */
    private IDaoClient client = new DaoClientImpl();
    /**
     * Avant l'exécution des tests, donc méthode static.
     */
    @AfterClass
    public static void avantLesTests() {
    }
    /**
     * Après l'exécution des tests, donc méthode static.
     */
    @BeforeClass
    public static void apresLesTests() {
    }
    /**
     * Exécuté avant chaque test.
     */
    @Before //Setup sous Junit3
    public void initTest() {
    	/*
        //Ici, on est plus dans le test d'intégration car on est dépendant
        //Seulement cette méthode dans un serveur d'application
        String cheminDotBat = Thread.currentThread().getContextClassLoader().getResource("creationBdd.bat").getPath();
        //sinon on peut faire un ?? class.getresourse ...
        String line;
        try {
            //Execute le .bat de creation de la table
            log.info("Execute le fichier de commande :" + cheminDotBat);
            Process process = Runtime.getRuntime().exec(cheminDotBat);
            //Pour rediriger la sortie standard du processus
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = input.readLine()) != null) {
              System.out.println(line);
            }
            //Attend la fin de l'execution du processus (thread principal du processus
            process.waitFor();
            //Ferme le flux
            input.close();
            log.debug("Fin de création de la base");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
    }
    /**
     * Exécuté après chaque test.
     */
    @After //tearDown sous Junit3
    public void endTest() {
    }
    
	@Test
	public void testAjouterClient() {
	    IDaoClient daoClient = new DaoClientImpl();
	    return;
	    /*
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Client retourClient = daoClient.ajouterClient(BigInteger.valueOf(1),"Dupond", "Eric", sdf.parse("01/05/1975"));
			Assert.assertNotNull(retourClient.getId());
			Assert.assertNotNull(retourClient.getNom());
			Assert.assertNotNull(retourClient.getPrenom());
			Assert.assertNotNull(retourClient.getDateNaissance());
			Assert.assertNotNull(retourClient.getNumeroIdentite());
	        //Assert.assertEq(retourClient.getNumeroIdentite().compareTo(BigInteger.valueOf(1)));
	        
	      			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
	}
	
}
