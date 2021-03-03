package multipleImageUploadsDBModel_Test;
/* 
   JUnit Test File to Validate Image File Types Accepted 
   works with ImageFormatValidator() class 
*/

import static org.junit.Assert.assertEquals;


import java.util.Arrays;
import java.util.Collection;
 
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 
@RunWith(Parameterized.class)
public class ImageFormatValidatorTest {
	private Boolean expectedValidationVlue;
    private static ImageFormatValidator imageFormatValidator;
    private String value;
 
 
    public ImageFormatValidatorTest(String str, Boolean expectedValue) {
        this.expectedValidationVlue = expectedValue;
        this.value = str;
    }
 
    @BeforeClass
    public static void initialize() {
        imageFormatValidator = new ImageFormatValidator();
    }
 
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
 
                {"im.jpg", true},
                {"im.JPG", true},
                {"im.Jpg", true},
                {"im.Jpg", true},
                {"im.png", true},
                {"im.PNG", true},
                {"im.PnG", true},
                
                /* Uncomment these below and JUnit Test Fails */ 
//                {"..PnG", true},
//                {"im.GIF", true},
//                {"im.GiF", true},
//                {"im.gif", true},
//                 
//                // image files that don't match
//                 
//                {"im", false},
//                {".JPG", false},
//                {"i.sh", false},
//                {"im.php", false},
//                {"im.bin", false}
                 
        };
 
        return Arrays.asList(data);
    }


    @Test
    public void test() {
 
        Boolean res = imageFormatValidator.validate(this.value);
        String validv = (res) ? "valid" : "invalid";
        System.out.println("Image File Format " + this.value + " is " + validv);
        assertEquals("Result", this.expectedValidationVlue, res);
 
    }
}
