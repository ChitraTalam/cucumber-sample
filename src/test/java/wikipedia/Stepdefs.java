package wikipedia;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

	private WebDriver driver;

	@Before
	public void before() {
		driver = new FirefoxDriver();
	}

	@After
	public void after() {
		driver.quit();
	}

	@Given("^Open http://en\\.wikipedia\\.org$")
	public void open_http_en_wikipedia_org() throws Exception {
		driver.navigate().to("http://en.wikipedia.org");
	}

	@Given("^Do login$")
	public void do_login() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Given("^Enter search term '(.*?)'$")
	public void searchFor(String searchTerm) {
		WebElement searchField = driver.findElement(By.id("searchInput"));
		searchField.sendKeys(searchTerm);
	}

	@When("^Do search$")
	public void clickSearchButton() {
		WebElement searchButton = driver.findElement(By.id("searchButton"));
		searchButton.click();
	}

	@Then("^Single result is shown for '(.*?)'$")
	public void assertSingleResult(String searchResult) {
		WebElement results = driver.findElement(By.cssSelector("div#mw-content-text.mw-content-ltr p"));
		assertFalse(results.getText().contains(searchResult + " may refer to:"));
		assertTrue(results.getText().startsWith(searchResult));
	}

}