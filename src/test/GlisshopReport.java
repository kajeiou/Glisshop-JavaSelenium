package test;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GlisshopReport {
	private ExtentReports extent;
	private Map<String, ExtentTest> tests = new HashMap<String, ExtentTest>();
	
	public GlisshopReport() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("rapports/Rapport.html");
		spark.config().setEncoding("UTF-8");
		extent.attachReporter(spark);
	}
	
	public void nouveauTest(String nom) {
		ExtentTest test = extent.createTest(nom);
		tests.put(nom, test);
		 
	}
	public ExtentTest getTest(String nom) {
		return tests.get(nom);
	}
	
	public void flush() {
		extent.flush();	
	}
}
