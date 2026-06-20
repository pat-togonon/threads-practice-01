import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        /*
         * Thread states - new, RUNNABLE, TIMED_WAITING, WAITING, BLOCKED, TERMINATED
         * methods - sleep(), join()
         * synchronized
         */

        // * Shared Resource
        Budget japanBudget =  new Budget();

        Thread japanFlightBookingThread = new Thread(() -> {
            String payable = "Japan Round Trip Flight Booking";
            japanBudget.sendPayment(new BigDecimal("8500"), payable);
            System.out.println("Your remaining fund after paying for " + payable + " is Php " + japanBudget.getTotalMoney());
            System.out.println("Your total running expenses after paying for " + japanBudget.getPayables() + " is Php " + japanBudget.getTotalExpenses());
        });

        Thread japanAccommodationBookingThread = new Thread(() -> {
            String payable = "Japan Hotel Accommodation Booking";
            japanBudget.sendPayment(new BigDecimal("10000"), payable);
            System.out.println("Your remaining fund after paying for " + payable + " is Php " + japanBudget.getTotalMoney());
            System.out.println("Your total running expenses after paying for " + japanBudget.getPayables() + " is Php " + japanBudget.getTotalExpenses());
        });

        Thread japanFoodBudgetThread = new Thread(() -> {
            String payable = "Japan Food and Pasalubong Budget";
            japanBudget.sendPayment(new BigDecimal("25000"), payable);
            System.out.println("Your remaining fund after paying for " + payable + " is Php " + japanBudget.getTotalMoney());
            System.out.println("Your total running expenses after paying for " + japanBudget.getPayables() + " is Php " + japanBudget.getTotalExpenses());
        });

        Thread japanTranspoBudgetThread = new Thread(() -> {
            String payable = "Japan Transportation Budget";
            japanBudget.sendPayment(new BigDecimal("10000"), payable);
            System.out.println("Your remaining fund after paying for " + payable + " is Php " + japanBudget.getTotalMoney());
            System.out.println("Your total running expenses after paying for " + japanBudget.getPayables() + " is Php " + japanBudget.getTotalExpenses());
        });

        japanFlightBookingThread.start();
        japanAccommodationBookingThread.start();
        japanFoodBudgetThread.start();
        japanTranspoBudgetThread.start();

    }



}
