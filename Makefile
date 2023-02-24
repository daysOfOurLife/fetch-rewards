run: Main.class
	java Main 5000 transactions.csv

Main.class: Main.java Transaction.class TransactionLoader.class TransactionComparator.class
	javac Main.java

Transaction.class: Transaction.java 
	javac Transaction.java

TransactionLoader.class: TransactionLoader.java 
	javac TransactionLoader.java

TransactionComparator.class: TransactionComparator.java
	javac TransactionComparator.java

clean:
	rm *.class
