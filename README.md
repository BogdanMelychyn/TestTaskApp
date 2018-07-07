### Personal expenses management console application that allows users to track how much money have they spent.

**supported commands:**

**`add 2017-04-25 12 USD Jogurt`** - adds expense entry to the list of user expenses.Expenses for various dates could be added in
any order. Command accepts following parameters:

**_2017-04-25_** - date of expense

**_12_** - amount of money spent

**_USD_** - the currency in which expense occurred (Use only ISO 4217 Currency Codes)

**_Jogurt_** - name of product purchased

**`list`** - shows the list of all expenses sorted by date

**`clear 2017-04-25`** - removes all expenses for specified date, where:

**_2017-04-25_** - date for which all expenses should be removed

**`total PLN`** - calculates the total amount of money spent and presents it to user in specified currency, where:

**_PLN_** - is the currency in which total amount of expenses should be presented

**`exit`** - serialization and exit from application


### Used build tool - Apache Maven

## To run the program, after cloning or downloading, go to the **TestTaskApp/target/** and use the command **`java -jar TestTaskApp-0.0.1-SNAPSHOT.jar`** in command promt 