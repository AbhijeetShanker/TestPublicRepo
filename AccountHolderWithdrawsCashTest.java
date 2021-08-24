package com.example;

import org.testng.annotations.*;

public class AccountHolderWithdrawsCashTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    public void accountHasSufficientFunds(String endingBalance, String amount) {
        // Tags: Priority:high
        // Given the account balance is "$100"
        actionwords.theAccountBalanceIsBalance("$100");
        // And the machine contains enough money
        actionwords.theMachineContainsEnoughMoney();
        // And the card is valid
        actionwords.theCardIsValid();
        // When the Account Holder requests "<amount>"
        actionwords.theAccountHolderRequestsAmount(amount);
        // Then the ATM should dispense "<amount>"
        actionwords.theATMShouldDispenseAmount(amount);
        // And the account balance should be "<ending_balance>"
        actionwords.theAccountBalanceShouldBeBalance(endingBalance);
        // And the card should be returned
        actionwords.theCardShouldBeReturned();
    }

    @Test
    public void accountHasSufficientFundsWithdraw100() {
        accountHasSufficientFunds("$0", "$100");
    }

    @Test
    public void accountHasSufficientFundsWithdraw50() {
        accountHasSufficientFunds("$50", "$50");
    }

    @Test
    public void accountHasSufficientFundsWithdraw20() {
        accountHasSufficientFunds("$80", "$20");
    }


    //
    // Tags: Priority:high
    @Test
    public void accountHasInsufficientFunds() {
        // Given the account balance is "$10"
        actionwords.theAccountBalanceIsBalance("$10");
        // And the card is valid
        actionwords.theCardIsValid();
        // And the machine contains enough money
        actionwords.theMachineContainsEnoughMoney();
        // When the Account Holder requests "$20"
        actionwords.theAccountHolderRequestsAmount("$20");
        // Then the ATM should not dispense any money
        actionwords.theATMShouldNotDispenseAnyMoney();
        // And the ATM should say there are insufficient funds
        actionwords.theATMShouldSayThereAreInsufficientFunds();
    }
    //
    // Tags: Priority:high
    @Test
    public void cardHasBeenDisabled() {
        // Given the card is disabled
        actionwords.theCardIsDisabled();
        // When the Account Holder requests "$10"
        actionwords.theAccountHolderRequestsAmount("$10");
        // Then the ATM should retain the card
        actionwords.theATMShouldRetainTheCard();
        // And the ATM should say the card has been retained
        actionwords.theATMShouldSayTheCardHasBeenRetained();
    }
}