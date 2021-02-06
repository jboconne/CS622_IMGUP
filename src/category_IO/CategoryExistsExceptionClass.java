package category_IO;
// This is the User Defined Exception Class that gets called from the addTopLevelCat()
//  in the Category_IO_test.Menu.java class. This class extends and inherits from the 
//		Exception base class
//  Precondition 1 - takes in a string parameter as a message that is displayed to the 
//   whenever the exception is thrown
public class CategoryExistsExceptionClass extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CategoryExistsExceptionClass(String s) // Pre 1
    {
        // Call constructor of parent Exception
        super(s); //Pre 1
    }

}
