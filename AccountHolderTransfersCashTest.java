package com.example;

import org.testng.annotations.*;

public class AccountHolderTransfersCashTest {

    public Actionwords actionwords;

    @BeforeMethod
    public void setUp() {
        actionwords = new Actionwords();
    }
    //
    // Tags: Priority:medium
    @Test
    public void accountHasSufficientFundsForTransferringCash() {
        // Given the account balance is "$100"
        actionwords.theAccountBalanceIsBalance("$100");
        // And the savings account balance is "$1000"
        actionwords.theSavingsAccountBalanceIsAmount("$1000");
        // And the card is valid
        actionwords.theCardIsValid();
        // When the Account Holder transfers "$20" to the savings account
        actionwords.theAccountHolderTransfersAmountToTheSavingsAccount("$20");
        // And the ATM should dispense "$0"
        actionwords.theATMShouldDispenseAmount("$0");
        // And the account balance should be "$80"
        actionwords.theAccountBalanceShouldBeBalance("$80");
        // And the savings account balance should be "$1020"
        actionwords.theSavingsAccountBalanceShouldBeAmount("$1020");
        // And the card should be returned
        actionwords.theCardShouldBeReturned();
    }
}