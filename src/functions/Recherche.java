package functions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recherche {
	private WebDriver driver;
	
	@FindBy(xpath = "/html/body/header/div/div[1]/div/div[3]/div/form/div/input")
	WebElement recherche;
	
	@FindBy(xpath = "/html/body/header/div/div[1]/div/div[3]/div/form/div/span/button")
	WebElement boutonRechercher;
	
	public Recherche(WebDriver driver) throws InterruptedException {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
	}
	public void rechercher(String produit) {
		recherche.clear();
		recherche.sendKeys(produit);
		System.out.println("Recherche du produit " + produit);
	}
	public void clickBoutonRechercher() throws InterruptedException {
		boutonRechercher.click();
		System.out.println("Bouton Rechercher cliqué");
		Thread.sleep(5000);
	}
	
	public boolean estRecherche() {
		return driver.getTitle().contains("Résultat de recherche");
	}
	public void clickBoutonArticle(int num) throws InterruptedException {
		WebElement boutonArticle = driver.findElement(By.xpath("/html/body/div[3]/section[2]/main/div/div/div/div/div[2]/div[2]/div[2]/div["+num+"]/a"));
		boutonArticle.click();
		System.out.println("Bouton Produit "+num+" cliqué");
		Thread.sleep(2000);
	}
	
	public boolean estChoisi() {
		return driver.findElement(By.xpath("/html/body/div[3]/section[2]/main/div/div[1]/article/div[2]/div[2]/div[1]/div[2]/div/header/h1")).isDisplayed();
	}
	

}
