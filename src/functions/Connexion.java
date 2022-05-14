package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Connexion {
	private WebDriver driver;
	
	@FindBy(id= "block2-login")
	WebElement compteEmail;
	
	@FindBy(id= "block2-password")
	WebElement compteMdp;
	
	@FindBy(xpath ="/html/body/div[3]/section[2]/main/div/div[2]/div[1]/div/div/div/div/div/form/fieldset/div/div[2]/div[1]/button")
	WebElement boutonValiderConnexion;
	
	public Connexion(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
	}
	
	public boolean estOuvert() {
		return driver.getTitle().contains("Identification");
	}
	public void setCompteEmail(String email) {
		compteEmail.clear();
		compteEmail.sendKeys(email);
		System.out.println("Email de connexion remplit");
	}
	public void setCompteMdp(String mdp) {
		compteMdp.clear();
		compteMdp.sendKeys(mdp);
		System.out.println("MDP d'inscription remplit");
	}
	public void clickBoutonValiderInscription() {
		boutonValiderConnexion.click();
		System.out.println("Bouton Valider Connexion cliqué");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean estConnecte() {
		return driver.getTitle().contains("Mon compte");
		//return msgConfirmation.getText().contains("Votre compte a bien été créé");
	}
	
}
