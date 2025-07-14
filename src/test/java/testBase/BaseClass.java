package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/*log4j
prepared one xml config file and placced uner resources
invoked LogMnager to our peoject to manage logs (addto baseclass)
used that Logger class for every action*/

public class BaseClass {


	public static WebDriver driver;
	
	public BaseClass(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//this constructor is for testcase method it has default constructor.
	public BaseClass(){
		
	}
	
	public Logger logger;  //Logger is a class

	//connection to properties file
	public Properties p;
	

	
	
	 @BeforeClass(groups= {"Sanity","Regression","Master"})
	 @Parameters({"os","browser"})
		public void setUp(String os,String br) throws IOException {
		 		 	
		 	//reading prop file
		    FileReader propFile = new FileReader(System.getProperty("user.dir")+"/src/test/resources//config.properties"); //we can use "./" instead getProperty
		    //creating prop file instance for usage
		    p=new Properties();
		    p.load(propFile);  //connecting means loading propfile and this base class 
		    
		    
		 	logger = (Logger) LogManager.getLogger(this.getClass());//grabing the class and assigning to log4j dynamically
		 	
		 	//for remote env --GRID 
		 	  if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
				{
					DesiredCapabilities capabilities=new DesiredCapabilities();
					
					//os
					if(os.equalsIgnoreCase("windows"))
					{
						capabilities.setPlatform(Platform.WIN11);
					}
					else if(os.equalsIgnoreCase("linux"))
					{
						capabilities.setPlatform(Platform.LINUX);
					}
										
					else if (os.equalsIgnoreCase("mac"))
					{
						capabilities.setPlatform(Platform.MAC);
					}
					else
					{
						System.out.println("No matching os");
						return;
					}
					
					//browser
					switch(br.toLowerCase())
					{
					case "chrome": capabilities.setBrowserName("chrome"); break;
					case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
					case "firefox" : capabilities.setBrowserName("firefox");break;
					default: System.out.println("No matching browser"); return;
					}
					
					driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
				}
		 	  
		 	  //this is for local env
		 	 if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		 	 {
		 	
		 	switch(br.toLowerCase()) {
		 	case "chrome" : driver =new ChromeDriver();break;
		 	case "edge" : driver = new EdgeDriver();break;
		 	case "firefox" : driver = new FirefoxDriver();break;
		 	default : System.out.println("invalid browser");return;  //here return means if invalid bowser execution should stop here only no need to further.
		 	}
		 	 }
		 	
			
			driver.get(p.getProperty("appUrl")); //reading url from properties file
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}
		
	    @AfterClass(groups= {"Sanity","Regression","Master"})
		public void tearDown() {
			driver.quit();
		}
	    
	    //code for genarating random string
	    
		public String randomStringCreation(){
	    	String ranStr =RandomStringUtils.randomAlphabetic(5);
	    return ranStr;
	    }
		
		//code for generating numeric data
		
		public String randomNumberCreation() {
			String ranNum = RandomStringUtils.randomNumeric(9);
			return ranNum;
		}
		
		//code for alphanumeric
		public String randomAlphaNumeric() {
			String genaratedString = RandomStringUtils.randomAlphanumeric(3);	
			String genaratedNumber = RandomStringUtils.randomNumeric(3);
			return genaratedString+"@"+genaratedNumber ;
		}
		
		public String captureScreen(String tname) throws IOException {  //this is for target file path creation

			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
					
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
			File targetFile=new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
				
			return targetFilePath;

		}
		
}
