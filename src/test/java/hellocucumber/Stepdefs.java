package hellocucumber;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

	private String today;
	private String actualAnswer;

	@Given("^today is Sunday$")
	public void today_is_Sunday() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		today = "Sunday";

	}

	@When("^I ask whether it's Friday yet$")
	public void i_ask_whether_it_s_Friday_yet() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
		actualAnswer = IsItFriday.isItFriday(today);
	}

	@Then("^I should be told \"([^\"]*)\"$")
	public void i_should_be_told(String expectedAnswer) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		/// throw new PendingException();
		assertEquals(expectedAnswer, actualAnswer);
	}

	@Given("^today is Friday$")
	public void today_is_Friday() {
		this.today = "Friday";
	}

}

class IsItFriday {
	static String isItFriday(String today) {
		if (today.equals("Friday")) {
			return "TGIF";
		}
		return "Nope";
	}
}