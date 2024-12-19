package com.HRMscenario2pagefactorys.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdminPageTestPF extends BaseTest{
 
	@BeforeClass(alwaysRun=true)
	public void pageSetUp()
	{
		lp.verifyLogin("Admin","admin123");
	}
	@Test (priority=1)
  public void VerifyMenuCount() {
	 ap.VerifyMenuCount();
	  
  }
	@Test(priority=2)
	public void searchbyName() {
		ap.searchbyName();
	}
	
	@Test(priority=3)
	public void selectByuserRole()
	{
		ap.SelectByuserRole();
	}
	@Test(priority=4)
	public void SelectByuserStatus()
	{
		ap.selectBystatus();
	}

}
