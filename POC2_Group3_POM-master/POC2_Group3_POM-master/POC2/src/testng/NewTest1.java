package testng;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.read_write;
import pages.search_page;
import pages.verify_page;
import pages.verify_title;

public class NewTest1 {
	  WebDriver dr;
	  verify_title v;
	  
	  

	  @BeforeClass
	  public void entry() {
		   System.setProperty("webdriver.chrome.driver", "chromedriver_v75.exe");
		   dr=new ChromeDriver();
		   dr.get("http://examples.codecharge.com/Store/Default.php");   		 
	  }
	  @AfterClass
	  public void exit()
	  {
		  dr.quit();
	  }
	  @Test(priority=0)
	  public void f()
	  {
		  v=new verify_title(dr);
		  String er="Online Bookstore";
		  String ar=v.vt();
		  v.click_search();
		  Assert.assertEquals(er, ar);
	  }
}
