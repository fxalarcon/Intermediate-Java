package edu.gcccd.csis;
import java.io.*;
import java.math.BigInteger;
import org.junit.Test;

public class BasicListT {
//////////////////////////////io Testing  //////////////////////////////////////////////        ////
	@Test
	public void writehello() {
	 try {
	    	BufferedWriter out = new BufferedWriter(new FileWriter("hello.bin"));
	        out.write("Hello World");  //Replace with the string 
	        out.close(); 
	        //you are trying to write
	    }
	    catch (IOException e)
	    {
	        System.out.println("Exception ");

	    }
	}
	
	@Test
	public void readhello() {
		BufferedReader in;
    	String line="";
		try {
			in = new BufferedReader(new FileReader("hello.bin"));
			line= in.readLine();
			in.close();
		}
		catch (Exception e) {
			System.out.println("Cannot open file " + "hello.bin");
		}
		
		System.out.println("\n\n\n\nFile Store And Read Test+\n"+line);
	}
	
	///////////////////////////////////file io///////////////////////////////////////////////

	////////////////////////// Testing For Addition//////////////////////////////////////////////
	
	@Test
	public void addition() {
		String line1= "551239213912227";
		String line2= "123643534543132";
		long num1=Long.parseLong(line1);		
		long num2=Long.parseLong(line2);
		 NodeList<Integer> nodeList1 = new NodeList<>();
		 NodeList<Integer> nodeList2 = new NodeList<>();
		final NodeList<Integer> nodeList3 = new NodeList<>();
		final NodeList<Integer> nodeList4 = new NodeList<>();
		 for (int i = 0; i < line1.length(); i++) {
	            nodeList1.append(Integer.parseInt(Character.toString(line1.charAt(i))));
	        }
		 for (int i = 0; i < line1.length(); i++) {
	            nodeList2.append(Integer.parseInt(Character.toString(line2.charAt(i))));
	        }
		 
		 
		 Project2 p= new Project2();
		 System.out.println("String Addition: "+line1+" + "+line2+" = ");
		 nodeList4.add(nodeList1, nodeList2, nodeList3, nodeList4);
		 p.print(nodeList4);
		 System.out.println("Num1: "+num1+" Num2: "+num2+" = "+(num1+num2));
		 
		
		
	}
	


}
