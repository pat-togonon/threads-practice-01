import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        // * Shared Resource
        Budget japanBudget =  new Budget();

        // * Threads
        Thread japanFlightBookingThread = new PaymentThread(japanBudget, "Japan Round Trip Flight Booking", new BigDecimal("8500"));

        Thread japanAccommodationBookingThread = new PaymentThread(japanBudget, "Japan Hotel Accommodation Booking", new BigDecimal("10000"));

        Thread japanFoodBudgetThread = new PaymentThread(japanBudget, "Japan Food and Pasalubong Budget", new BigDecimal("25000"));

        Thread japanTranspoBudgetThread = new PaymentThread(japanBudget, "Japan Transportation Budget", new BigDecimal("10000"));

        // * Start all threads
        japanFlightBookingThread.start();
        japanAccommodationBookingThread.start();
        japanFoodBudgetThread.start();
        japanTranspoBudgetThread.start();

    }



}
