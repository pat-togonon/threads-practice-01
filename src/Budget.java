import java.math.BigDecimal;

public class Budget {
    private BigDecimal totalMoney = new BigDecimal("50000");
    private BigDecimal totalExpenses = new BigDecimal(0);
    private StringBuilder payables = new StringBuilder();

    public Budget() {

    }

    public synchronized boolean sendPayment(BigDecimal amount, String payable) {
        if (amount.signum() < 0) {
            System.out.println("Cannot pay a negative amount.");
            return false;
        }

        if (this.totalMoney.subtract(amount).signum() < 0) {
            System.out.println("Insufficient fund to pay for " + payable);
            return false;
        }

        System.out.println("Payment for " + payable + " with an amount Php " + amount + " is successful.");
        this.payables.append(payable).append(", ");

        this.totalMoney = this.totalMoney.subtract(amount);
        this.totalExpenses = this.totalExpenses.add(amount);
        return true;
    }

    public synchronized BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public synchronized void addMoneyToFund(BigDecimal amount) {
        if (amount.signum() < 0) {
            System.out.println("Cannot add a negative amount.");
            return;
        }

        this.totalMoney = totalMoney.add(amount);
    }

    public synchronized BigDecimal getTotalExpenses() {
        return totalExpenses;
    }

    public synchronized String getPayables() {
        return this.payables.toString();
    }

}
