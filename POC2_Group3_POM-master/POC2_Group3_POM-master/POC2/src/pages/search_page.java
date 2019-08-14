package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class search_page {
	WebDriver dr;
	read_write rw;
	By xp=By.xpath("//select[@name=\"category_id\"]");
	By xp1=By.xpath("//input[@name=\"price_from\"]");
	By xp2=By.xpath("//input[@name=\"price_to\"]");
	By xp3=By.xpath("//tr[@class=\"Bottom\"]/td/input");
	public search_page(WebDriver dr)
	{
		this.dr=dr;
	}
	public void search(String s1,String s2,String s3)
	{
		rw=new read_write();
		
		dr.findElement(xp).sendKeys(s1);
		dr.findElement(xp1).sendKeys(s2);
		dr.findElement(xp2).sendKeys(s3);
		dr.findElement(xp3).click();
	}
}
