package test;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class GlisshopScreenShot {
	TakesScreenshot ts;
	
	public GlisshopScreenShot(WebDriver driver) {
		 ts = (TakesScreenshot) driver;
	}
	public void screenShot(String name) throws IOException {
		File src = ts.getScreenshotAs(OutputType.FILE);
		File file = new File("./rapports/screens/"+name+".png");
		FileUtils.copyFile(src, file);
	}
}
