import java.time.LocalDateTime;

/**
 * This class represents a transaction with a payer, point value, and timestamp.
 * 
 * @author Victor Nguyen
 */
public class Transaction {

    private String payer;
    private int points;
    private LocalDateTime date;

    /**
     * Constructs a new Transaction object with the given payer, 
     * point value, and date.
     * @param payer the payer associated with this transaction
     * @param points the number of points associated with this transaction
     * @param date the date associated with this transaction
     */
    public Transaction(String payer, int points, LocalDateTime date) {
        this.payer = payer;
        this.points = points;
        this.date = date;
    }

    /**
     * Returns the payer associated with the transaction.
     * @return the name of the payer assocated with this transaction.
     */
    public String getPayer() {
        return this.payer;
    }

    /**
     * Returns the points of this transaction.
     * @return the points of this transaction.
     */
    public int getPoints() {
        return this.points;
    }

    /**
     * Returns the date this transaction.
     * @return the date of the transaction.
     */
    public LocalDateTime getDate() {
        return this.date;
    }
    
}
