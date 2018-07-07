package ua.lviv;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("serial")
public class ExpenseManager implements Serializable{
	public static final SimpleDateFormat DATE = new SimpleDateFormat("yyyy-MM-dd");
	private Map<Date, List<Expense>> map = new TreeMap<Date, List<Expense>>();
		
	public ExpenseManager() {
	}

	public Map<Date, List<Expense>> getMap() {
		return map;
	}

	public void setMap(Map<Date, List<Expense>> map) {
		this.map = map;
	}
	
// adding date and expense to the Map 
public void addExpense(Date date, Expense p) {
		
	if (!map.containsKey(date)) {
		List<Expense> list = new ArrayList<Expense>();
		list.add(p);
		map.put(date, list);
	} else {
		List<Expense> currentList = map.get(date);
		currentList.add(p);
		map.put(date, currentList);
	}
}

//  removing all expenses for specified date
public void clearDate(Date date) throws ParseException {
	map.remove(date);
}

//calculating the total amount of money in specified currency
public double amountOfCurrency(String currency)throws JSONException{
	double eur = 0, rate = 0;
	String str;
	JSONObject exchangeRates = CurrencyRates.sendRequest();
	if (exchangeRates.has(currency)) {
	for(Map.Entry<Date, List<Expense>> entry : map.entrySet()) {
		for (Expense p: entry.getValue()) {
			str = p.getCurrency();
			if (exchangeRates.has(str)) {
			rate = exchangeRates.getDouble(str);
			eur += p.getCost()/rate;
			}else System.out.printf("Unknown currency: %s %.2f will not be counted\n", str, p.getCost());
			}
		}
	}else {System.out.println("Unknown currency: " + currency + "\ntry again");
	
	return eur;
	
	}
	if (currency.equals("EUR")) 
		return eur;
	
	return eur*exchangeRates.getDouble(currency);
}

 //displaying the list of all expenses sorted by date
public void printAllExpenses() {
	System.out.println();
	for(Map.Entry<Date, List<Expense>> entry : map.entrySet()) {
		System.out.println(DATE.format(entry.getKey()));
		List<Expense> list = entry.getValue();
		list.forEach(p -> System.out.println(p));
		System.out.println();	
	}
		
}
}
