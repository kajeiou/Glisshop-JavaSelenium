package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Panier {
	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/div[3]/section[2]/main/div/div[1]/article/div[2]/div[2]/div[1]/div[2]/div/div[3]/div[2]/div/div[1]/div/div/div[2]/button")
	WebElement boutonAjouterPanier;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div")
	WebElement dialogueAjouterPanier;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div/div/div/div/div/div[1]/button")
	WebElement boutonFermerDialogueAjouterPanier;
	
	@FindBy(xpath ="/html/body/header/div/div[1]/div/div[4]/div[3]/div/div/div[2]/div/a")
	WebElement boutonOpenPanier;
	
	@FindBy(xpath ="/html/body/header/div/div[1]/div/div[4]/div[3]/div/div/div[2]/div/div[1]/div[1]/ul/li[1]/div[2]/div[3]/button")
	WebElement boutonRetirerArticle;
	
	@FindBy(xpath ="/html/body/header/div/div[1]/div/div[4]/div[3]/div/div/div[2]/div/div[1]/div[2]/div/div[2]/a")
	WebElement boutonFinaliserCommande;
	
	@FindBy(id ="acceptTermsAndConditions")
	WebElement boutonAccepterCGU;
	
	@FindBy(xpath = "/html/body/div[2]/section/main/div/div[7]/div[1]/div/div[2]/div/div[2]/a[1]")
	WebElement boutonPasserCommande;
	
	public Panier(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
	}
	
	public void clickBoutonAjouterPanier() throws InterruptedException {
		boutonAjouterPanier.click();
		System.out.println("Bouton Ajouter Panier cliqué");
		Thread.sleep(4000);
	}
	
	public boolean estAjoute() {
		if(dialogueAjouterPanier !=null) {
			return true;
		}
		return false;
	}
	public void clickBoutonFermerDialogueAjouterPanier() {
		boutonFermerDialogueAjouterPanier.click();
	}
	public void clickOpenPanier() throws InterruptedException {
		boutonOpenPanier.click();
		System.out.println("Bouton Go Panier cliqué");
		Thread.sleep(4000);
	}
	public void clickBoutonRetirerArticle() throws InterruptedException {
		boutonRetirerArticle.click();
		System.out.println("Bouton Retirer Article cliqué");
		Thread.sleep(4000);
	}
	public void clickBoutonFinaliserCommande() throws InterruptedException {
		boutonFinaliserCommande.click();
		System.out.println("Bouton Finaliser Commande cliqué");
		Thread.sleep(4000);
	}
	public boolean estFinalise() {
		return driver.getTitle().contains("Mon panier");
	}
	
	public void clickAccepterCGU() throws InterruptedException {
		Thread.sleep(4000);
		Actions actions = new Actions(driver);
		Boolean etat = boutonAccepterCGU.isSelected();
		if(etat == false) {
			System.out.println(boutonAccepterCGU.isSelected());
			actions.moveToElement(boutonAccepterCGU).click().build().perform();
			System.out.println("Bouton Accepter CGU cliqué");
		}
		else {
			System.out.println("CGU déja cliqué");
		}
		
		Thread.sleep(4000);
	}
	public void clickBoutonPasserCommande() throws InterruptedException {
		boutonPasserCommande.click();
		System.out.println("Bouton Passer Commande cliqué");
		Thread.sleep(4000);
	}
	public boolean estPasse() throws InterruptedException {
		Thread.sleep(4000);
		return driver.getTitle().contains("Passer ma commande");
	}
	
	
}
