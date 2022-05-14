package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Compte {
	private WebDriver driver;
	
	@FindBy(xpath ="/html/body/div[3]/section[2]/div[2]/div[1]/aside/div/div/nav/ul/li[3]/a")
	WebElement ongletMotDePasse;
	
	@FindBy(xpath = "/html/body/div[3]/section[2]/div[2]/div[1]/aside/div/div/nav/ul/li[4]/a")
	WebElement ongletEmail;
	
	@FindBy(xpath ="/html/body/div[3]/section[2]/div[2]/div[1]/aside/div/div/nav/ul/li[5]/a")
	WebElement ongletAdresses;
	
	@FindBy(id = "block5-password-current")
	WebElement mdpActuel;
	
	@FindBy(id ="block5-password-new")
	WebElement mdpNouveau;
	
	@FindBy(id ="block5-password-confirm")
	WebElement mdpConfirmer;
	
	@FindBy(xpath ="/html/body/div[3]/section[2]/div[2]/div[1]/main/div/div/div/div/div/div/form/fieldset/div[2]/div/button")
	WebElement boutonEnregistrerMdp;
				
	@FindBy(xpath ="/html/body/div[3]/section[2]/div[2]/div[1]/main/div/div/div/div/div/div/form/fieldset/div[1]/div[1]/p")
	WebElement msgMdpSuccessChange;
	
	@FindBy(id ="block2-password")
	WebElement emailMdp;
	
	@FindBy(id ="block2-new")
	WebElement emailNouveau;
	
	@FindBy(xpath ="/html/body/div[3]/section[2]/div[2]/div[1]/main/div/div/div/div/form/fieldset/div[3]/div/button")
	WebElement boutonEnregistrerEmail;
	
	@FindBy(xpath ="/html/body/div[3]/section[2]/div[2]/div[1]/main/div/div/div/div/div/div/div/div/div[1]/p")
	WebElement msgEmailSuccessChange;
	
	@FindBy(xpath ="/html/body/div[3]/section[2]/div[2]/div[1]/aside/div/div/nav/a")
	WebElement boutonDeconnexion;
	
	
	public Compte(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
	}
	public boolean estOuvert() {
		return driver.getTitle().contains("Mes informations");
	}
	
	public void clickOngletMotDePasse() throws InterruptedException {
		ongletMotDePasse.click();
		System.out.println("Onglet Mot de passe");
		Thread.sleep(5000);
		
	}
	public void clickOngletEmail() throws InterruptedException {
		ongletEmail.click();
		System.out.println("Onglet Email");
		Thread.sleep(5000);
	}
	public void clickOngletAdresses() throws InterruptedException {
		ongletAdresses.click();
		System.out.println("Onglet Adresses");
		Thread.sleep(5000);
		
	}
	public void setMdpActuel(String mdp) {
		mdpActuel.clear();
		mdpActuel.sendKeys(mdp);
		System.out.println("Mot de passe actuel remplit");
	}
	public void setMdpNouveau(String mdp) {
		mdpNouveau.clear();
		mdpNouveau.sendKeys(mdp);
		System.out.println("Nouveau mot de passe remplit");
	}
	public void setMdpConfirmer(String mdp) {
		mdpConfirmer.clear();
		mdpConfirmer.sendKeys(mdp);
		System.out.println("Mot de passe de confirmation remplit");
	}
	public void clickBoutonEnregistrerMdp() throws InterruptedException {
		boutonEnregistrerMdp.click();
		System.out.println("Bouton enregistrer Mdp cliqué");
		Thread.sleep(5000);
	}
	
	public boolean estMdpChange() {
		if(msgMdpSuccessChange.isDisplayed()) {
			return true;
		}
		return false;
	}
	
	public void setEmailMdp(String mdp) {
		emailMdp.clear();
		emailMdp.sendKeys(mdp);
		System.out.println("Mot de passe pour changement d'email remplit");
	}
	
	public void setEmailNouveau(String email) {
		emailNouveau.clear();
		emailNouveau.sendKeys(email);
		System.out.println("Nouvelle email remplit");
	}
	
	public void clickBoutonEnregistrerEmail() throws InterruptedException {
		boutonEnregistrerEmail.click();
		System.out.println("Bouton enregistrer Email cliqué");
		Thread.sleep(5000);
	}
	public boolean estEmailChange() {
		if(msgEmailSuccessChange.isDisplayed()) {
			return true;
		}
		return false;
	}
	public void clickBoutonDeconnexion() throws InterruptedException {
		boutonDeconnexion.click();
		System.out.println("Bouton Déconnexion");
		Thread.sleep(5000);
	}

}
