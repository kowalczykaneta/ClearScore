package clearscore.step_defs;

import clearscore.browser.Browser;
import clearscore.pom.ClearScore_savings_calculator;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

import java.util.List;

public class SavingsCalculator_step_defs {

    @Given("^user opens savings calculator$")
    public void user_opens_savings_calculator () throws Throwable {
        ClearScore_savings_calculator.savings_calculator_loads();

    }

    @Given("^user set current score to (\\d+)  and score goal to (\\d+)$")
    public void user_set_current_score_to_and_score_goal_to (String toSelectCurrentScore, String
            toSelectScoreGoal) throws Throwable {

        JavascriptExecutor jse = (JavascriptExecutor) Browser.driver();
        jse.executeScript("window.scrollBy(0,350)", "");

        WebElement currentScore = Browser.driver().findElement(By.cssSelector(".js-range-current-val"));
        System.out.println(currentScore.getText());

        List<WebElement> sliders = Browser.driver().findElements(By.className("cs-scalc__range-slider__bg--gradient"));
        WebElement slider1 = sliders.get(0);
        WebElement slider2 = sliders.get(1);

        new Actions(Browser.driver())
                .moveToElement(slider1, 0, 0)
                .click()
                .perform();

        while (!currentScore.getText().equals(toSelectCurrentScore)) {
            new Actions(Browser.driver())
                    .clickAndHold()
                    .moveByOffset(1, 0)
                    .perform();
        }

        WebElement scoreGoalV = Browser.driver().findElement(By.cssSelector(".js-range-goal-val"));

        new Actions(Browser.driver())
                .moveToElement(slider2, 0, 0)
                .click()
                .perform();

        while (!scoreGoalV.getText().equals(toSelectScoreGoal)) {
            new Actions(Browser.driver())
                    .clickAndHold()
                    .moveByOffset(1, 0)
                    .perform();
        }
    }

    @Then("^user sees updated current score interested rate to (.*%)$")
    public void user_sees_updated_current_score_interested_rate_to (String currentScoreInterestRateExpected) throws Throwable {

        WebElement currentScoreInterestRate = Browser.driver().findElement(By.cssSelector(".js-current-average-rate"));
        String currentScoreInterestRateValue = currentScoreInterestRate.getText();
        boolean currentScoreInterestRateValueIsCorrect = currentScoreInterestRateValue.equals(currentScoreInterestRateExpected);
        assertTrue("Current score interest rate is incorrect", currentScoreInterestRateValueIsCorrect);
    }

    @Then("^score costs to (.*)$")
    public void score_costs_to_£ (String scoreCostExpected) throws Throwable {
        WebElement currentScoreCosts = Browser.driver().findElement(By.cssSelector(".js-current-annual-cost"));
        String currentScoreCostsValue = currentScoreCosts.getText().substring(1);
        assertEquals("Current score costs are incorrect", scoreCostExpected, currentScoreCostsValue);
    }

    @Then("^current cards available to (.*)$")
    public void current_cards_available_to (String cardsAvailableExpected) throws Throwable {

        WebElement cardsAvailable = Browser.driver().findElement(By.cssSelector(".js-current-cc-available"));
        String cardsAvailableValue = cardsAvailable.getText();
        boolean cardsAvailableAreCorrect = cardsAvailableValue.equals(cardsAvailableExpected);
        assertTrue("Cards available are incorrect", cardsAvailableAreCorrect);
    }

    @Then("^user sees updated score goal interest rate to (.*%)$")
    public void user_sees_updated_score_goal_interest_rate_to (String scoreGoalInterestRateExpected) throws Throwable {
        WebElement scoreGoalInterestRate = Browser.driver().findElement(By.cssSelector(".js-goal-average-rate"));
        String scoreGoalInterestRateValue = scoreGoalInterestRate.getText();

        assertEquals("Score goal interest rate is incorrect", scoreGoalInterestRateExpected, scoreGoalInterestRateValue);
    }

    @Then("^goal costs to (.*)$")
    public void goal_costs_to (String goalCostsExpected) throws Throwable {
        WebElement goalCosts = Browser.driver().findElement(By.cssSelector(".js-goal-annual-cost"));
        String goalCostsValue = goalCosts.getText().substring(0);

        assertEquals("Goal costs are incorrect", goalCostsExpected, goalCostsValue);
    }

    @Then("^goal cards available to (\\d+)$")
    public void goal_cards_available_to (String goalCardsExpected) throws Throwable {
        WebElement goalCards = Browser.driver().findElement(By.cssSelector(".js-goal-cc-available"));
        String goalCardsValue = goalCards.getText();

        assertEquals("Goal cards are incorrect", goalCardsExpected, goalCardsValue);
    }

    @Then("^user see updated potential savings to (.*)$")
    public void user_see_updated_potential_savings_to_ (String potentialSavingsExpected) throws Throwable {
        Thread.sleep(1000);

        WebElement potentialSavings = Browser.driver().findElement(By.cssSelector(".js-total-saving-value"));
        String potentialSavingsValue = potentialSavings.getText();
        assertEquals("Potential savings are incorrect", potentialSavingsExpected, potentialSavingsValue);
    }

}


