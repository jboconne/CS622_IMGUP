package imageUpload_test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
 	ImageFormatValidator() class uses regular expression to match pattern of accepted image types
 	Gets called by ImageFormatValidatorTest() base test class  
*/

public class ImageFormatValidator{
  
   private Pattern pattern;
   private Matcher matcher;
  
   private static final String IMAGE_PATTERN = 
                "([^\\s]+(\\.(?i)(//bmp|jpg|png))$)";
  
   public ImageFormatValidator(){
      pattern = Pattern.compile(IMAGE_PATTERN);
   }
  
   public boolean validate(final String image){
  
      matcher = pattern.matcher(image);
      return matcher.matches();
  
   }
}
