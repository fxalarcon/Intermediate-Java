import java.util.Arrays;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test {
	
	public static void main(String args[]) {
	
//		SequenceSearchImpl obj = new SequenceSearchImpl("[[Lorem ipsum]] dolor sit amet, [[consectetur adipiscing elit]], sed do eiusmod tempor incididunt ut\r\n" + 
//		"labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in\r\n" + 
//		"voluptate velit esse cillum dolore eu fugiat nulla pariatur.", "[[", "]]");
//
//String ts[] = obj.getAllTaggedSequences();
//String lts = obj.getLongestTaggedSequence();
//System.out.println("Tagged Sequences:\n");
//System.out.println(Arrays.toString(ts));
//System.out.println();
//System.out.println("Longest Tagged Sequences:\n");
//System.out.println(lts);
//System.out.println();
//System.out.println("String Array:\n");
//System.out.println(obj.displayStringArray());
//System.out.println();
//System.out.println("Content paragraph:");
//System.out.println(obj.toString());
		
	Result result = JUnitCore.runClasses(SequenceSearchTest.class);
	
    for (Failure failure : result.getFailures()) {
       System.out.println(failure.toString());
    }
		
    System.out.println(result.wasSuccessful());
	
	}

}
