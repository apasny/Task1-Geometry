package com.epam.data;

import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {

    @Test
    public void testValidateShouldValidateCorrectLine() {
        //given
        DataValidator dataValidator = new DataValidator(){};

        String correctLine = "1.0 2.0 3.0 4.0 5.0 6.0 7.0";

        //when
        boolean correctLineResult = dataValidator.validate(correctLine);

        //then
        Assert.assertTrue(correctLineResult);
    }
    @Test
    public void testValidateShouldValidateIncorrectLineWithNegativeRadius() {
        //given
        DataValidator dataValidator = new DataValidator(){};

        String incorrectLineWithNegativeRadius = "-1.0 2.0 3.0 4.0 5.0 6.0 7.0";

        //when
        boolean incorrectLineWithNegativeRadiusResult = dataValidator.validate(incorrectLineWithNegativeRadius);

        //then
        Assert.assertFalse(incorrectLineWithNegativeRadiusResult);
    }
    @Test
    public void testValidateShouldValidateIncorrectLineWithLackOfNumbers() {
        //given
        DataValidator dataValidator = new DataValidator(){};

        String incorrectLineWithLackOfNumbers = "1.0 2.0 4.0 5.0 6.0 7.0";

        //when
        boolean incorrectLineWithLackOfNumbersResult = dataValidator.validate(incorrectLineWithLackOfNumbers);

        //then
        Assert.assertFalse(incorrectLineWithLackOfNumbersResult);

    }
    @Test
    public void testValidateShouldValidateIncorrectLineWithLetter() {
        //given
        DataValidator dataValidator = new DataValidator(){};

        String incorrectLineWithLetter = "1.0 2.0 4.0z 5.0 6.0 7.0";

        //when
        boolean incorrectLineWithLetterResult = dataValidator.validate(incorrectLineWithLetter);

        //then
        Assert.assertFalse(incorrectLineWithLetterResult);

    }
    @Test
    public void testValidateShouldValidateIncorrectLineWithWrongNumbersFormat() {
        //given
        DataValidator dataValidator = new DataValidator(){};
        String incorrectLineWithWrongNumbersFormat = "1 2.0 4.0 5.0 6.0 7.0";

        //when
        boolean incorrectLineWithWrongNumbersFormatResult = dataValidator.validate(incorrectLineWithWrongNumbersFormat);

        //then
        Assert.assertFalse(incorrectLineWithWrongNumbersFormatResult);

    }

}
