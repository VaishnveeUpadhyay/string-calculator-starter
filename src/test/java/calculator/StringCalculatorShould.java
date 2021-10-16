package test.java.calculator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.Test;

import main.java.calculator.*;
class StringCalculatorShould {
	
	private static StringCalculator stringCalculator = new StringCalculator();
    @Test
    void empty_string_should_return_0() {
               assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void string_with_single_number_should_return_number_as_int() {
        
        assertEquals(1, stringCalculator.add("1"));
    }
   
       //testing if method works for two 1-digit numbers
       @Test
       void string_with_two_numbers_should_return_sum() {
       	assertEquals(25, stringCalculator.add("10,15"));
       }
       
       //testing if method works for two 2-digit numbers
       @Test
       void string_with_two_digit_numbers_should_return_sum() {
       	assertEquals(22,stringCalculator.add("10,12"));
       }
       
       //testing if method works for unknown amount of digits
       @Test
       void string_with_any_amount_of_digits() {
       	assertEquals(191,stringCalculator.add("1,10,30,50,100"));
       }
       
       //testing if method supports \n as new delimiter
       @Test
       void string_with_new_line_as_delimiter() {
       	assertEquals(25, stringCalculator.add("10\n15"));
       }
       
       //testing if method supports both \n and , as delimiter
       @Test
       void string_with_new_line_and_comma_as_delimiter() {
       	assertEquals(120, stringCalculator.add("40,40\n40"));
       }
       
       //testing if method supports a different delimiter
       @Test
       void string_with_different_delimiters() {
       	assertEquals(130,stringCalculator.add("//;\n50;80"));
       }
       
       //testing if method supports a different delimiter
       @Test
       void string_with_different_delimiters_2() {
       	assertEquals(110,stringCalculator.add("//.\n10.100"));
       }
       
       //testing on negative values
       @Test
       void string_with_negative_integers() {
       	try {
       		stringCalculator.add("-5,40,70");
       		fail("Exception expected");
       	}catch(RuntimeException re){
       		
       	}
       }
       
       @Test
       void string_with_negative_integers_and_giving_values() {
       	try {
       		stringCalculator.add("-1,12,13");
       		fail("Exception expected");
       	}catch(RuntimeException re){
       		assertEquals("Negatives not allowed!! [-1]", re.getMessage());
       	}
       }
       
       @Test
       void string_with_negative_integers_and_giving_values_multiple() {
       	try {
       		stringCalculator.add("-6,-12,18");
       		fail("Exception expected");
       	}catch(RuntimeException re){
       		assertEquals("Negatives not allowed!! [-6, -12]", re.getMessage());
       	}
       }       
}
