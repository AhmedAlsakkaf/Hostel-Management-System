import java.sql.Date;

public class Payment {
    private int amount;
    private int bankId;
    private Date paymentDate;

    public Payment(int amount, int bankId, Date paymentDate) {
        this.amount = amount;
        this.bankId = bankId;
        this.paymentDate = paymentDate;
    }

    public void addPayment(int amount) {
        this.amount += amount;
        System.out.println("Payment of " + amount + " added successfully.");
    }

    public void editPayment(int bankId) {
        this.bankId = bankId;
        System.out.println("Payment with Bank ID " + bankId + " has been updated.");
    }

    public void searchPayment(int bankId) {
        if (this.bankId == bankId) {
            System.out.println("Payment with Bank ID " + bankId + " found:");
            System.out.println("Amount: " + amount);
            System.out.println("Payment Date: " + paymentDate);
        } else {
            System.out.println("Payment with Bank ID " + bankId + " not found.");
        }
    }

    public void deletePayment() {
        amount = 0;
        bankId = 0;
        paymentDate = null;
        System.out.println("Payment deleted successfully.");
    }
}
