package ua.lviv;


import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class CommandReaderTest {
	private static CommandReader cr = new CommandReader();
	
	@Before
	public void init() {
		System.out.println("test Incorrect commands: ");
	}
	@AfterClass
	public static void after() {
		cr = null;
	}
	@Test
    public void icorrectCommands() {
	String s = null;
	String s2 = "add 25 usd";
	String s3 = "clean 20";
	System.out.println(s + "\n" + s2 + "\n" + s3);
	
	cr.runCommand(s);
    cr.runCommand(s2.split(" "));
    cr.runCommand(s3.split(" "));
    
   
    }
	@Test
	  public void wrongStringToDouble() {
		String s ="add 2015-02-02 21df USD Product";
		System.out.println(s);
	    cr.runCommand(s.split(" "));
	    
	  }
	@Test
	  public void wrongStringToDate() {
		String s = "add 2015-d02-02 20 USD Product";
		String s2 = "clear asd2015-02";
		System.out.println(s + "\n" + s2);
	    cr.runCommand(s.split(" "));
	    cr.runCommand(s2.split(" "));
	  }
	
}
