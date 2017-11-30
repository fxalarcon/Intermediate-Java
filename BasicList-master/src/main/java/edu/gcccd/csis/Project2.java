package edu.gcccd.csis;

import java.io.*;
import java.util.Iterator;
import java.util.Random;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;

/**
 * Use the starter code, including the NodeList class, our implementation of a BasicList.
 * <p>
 * We are going to use a very simple lists to store positive long numbers, one list element per digit.
 * The most significant digit is stored in the head element, the least significant digit is stored in the tail.
 * <p>
 * The starter code's main method creates very long numbers.
 * It is your task, to complete the class so that it can calculate the sum of positive very long numbers and
 * store the result in a file.
 * <p>
 * Of course, all methods need to have unit-tests to verify corner cases and happy-paths.
 * For that you may find the java.math.BigInteger class help-full when writing the unit-tests.
 * In the test code you are free to use java classes from all packages.
 * In the implementation of the Project2 class however, you are limited to
 * <p>
 * import java.io.*;
 * import java.util.Iterator;
 * import java.util.Random;
 * Moreover, you need to provide a detailed estimate for how often on average ANY iterator's next() method gets called
 * (depending on the value of L) when addition(Iterator&lt;NodeList&lt;Integer&gt;&gt; iterator) gets called.
 */
@SuppressWarnings("unused")
public class Project2 {

    static NodeList<Integer> generateNumber(final int maxLength) {
        final NodeList<Integer> nodeList = new NodeList<>();
        final int len = 1 + new Random().nextInt(maxLength);
        for (int i = 0; i < len; i++) {
            nodeList.append(new Random().nextInt(10));
        }
        System.out.print("Generated Number: ");
        print(nodeList);
       
        return nodeList;
    }

    /**
     * Prints a very long number to System.out
     *
     * @param nodeList NodeList<Integer>
     */
    static void print(final NodeList<Integer> nodeList) {
    	
    	for (final Integer i : nodeList) {
            System.out.print(i);
        }
       
        System.out.println();
        
        
    }
    


    public static void main(final String[] args) {
        final int L = 30; //30

        final NodeList<Integer> n1 = generateNumber(L); // (head 1st) e.g. 3457
        final NodeList<Integer> n2 = generateNumber(L); // (head 1st) e.g. 682

        final Project2 project = new Project2();
        System.out.println("Sum =");
        print(project.addition(n1, n2)); //  n1+n2, e.g. 4139
     
        System.out.println("\n**********************************************"
        		         + "\n**********************************************"
        		         + "\n**********************************************"
        		         + "\n**********************************************"
        		         + "\n**********************************************"
        		         + "\n********* ************************************"
        		         + "\n**********************************************");
        final NodeList<NodeList<Integer>> listOfLists = new NodeList<>();
        
        for (int i = 0; i < L; i++) {
            listOfLists.append(generateNumber(L));
         
        }
     
       
     
      
        
        project.save(project.addition(listOfLists.iterator()), "result.bin");
        System.out.print("The Sum of All Numbers = ");
        print(project.load("result.bin"));
    }

    /**
     * Add two very long numbers
     *
     * @param nodeList1 NodeList&lt;Integer&gt;
     * @param nodeList2 NodeList&lt;Integer&gt;
     * @return nodeList representing the sum (add) of nodeList1 and nodeList2, without leading '0'
     */
    
    
    public NodeList<Integer> addition(NodeList<Integer> nodeList1, NodeList<Integer> nodeList2) {
    	final NodeList<Integer> n3= new NodeList<Integer>();
    	final NodeList<Integer> n4= new NodeList<Integer>();
    	
    	 n4.add(nodeList1, nodeList2, n3, n4);
    	
    	
    	
        return n4;
    }

    /**
     * Add very long numbers
     *
     * @param iterator NodeList&lt;Integer&gt;
     * @return nodeList representing the sum (add) of all very long numbers, without leading '0'
     */
    public NodeList<Integer> addition(Iterator<NodeList<Integer>> iterator) {
    	
    	NodeList<Integer> sum = new NodeList<Integer>();
    	sum.append(0);
    	NodeList<Integer> x = new NodeList<Integer>();
    	long analysis=0;
    	int count=0;
    	while(iterator.hasNext()) {
           count++;
    		x=iterator.next();
    	    sum = addition(sum,x);
    	    analysis+=sum.getanalysis()+x.getanalysis();
    	}
    	/////////////////Analysis//////////////
      analysis= analysis/count;
      System.out.println("On Average Method next() has been called, when this (Iterator<NodeList<Integer>> iterator) is called "+ analysis);
    	
    	
    	
        return sum;
    }

    /**
     * Saves a very large number as a file
     *
     * @param nodeList NodeList&lt;Integer&gt;
     * @param fileName String
     */
    public void save(NodeList<Integer> nodeList, String fileName) { 
    	String output="";
    	for (final Integer i : nodeList) {
            output+=i;
        }
    	
    try {
    	BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
        out.write(output);  //Replace with the string 
        out.close();                                         //you are trying to write
    }
    catch (IOException e)
    {
        System.out.println("Exception ");

    }
   
       
    
    
    }
    
    
    /**
     * Loads a very large number from a file
     *
     * @param fileName String
     * @return NodeList&lt;Integer&gt;
     */
    public NodeList<Integer> load(final String fileName) {
    	NodeList<Integer> nodeList = new NodeList<Integer>();
    	BufferedReader in;
    	String line="";
		///////
    	try {
			in = new BufferedReader(new FileReader(fileName));
			line= in.readLine();
			in.close();
		}
		catch (Exception e) {
			System.out.println("Cannot open file " + fileName);
		}
		
        /////////////////////////////
        for (int i = 0; i < line.length(); i++) {
            nodeList.append(Integer.parseInt(Character.toString(line.charAt(i))));
        }
        return nodeList;
		
        
    }
}