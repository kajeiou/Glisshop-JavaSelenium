package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	private WebDriver driver;
	private static String PAGE_URL="https://www.glisshop.com";
	
	@FindBy(id = "tarteaucitronAllDenied2")
	WebElement cookies;
	
	@FindBy(xpath ="/html/body/header/div/div[1]/div/div[4]/div[2]/div/div/a")
	WebElement boutonCompte;
	
	@FindBy(xpath = "/html/body/div[3]/section[2]/main/div/div[1]/ul/li[2]/a")
	WebElement ongletConnexion;
	
	public Home(WebDriver driver) throws InterruptedException {
		this.setDriver(driver);
		driver.get(PAGE_URL);
		System.out.println("Accès à " + PAGE_URL);
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
		cookies.click();
	}
	public void goHome() throws InterruptedException {
		this.setDriver(driver);
		driver.get(PAGE_URL);
		System.out.println("Accès à " + PAGE_URL);
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
	}
	public void goConnexion() throws InterruptedException {
		this.setDriver(driver);
		String url = "https://www.glisshop.com/identification/";
		driver.get(url);
		System.out.println("Accès à " + url);
		PageFactory.initElements(driver, this);
		Thread.sleep(5000);
	}
	public void clickBoutonCompte() throws InterruptedException {
		boutonCompte.click();
		System.out.println("Bouton Compte cliqué");
		Thread.sleep(5000);
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void retour() {
		driver.navigate().back();
	}
	
	public void clickOngletConnexion() throws InterruptedException {
		Thread.sleep(5000);
		ongletConnexion.click();
	}
	
	/*public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nabil\\Desktop\\chromedriver\\chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.glisshop.com");
		System.out.println("Site internet "+ driver.getTitle()+" ouvert avec succès.");

		System.out.println();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[7]/div[3]/span[2]/button[1]")).click();
		
		driver.findElement(By.xpath("/html/body/header/div/div[1]/div/div[4]/div[2]/div/div/a")).click();
		System.out.println("Début Procédure inscription");
		Thread.sleep(5000);
		driver.quit();
	}*/
}
