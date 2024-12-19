package com.HRMscenario2pagefactorys.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class LoginPageTestPF extends BaseTest
{
  @Test(priority=1)
  public void verifyTitle() {
	 // lp.verifyTitle();
	  lp.verifyTitle();
	  
  }
  
  @Test(priority=2)
  public void verifyLoginTest()
  {
	  lp.verifyLogin("Admin","admin123");

}
}