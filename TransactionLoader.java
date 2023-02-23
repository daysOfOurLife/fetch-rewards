import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class is responsible for loading transaction data from a CSV file, parsing it,
 * and creating Transaction objects. 
 * 
 * @author Victor Nguyen
 */
public class TransactionLoader {

    /**
     * Loads transaction data from a CSV file and returns an ArrayList of transaction objects.
     *
     * @param filePathToCSV the path to CSV file to load
     * @return an ArrayList of Transaction objects created from CSV file
     * @throws FileNotFoundException if the given file cannot be found
     */
    public ArrayList<Transaction> loadTransactions(String filePathToCSV) throws FileNotFoundException {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        File csvFile = new File(filePathToCSV);
        Scanner scnr = new Scanner(csvFile);

        scnr.nextLine(); // Skip column headers
        while (scnr.hasNextLine()) {
            String row = scnr.nextLine();
            String[] components = row.split(",");

            // Retrieve transaction information
            String payer = components[0].replaceAll("\n", "");
            int points = Integer.parseInt(components[1]);
            LocalDateTime timestamp;

            // Parse date string into a LocalDateTime object
            String dateString = components[2].replaceAll("\"", "");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
            timestamp = LocalDateTime.parse(dateString, formatter);

            Transaction transaction = new Transaction(payer, points, timestamp);
            transactions.add(transaction);
        }

        scnr.close();

        return transactions;
    }
    
}
