package com.patika.kredinbizdenservice.factory;

import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.HouseLoan;
import com.patika.kredinbizdenservice.model.VechileLoan;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.enums.LoanType;

public class LoanFactory {

    public static Loan getLoan(LoanType type) {
        switch (type) {
            case IHTIYAC_KREDISI:
                return new ConsumerLoan(amount, installment, interestRate);
            case KONUT_KREDISI:
                return new HouseLoan(amount, installment, interestRate);
            case ARAC_KREDISI:
                return new VehicleLoan(amount, installment, interestRate);
            default:
                throw new IllegalArgumentException("Geçerli bir Tip Değil");
        }
    }
}