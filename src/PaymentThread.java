import java.math.BigDecimal;

public class PaymentThread extends Thread {
    private Budget budget;
    private String payable;
    private BigDecimal amount;

    public PaymentThread(Budget budget, String payable, BigDecimal amount) {
        this.budget = budget;
        this.payable = payable;
        this.amount = amount;
    }

    public void run (){
        // * Send payment
        boolean isPaymentSent = budget.sendPayment(amount, payable);

        // * If not paid, return early
        if (!isPaymentSent) return;

        // * Print remaining fund
        System.out.println("Your remaining fund after paying for " + payable + " is Php " + budget.getTotalMoney());

        // * Print running expenses
        System.out.println("Your total running expenses after paying for " + budget.getPayables() + " is Php " + budget.getTotalExpenses());
    }
}
