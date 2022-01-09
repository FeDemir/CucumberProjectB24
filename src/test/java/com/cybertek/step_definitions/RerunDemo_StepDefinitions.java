package com.cybertek.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class RerunDemo_StepDefinitions {
    @Given("User adds two numbers")
    public void user_adds_two_numbers() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User adds two numbers");
    }
    @Then("result should be as expected")
    public void result_should_be_as_expected() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("result should be as expected");
    }

    @Given("User adds three numbers")
    public void user_adds_three_numbers() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User adds three numbers");
    }
    @Then("result should be sum of the three numbers")
    public void result_should_be_sum_of_the_three_numbers() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("result should be sum of the three numbers");
        Assert.assertEquals(5,10);//intentionally failing
    }
    @Given("User divides two numbers")
    public void user_divides_two_numbers() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User divides two numbers");
    }
    @Then("result should be division result")
    public void result_should_be_division_result() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("result should be division result");
    }

    @Given("User multiplies two numbers")
    public void user_multiplies_two_numbers() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User multiplies two numbers");
    }
    @Then("result should be multiplication result")
    public void result_should_be_multiplication_result() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("result should be multiplication result");
        Assert.assertEquals(2*2,5);
    }

}
