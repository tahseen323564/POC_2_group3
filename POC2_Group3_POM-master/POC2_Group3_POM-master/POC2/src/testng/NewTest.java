package testng;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pages.read_write;
import pages.search_page;
import pages.verify_page;
import pages.verify_title;

public class NewTest {
  WebDriver dr;
  verify_title v;
  search_page sp;
  verify_page vp;
  read_write rw;
  ArrayList<String> a_price;
  ArrayList<String> e_price=new ArrayList();
  ArrayList<String> a_product;
  ArrayList<String> e_product=new ArrayList();
  int i=0;
  int j=0;
  String s1=null;
  String s2=null;
  String s3=null;

  @BeforeClass
  public void entry() {
	   System.setProperty("webdriver.chrome.driver", "chromedriver_v75.exe");
	   dr=new ChromeDriver();
	   dr.get("http://examples.codecharge.com/Store/Search.php");   
	   vp=new verify_page(dr);
	   e_product=vp.get_product();
	   e_price=vp.get_price();
	   rw=new read_write();
	   s1=rw.read(1, 0, "D:\\POC2.xlsx");
	   s2=rw.read1(1, 1, "D:\\POC2.xlsx");
	   s3=rw.read1(1, 2, "D:\\POC2.xlsx");
	   System.out.println(s1+" "+s2+" "+s3);
  }
  @AfterClass
  public void exit()
  {
	  dr.quit();
  }
  @Test(priority=1)
  public void f1()
  {
	  sp=new search_page(dr);
	  sp.search(s1,s2,s3);
  }
  @Test(priority= 4 ,dataProvider="product")
  public void a(String anop)
  {
	  
	  vp=new verify_page(dr);
	  String enop=e_product.get(i); 
	  WebDriverWait wt = new WebDriverWait(dr,10);                             
	  wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='Row']/td/b")));
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  vp.create_log("verify_products", enop, anop,result );
	  i++;
  }
  @DataProvider(name="product")
  public Iterator<String> get_testdata()
  {
	  vp=new verify_page(dr);
	  a_product=vp.verify_product();
	  return a_product.iterator();
  }
  @Test(priority =5,dataProvider="price")
  public void b(String anop)
  {
	  
	  vp=new verify_page(dr);
	  String enop=e_price.get(j);
	  
	  WebDriverWait wt = new WebDriverWait(dr,10);                             
	  wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='Row']/td[2]")));
	  String result="";
	  Assert.assertEquals(anop, enop);
	  result="PASS";
	  vp.create_log("verify_price", enop, anop,result );
	  j++;
  }
  @DataProvider(name="price")
  public Iterator<String> get_testdata1()
  {
	  vp=new verify_page(dr);
	  a_price=vp.verify_price();
	  return a_price.iterator();
  }
 
}
