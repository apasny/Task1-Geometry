package com.epam.datavalidator;

import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {

    @Test
    public void testValidateShouldValidateInputString() {
        //given
        DataValidator dataValidator = new DataValidator(){};

        String correctLine = "1.0 2.0 3.0 4.0 5.0 6.0 7.0";
        String incorrectLineWithNegativeRadius = "-1.0 2.0 3.0 4.0 5.0 6.0 7.0";
        String incorrectLineWithLackOfNumbers = "1.0 2.0 4.0 5.0 6.0 7.0";
        String incorrectLineWithLetter = "1.0 2.0 4.0z 5.0 6.0 7.0";
        String incorrectLineWithWrongNumbersFormat = "1 2.0 4.0 5.0 6.0 7.0";

        //when
        boolean correctLineResult = dataValidator.validate(correctLine);
        boolean incorrectLineWithNegativeRadiusResult = dataValidator.validate(incorrectLineWithNegativeRadius);
        boolean incorrectLineWithLackOfNumbersResult = dataValidator.validate(incorrectLineWithLackOfNumbers);
        boolean incorrectLineWithLetterResult = dataValidator.validate(incorrectLineWithLetter);
        boolean incorrectLineWithWrongNumbersFormatResult = dataValidator.validate(incorrectLineWithWrongNumbersFormat);

        //then
        Assert.assertTrue(correctLineResult);
        Assert.assertFalse(incorrectLineWithNegativeRadiusResult);
        Assert.assertFalse(incorrectLineWithLackOfNumbersResult);
        Assert.assertFalse(incorrectLineWithLetterResult);
        Assert.assertFalse(incorrectLineWithWrongNumbersFormatResult);

    }

}
