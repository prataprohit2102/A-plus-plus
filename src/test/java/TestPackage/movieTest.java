package TestPackage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basePack.testbase;
import pages.addMoviePage;
import pages.homePage;

public class movieTest extends testbase {

	homePage home;

	addMoviePage addMovie;

	@BeforeTest

	public void setup() {

		launchbrowser();
		driver.get("https://autothon-nagarro-frontend-w08.azurewebsites.net/");
		home = new homePage(driver);
		addMovie = new addMoviePage(driver);

	}

	@Test(priority = 1, alwaysRun = true)

	public void adminLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(home.loginButton)).click();

		home.Login("admin", "password");

	}

	@Test(priority = 2, dependsOnMethods = "adminLogin")

	public void adminAddANewMovie() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(home.addMovieButton)).click();

		addMovie.titleTextBox.sendKeys("3 idiots");
		addMovie.directorTextBox.sendKeys("Kumar");
		addMovie.descriptionTextBox.sendKeys("A movie of 3 idiots");
		addMovie.selectMovie("Comedy");
		addMovie.urlTextBox.sendKeys("http://www.3idiots.com");
		addMovie.saveMovieButton.click();
	}

	@AfterTest(enabled = true)
	public void tearDown() {

		// driver.close();

	}

}
