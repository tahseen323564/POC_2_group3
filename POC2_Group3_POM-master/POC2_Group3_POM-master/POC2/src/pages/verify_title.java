package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class verify_title {
	WebDriver dr;
	By xp=By.xpath("/html/body/table[2]/tbody/tr/td/a[2]");
	public verify_title(WebDriver dr)
	{
		this.dr=dr;
	}
	public String vt()
	{
		String s=dr.getTitle();
		return s;
	}
	public void click_search()
	{
		dr.findElement(xp).click();
	}
	
}
