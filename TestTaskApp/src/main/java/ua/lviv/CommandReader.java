package ua.lviv;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class CommandReader {
private static SerObject ser = new SerObject();
private ExpenseManager exp;
private Date date;
private Expense product;
private Scanner scn = new Scanner(System.in);

// read string from console
public void readCommand() {
	this.exp = (ExpenseManager)ser.deserData("data");
	if (this.exp == null) this.exp = new ExpenseManager();
	String str;
	while(scn.hasNextLine()) {
		str = scn.nextLine();
		runCommand(str.split(" "));
	}
} 

public void runCommand(String... arg) {
		try {
		switch (arg[0]) {
		case "add":{
			if (arg.length >= 5) {
				date =	ExpenseManager.DATE.parse(arg[1]);
				String name = String.join(" ", Arrays.copyOfRange(arg, 4, arg.length));
				product = new Expense(Double.parseDouble(arg[2]), arg[3].toUpperCase(), name);
				exp.addExpense(date, product);
				exp.printAllExpenses();
				}else throw new IllegalArgumentException();
			break;
		}
		case "list":{
			exp.printAllExpenses();
			break;
		}
		case "clear":{
			if (arg.length == 2){
			date =	ExpenseManager.DATE.parse(arg[1]);
			exp.clearDate(date);
			exp.printAllExpenses();
			}else throw new IllegalArgumentException();
			break;
		}
		case "total":{
			if (arg.length == 2){
				
				System.out.printf("\n%.2f %s\n", exp.amountOfCurrency(arg[1].toUpperCase()), arg[1].toUpperCase());
				
		}else throw new IllegalArgumentException();
			break;
		}
		case "exit":{
			ser.serData("data", this.exp);
			System.exit(0);
		}
		default: {
			System.out.println("Incorrect command"+ "\ntry again");
		}
	}
		}catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
			System.out.println("Incorrect command"+ "\ntry again");
				
		}catch (ParseException e){
			System.out.println("Incorrect Date: " + arg[1] + "\n try again");
		
        }catch (NumberFormatException e2){
			System.out.println("Incorrect amount of money: " + arg[2] + "\n"+ "try again");
			
		}catch (IllegalArgumentException e) {
			System.out.println("Incorrect command"+ "\ntry again");
		}

	}

}

