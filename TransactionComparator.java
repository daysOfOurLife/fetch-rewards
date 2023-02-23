import java.util.Comparator;

/**
 * This class is a comparator that compares two Transaction objects based on 
 * their date and time values. 
 * 
 * Transactions with earlier timestamps will be considered "less than" transactions
 * with later dates.
 * 
 * @author Victor Nguyen
 */
public class TransactionComparator implements Comparator<Transaction> {
    
    /**
     * Compares two Transaction objects based on their date and time values.
     * @param t1 The first Transaction to compare
     * @param t2 The second Transaction to compare
     * @return a negative interger if t1's date is earlier than t2's, zero
     * if the dates are equal. Otherwise, return a positive integer.
     */
    @Override
    public int compare(Transaction t1, Transaction t2) {
        return t1.getDate().compareTo(t2.getDate());
    }
}
