package ua.lviv;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Expense implements Serializable{
	
	private double cost;
	private String currency;
	private String name;
 
public Expense() {}

public Expense(double cost, String currency, String name) {
	
	this.cost = cost;
	this.currency = currency;
	this.name = name;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getCost() {
	return cost;
}

public void setCost(double cost) {
	this.cost = cost;
}

public String getCurrency() {
	return currency;
}

public void setCurrency(String currency) {
	this.currency = currency;
}

@Override
public String toString() {
	return name + " " + String.format("%.2f", cost) + " " + currency;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	long temp;
	temp = Double.doubleToLongBits(cost);
	result = prime * result + (int) (temp ^ (temp >>> 32));
	result = prime * result + ((currency == null) ? 0 : currency.hashCode());
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Expense other = (Expense) obj;
	if (Double.doubleToLongBits(cost) != Double.doubleToLongBits(other.cost))
		return false;
	if (currency == null) {
		if (other.currency != null)
			return false;
	} else if (!currency.equals(other.currency))
		return false;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	return true;
}

}
