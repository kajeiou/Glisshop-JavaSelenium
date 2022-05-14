package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Inscription {
	private WebDriver driver;
	
	@FindBy(id= "rbs-user-create-account-email")
	WebElement compteEmail;
	
	@FindBy(id= "rbs-user-create-account-password")
	WebElement compteMdp;
	
	@FindBy(id= "rbs-user-create-account-confirm-password")
	WebElement compteMdp2;
	
	@FindBy(xpath ="/html/body/div[3]/section[2]/main/div/div[2]/div/div/div/div[1]/div/form/fieldset[2]/div/button")
	WebElement boutonValiderInscription;
	
	@FindBy(xpath ="/html/body/div[3]/section[2]/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/p[1]")
	WebElement msgConfirmation;
	
	@FindBy(xpath ="/html/body/div[3]/section[2]/main/div/div[2]/div/div/div/div[1]/div/div[2]/div/a")
	WebElement boutonConnexion;
	
	public Inscription(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
	}
	public boolean estOuvert() {
		return driver.getTitle().contains("Création de compte");
	}
	public boolean estInscrit() {
		return msgConfirmation.getText().contains("Votre compte a bien été créé");
	}
	public void setCompteEmail(String email) {
		compteEmail.clear();
		compteEmail.sendKeys(email);
		System.out.println("Email d'inscription remplit");
	}
	public void setCompteMdp(String mdp) {
		compteMdp.clear();
		compteMdp.sendKeys(mdp);
		System.out.println("MDP d'inscription remplit");
	}
	public void setCompteMdp2(String mdp) {
		compteMdp2.clear();
		compteMdp2.sendKeys(mdp);
		System.out.println("MDP2 d'inscription remplit");
	}
	public void clickBoutonValiderInscription() {
		boutonValiderInscription.click();
		System.out.println("Bouton Valider Inscription cliqué");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void clickBoutonConnexion() {
		boutonConnexion.click();
		System.out.println("Bouton Connexion cliqué");
	}
}
