import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.io.FileNotFoundException;

/**
 * The Main class is the entry point for the rewards point system program. It loads
 * transactions from a CSV file  and calculates the point balances for each payer 
 * after a specified amount of points are to be spent.
 * 
 * The main method takes in 2 command-line arguments:
 * 1. the number of points to spend
 * 2. the CSV file name
 * 
 * Ex. java (points to spend) (CSV filename)
 * 
 * This class uses the following classes:
 * - Transaction
 * - TransactionLoader
 * - TransactionComparator
 * 
 * @author Victor Nguyen
 */
public class Main {
    public static void main(String[] args) {
        TransactionLoader transactionLoader = new TransactionLoader();
        HashMap<String, Integer> balances = new HashMap<String, Integer>();
        PriorityQueue<Transaction> datePQ;
        ArrayList<Transaction> transactions;
        int pointsToSpend;
        int accountTotal = 0;

        // Check for correct number of command-line arguments
        if (args.length != 2) {
            throw new IllegalArgumentException("Invalid number of command-line arguments (" + args.length + ").");
        } 

        try {
            pointsToSpend = Integer.parseInt(args[0]);
            transactions = transactionLoader.loadTransactions(args[1]);
            datePQ = new PriorityQueue<>(new TransactionComparator());
            
            //
            for (Transaction t : transactions) {
                String payer = t.getPayer();
                int transactionPoints = t.getPoints();
                
                // Update balances for each payer & account total
                balances.put(payer, balances.getOrDefault(payer, 0) + transactionPoints);
                accountTotal += transactionPoints;
    
                // Add transactions into a priority queue sorted by oldest to newest date
                datePQ.add(t);
            }
    
            // If account total is less than points to spend, continue. Otherwise, thrown an exception.
            if (accountTotal < pointsToSpend) {
                throw new IllegalArgumentException("Account total is less than points to spend.");
            }
    
            // TODO: Write detailed comments
            while (pointsToSpend > 0) {
                Transaction t = datePQ.peek();
                String payer = t.getPayer();
                int pointsPerTransaction = t.getPoints();
    
                if (pointsToSpend - pointsPerTransaction < 0) {
                    balances.put(payer, balances.get(payer) - pointsToSpend);
                    pointsToSpend = 0;
                } else {
                    pointsToSpend -= pointsPerTransaction;
                    balances.put(payer, balances.get(payer) - pointsPerTransaction);
                }
                
                datePQ.remove(t);
            }
    
            // Print out balances after points are spent
            System.out.println(balances);

        } catch (FileNotFoundException fnfe) {
            System.out.printf("Error loading in transactions file.");
        } catch (IllegalArgumentException iae) {
            System.out.println(iae);
        } catch (Exception e) {
            System.out.println("Unexpected error has occurred.");
        }
        
    }
}
