package ua.lviv;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) throws IOException {
		
		new CommandReader().readCommand();
		CurrencyRates.stream.close();
	}

}
