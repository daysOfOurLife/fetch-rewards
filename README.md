# fetch-rewards
Fetch Backend Take Home Test Submission for Victor Nguyen

Getting Started:
To begin using the code in this repository, you will need to have Java and a Java IDE (such as Eclipse or IntelliJ IDEA) installed on your computer. Once you have these tools installed, you can clone the repository to your local machine using the following command:

git clone https://github.com/daysOfOurLife/fetch-rewards.git

Compiling and Running the Code:
To compile and run the code, navigate to the repository folder on your local machine and run the following command:

make 

This command compiles the code and runs the main program, which will read the transactions from transactions.csv, spend the 5000 points, and return payer point balances. 

Alternatively, you can manually compile and run the code using the following commands:

To compile the code:
javac Main.java Transaction.java TransactionLoader.java TransactionComparator.java

To run the code:
java Main [points_to_spend] [CSV_file_name]

For example, if you want to spend 10000 points and use a CSV file containing different transactions, you can run the following command:

java Main 10000 [CSV_file_name]
