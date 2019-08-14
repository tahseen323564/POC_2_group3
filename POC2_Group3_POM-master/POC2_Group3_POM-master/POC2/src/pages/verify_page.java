package pages;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verify_page {
	WebDriver dr;
	By xp=By.xpath("//*[@class='Row']/td/b");
	By xp1=By.xpath("//*[@class='Row']/td[2]");
	By xp2=By.xpath("/html/body/table[5]/tbody/tr/td");

	ArrayList<WebElement> arr=new ArrayList();
	ArrayList<WebElement> arr1=new ArrayList();
	ArrayList<String> arr2=new ArrayList();
	ArrayList<String> arr3=new ArrayList();
	ArrayList<String> arr4=new ArrayList();
	ArrayList<String> arr5=new ArrayList();
	Logger log;
	read_write rw;
	public verify_page(WebDriver dr)
	{
		this.dr=dr;
	}

	public String verify_search_product()
	{
		String x1=dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/form/table[1]/tbody/tr/th")).getText();
		return x1;
	}
	public String verify_catagory()
	{
		String x1=dr.findElement(By.xpath("/html/body/table[5]/tbody/tr/td[1]/table[1]/tbody/tr/th")).getText();
		return x1;
	}
	public String verify_no_of_product()
	{			
		String s6=dr.findElement(xp2).getText();
		int a=s6.indexOf(":");
		int b=s6.indexOf(".");
		String s7=s6.substring(a+2, b);
		//System.out.println(s7);
		String s8="";
		for(int i=0;i<s7.length();i++)
		{
			if(Character.isDigit(s7.charAt(i)))
			{
				s8=s8+s7.charAt(i);
			}
		}
		return s8;
	}
	public ArrayList<String> verify_product()
	{
		arr=((ArrayList<WebElement>)dr.findElements(xp));// gets the book name
		for(WebElement we:arr)
		{
			arr3.add(we.getText());
		}
		return arr3;
	}
	public ArrayList<String> verify_price()
	{
		arr1=((ArrayList<WebElement>)dr.findElements(xp1));// gets the book and price together
		for(WebElement s1:arr1)
		{
			int index=s1.getText().indexOf('$');
			arr2.add(s1.getText().substring(index+1));// gets the price 
		}	
		return arr2;	
	}
	public ArrayList<String> get_product()
	{
		rw=new read_write();
		
		for(int k=1;k<=5;k++)
		{
			String s=rw.read(k, 3, "D:\\POC2.xlsx");
			arr4.add(s);
		}
		return arr4;
	}
	public ArrayList<String> get_price()
	{
		rw=new read_write();
		for(int k=1	;k<6;k++)
		{
			String s=rw.read2(k, 4, "D:\\POC2.xlsx");
			arr5.add(s);
		}
		return arr5;
	}


	public void create_log(String meth_name, String enop, String anop, String result) {
		// TODO Auto-generated method stub
		log=Logger.getLogger("devpinoyLogger");
		if(result.compareTo("PASS")==0)
		{
			if(enop=="")
				log.info("Method "+ meth_name+" executed \n");
			else
				log.info("Method "+ meth_name+" executed \n"+"Expected Result: "+enop+"\n Actual Result: "+anop+"\n Test Result: "+result);

		}
		else {
			if(enop=="")
				log.info("Method "+ meth_name+"\n");
			else
				log.info("Method "+ meth_name+"\n"+"Expected Result: "+enop+"\n Actual Result: "+anop+"\n Test Result: "+result);
		}
	}


}
