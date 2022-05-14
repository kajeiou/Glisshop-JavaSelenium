package test;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.MediaEntityBuilder;
import functions.Commande;
import functions.Compte;
import functions.Connexion;
import functions.Home;
import functions.Inscription;
import functions.Panier;
import functions.Recherche;
import objects.Utilisateur;

public class GlisshopTest {
	 WebDriver driver ;
	 GlisshopReport report;
	 GlisshopDb database;
	 GlisshopScreenShot screen;
	 Utilisateur utilisateur;
	 String fileDriver = "C:\\Users\\Nabil\\Desktop\\chromedriver\\chromedriver.exe";
	 
	 @Before
	 public void setupDb() {
		 try {
			 database = new GlisshopDb();
			if(database.estConnecte()) {
				report.getTest("Configuration").pass("Database successfully connected");
			}
			
		} catch (SQLException e) {
			 report.getTest("Configuration").fail("Database not connected");
		}
		 try {
			utilisateur = database.getUtilisateur(1);
			if(utilisateur != null) {
				report.getTest("Configuration").pass("User successfully loaded");
				report.getTest("Configuration").pass("User created " + this.utilisateur.toString());
			}
			
		} catch (SQLException e) {
			
			report.getTest("Configuration").pass("User not loaded");
		}
	 }
	 @Before
	 public void setupDriver() {
		 try {
		 	System.setProperty("webdriver.chrome.driver", fileDriver );
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			report.getTest("Configuration").pass("Driver successfully connected");
		 }
		 catch(Exception e) {
			 report.getTest("Configuration").fail("Driver not connected");
		 }
	 }

	@Before
	public void setup() throws InterruptedException, SQLException{
		report = new GlisshopReport();
		report.nouveauTest("Configuration");
		setupDb();
		setupDriver();
		screen= new GlisshopScreenShot(driver);
	}
	
	@Test
	void GlisshopTest() throws Exception, InterruptedException{
		
	// Début du script
		try {
			setup();
			GlisshopRecord.startRecording("GlisshopTest");
			report.getTest("Configuration").pass("Configuration finished");
		}
		catch (Exception e){
			report.getTest("Configuration").pass("Configuration failed", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Configuration.png").build());
		}
		
	// Page d'accueil
		Home home = new Home(driver);
		try {
			
			report.getTest("Configuration").pass("Home page successfully launched");
			//home.clickBoutonCompte();
		}catch(Exception e) {
			screen.screenShot("Configuration");
			report.getTest("Configuration").fail("Home page not launched",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Configuration.png").build() );
		}
		
	// Inscription
		
		Inscription inscription = new Inscription(driver);
		try {
			report.nouveauTest("Inscription");
			if(inscription.estOuvert()) {
				report.getTest("Inscription").pass("Registration page successfully opened");
			}
			else {
				screen.screenShot("Inscription");
				report.getTest("Inscription").fail("Registration page not opened",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Inscription.png").build() );
			}
		}catch(Exception e) {
			screen.screenShot("Inscription");
			report.getTest("Inscription").fail("Registration page not opened", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Inscription.png").build());
		}	
		
		// Formulaire Inscription
		try {
			inscription.setCompteEmail(utilisateur.getEmail());
			inscription.setCompteMdp(utilisateur.getMdp());
			inscription.setCompteMdp2(utilisateur.getMdp());
			inscription.clickBoutonValiderInscription();
			if(inscription.estInscrit()) {
				report.getTest("Inscription").pass("User successfully registered");
			}
			else {
				screen.screenShot("Inscription");
				report.getTest("Inscription").fail("User not registered",MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Inscription.png").build());
			}
			
		}catch (Exception e) {
			screen.screenShot("Inscription");
			report.getTest("Inscription").fail("User not registered", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Inscription.png").build());
		}
		try {
			inscription.clickBoutonConnexion();
			report.getTest("Inscription").pass("Button Login successfully founded");
			
		}catch(Exception e) {
			home.goConnexion();
			screen.screenShot("Inscription");
			report.getTest("Inscription").fail("Button Login not founded", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Inscription.png").build());
		}
		
		
		
	
		
	// Recherche d'article
		report.nouveauTest("Rechercher");
		Recherche recherche = new Recherche(driver);
		try {
			String search = database.getRecherche(1);
			recherche.rechercher(search);
			recherche.clickBoutonRechercher();
			if(recherche.estRecherche()) {
				report.getTest("Rechercher").pass("Successful search for " + search);
			}
			else {
				screen.screenShot("Rechercher");
				report.getTest("Rechercher").fail("Search for " + search + " not done", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Rechercher.png").build());
			}
		}catch(Exception e) {
			screen.screenShot("Rechercher");
			report.getTest("Rechercher").fail("Search not done", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Rechercher.png").build());
		}
		
		// Choix de l'article
		report.nouveauTest("Panier");
		for(int i = 1; i<=database.getQuantiteRecherche(1); i++) {
			try {
				recherche.clickBoutonArticle(i);
				if(recherche.estChoisi()) {
					report.getTest("Rechercher").pass("Product "+i+" successfully selected");
				}
				else {
					screen.screenShot("Rechercher");
					report.getTest("Rechercher").fail("Product "+i+" not selected", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Rechercher.png").build());
				}
			}
			catch(Exception e) {
				screen.screenShot("Rechercher");
				report.getTest("Rechercher").fail("Product "+i+" not selected", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Rechercher.png").build());
			}
			
			
			Panier panier = new Panier(driver);
			try {
				panier.clickBoutonAjouterPanier();
				if(panier.estAjoute()) {
					report.getTest("Panier").pass("Product "+i+" successfully added");
					home.retour();
				}
				else {
					screen.screenShot("Panier");
					report.getTest("Panier").fail("Product "+i+" not added", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Panier.png").build());
				}
			}catch (Exception e) {
				screen.screenShot("Panier");
				report.getTest("Panier").fail("Product "+i+" not added", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Panier.png").build());
			}
		}
		
		Panier panier = new Panier(driver);
	// Ouvrir Panier
		panier.clickOpenPanier();
		
	// Retirer 1 produit
		try {
			panier.clickBoutonRetirerArticle();
			panier.clickOpenPanier();
			report.getTest("Panier").pass("Product successfully removed from Shopping cart");
		}catch (Exception e) {
			screen.screenShot("Panier");
			report.getTest("Panier").fail("Product not removed from Shopping cart", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Panier.png").build());
		}

		
	
		
	// Création Adresse + Validation Commande
		
		report.nouveauTest("Commande");
		try {
			Commande commande = new Commande(driver);
			commande.clickBoutonCreerAdresse();
			commande.remplirCommande(utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getNumAdresse(), utilisateur.getNomAdresse(), utilisateur.getCpAdresse(), utilisateur.getVilleAdresse(), utilisateur.getTelephone());
			commande.clickBoutonValiderCommande();
			report.getTest("Commande").pass("Order succesfully validated");
		}catch(Exception e) {
			screen.screenShot("Commande");
			report.getTest("Commande").fail("Order not validated", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Commande.png").build());
		}
		
		
		home.goHome();
		home.clickBoutonCompte();
		
	// Compte
		report.nouveauTest("Compte");
		try {
			Compte compte = new Compte(driver);
			if(compte.estOuvert()) {
				report.getTest("Compte").pass("Account page succesfully opened");
			}
			else {
				screen.screenShot("Compte");
				report.getTest("Compte").fail("Account page not opened", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Compte.png").build());
			}
//			Connexion
				report.nouveauTest("Connexion");
				Connexion connexion = new Connexion(driver);
				home.clickOngletConnexion();
				//Assert.assertTrue(connexion.estOuvert());
				if(connexion.estOuvert()) {
					report.getTest("Connexion").pass("Login page successfully opened");
				}
				else {
					screen.screenShot("Connexion");
					report.getTest("Connexion").fail("Login page not opened", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Connexion.png").build());
				}
			// Formulaire Connexion
				try {
					
					connexion.setCompteEmail(utilisateur.getEmail());
					connexion.setCompteMdp(utilisateur.getMdp());
					connexion.clickBoutonValiderInscription();
					
					//Assert.assertTrue(connexion.estConnecte());
					if(connexion.estConnecte()) {
						report.getTest("Connexion").pass("User successfully connected");
					}
					else {
						screen.screenShot("Connexion");
						report.getTest("Connexion").fail("User not connected", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Connexion.png").build());
					}
				}catch(Exception e) {
					screen.screenShot("Connexion");
					report.getTest("Connexion").fail("User not connected", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Connexion.png").build());
				}
				// Finaliser Panier
				try {
					panier.clickOpenPanier();
					panier.clickBoutonFinaliserCommande();
					Assert.assertTrue(panier.estFinalise());
					if(panier.estFinalise()) {
						report.getTest("Panier").pass("Shopping cart successfully finalized");
					}
					else {
						screen.screenShot("Panier");
						report.getTest("Panier").fail("Shopping cart not finalized", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Panier.png").build());
					}
				}catch(Exception e) {
					screen.screenShot("Panier");
					report.getTest("Panier").fail("Shopping cart not finalized", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Panier.png").build());
				}
				
				try {
					panier.clickAccepterCGU();
					panier.clickBoutonPasserCommande();
					
					Assert.assertTrue(panier.estPasse());
					if(panier.estPasse()) {
						report.getTest("Panier").pass("Shopping cart successfully validated");
					}
					else {
						screen.screenShot("Panier");
						report.getTest("Panier").fail("Shopping cart not validated", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Panier.png").build());
					}
					home.goHome();
					home.clickBoutonCompte();
				}catch (Exception e) {
					report.getTest("Panier").fail("Shopping cart not validated", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Panier.png").build());
				}
			
		// Deconnexion
			compte.clickBoutonDeconnexion();
			home.clickBoutonCompte();
			if(compte.estOuvert()==false) {
				report.getTest("Compte").pass("User successfully disconnected");
			}
			else {
				screen.screenShot("Compte");
				report.getTest("Compte").fail("User not disconnected", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Compte.png").build());
			}
		}catch(Exception e) {
			screen.screenShot("Compte");
			report.getTest("Compte").fail("Account page not opened", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\Nabil\\eclipse-workspace\\Glisshop\\rapports\\screens\\Compte.png").build());
		}
		
		close();
	}
	@After
	public void close() throws Exception{
		Thread.sleep(5000);
		GlisshopRecord.stopRecording();
		driver.close();
		report.flush();
		
	}

}
