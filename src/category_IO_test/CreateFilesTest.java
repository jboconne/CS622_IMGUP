package category_IO_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CreateFilesTest {
	
    @Test
	public void testMain() {
    	
    	String[] fileNamePrefix = new String[2];
        fileNamePrefix[0] ="top";
        fileNamePrefix[1] ="sub";
    	
		assertEquals(2,fileNamePrefix.length);
		assertEquals("top",fileNamePrefix[0]);
		assertEquals("sub",fileNamePrefix[1]);
	}

}
