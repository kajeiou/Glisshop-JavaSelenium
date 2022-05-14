package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Commande {
	private WebDriver driver;
	
	@FindBy(xpath ="/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div[2]/button")
	WebElement boutonCreerAdresse;
	
	@FindBy(xpath ="/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div[3]/form/div/div/button")
	WebElement boutonChoixPays;
	
	@FindBy(xpath ="/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div[3]/form/div/div/div/div/div[4]/div/div/div[1]/div")
	WebElement boutonFrance;
	
	@FindBy(xpath ="/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div[3]/form/div[3]/input")
	WebElement commandeNom;
	
	@FindBy(xpath ="/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div[3]/form/div[4]/input")
	WebElement commandePrenom;
	
	@FindBy(xpath ="/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div[3]/form/div[6]/input")
	WebElement commandeNumAdresse;
	
	@FindBy(xpath ="/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div[3]/form/div[7]/input")
	WebElement commandeNomAdresse;
					
	@FindBy(xpath ="/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div[3]/form/div[9]/input")
	WebElement commandeCp;
	
	@FindBy(xpath ="/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div[3]/form/div[10]/input")
	WebElement commandeVille;
	
	@FindBy(xpath ="/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[1]/div/div[3]/form/div[11]/input")
	WebElement commandeTelephone;
	
	@FindBy(xpath = "/html/body/div[2]/section/main/div/div/div[2]/div/div[3]/div/div/div/div/div[1]/div/div/div[1]/div/div/div[5]/button")
	WebElement boutonValiderCommande;
	
	public Commande(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(4000);
	}
	
	public void clickBoutonCreerAdresse() throws InterruptedException {
		boutonCreerAdresse.click();
		System.out.println("Bouton Creer Adresse cliqué");
		Thread.sleep(2000);
		
		boutonChoixPays.click();
		System.out.println("Bouton Choix Pays Adresse cliqué");
		Thread.sleep(2000);
		
		boutonFrance.click();
		System.out.println("Bouton France Adresse cliqué");
		Thread.sleep(2000);
	}
	
	public void remplirCommande(String nom, String prenom, String numAdresse, String nomAdresse, String cp, String ville, String telephone) {
		commandeNom.clear();
		commandeNom.sendKeys(nom);
		
		commandePrenom.clear();
		commandePrenom.sendKeys(prenom);
		
		commandeNumAdresse.clear();
		commandeNumAdresse.sendKeys(numAdresse);
		
		commandeNomAdresse.clear();
		commandeNomAdresse.sendKeys(nomAdresse);
		
		commandeCp.clear();
		commandeCp.sendKeys(cp);
		commandeVille.clear();
		commandeVille.sendKeys(ville);
		commandeTelephone.clear();
		commandeTelephone.sendKeys(telephone);
		
		System.out.println("Formulaire Commande remplit");
	}
	
	public void clickBoutonValiderCommande() throws InterruptedException {
		boutonValiderCommande.click();
		System.out.println("Bouton Valider Commande cliqué");
		Thread.sleep(4000);
	}
	
	
}
