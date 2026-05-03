package week6.processes.orderprocessor;

public class Order {
    String id;
    int amount;
    volatile String status;

    public Order(String id, int amount, String status) {
        this.id = id;
        this.amount = amount;
        if (status.equals("PENDING") || status.equals("PROCESSING") || status.equals("DONE") || status.equals("FAILED")) {
            this.status = status;
        } else {
            System.out.println("Status should be one of: PENDING, PROCESSING, DONE, or FAILED!");
        }
    }

    public void setStatus(String status) {
        if (status.equals("PENDING") || status.equals("PROCESSING") || status.equals("DONE") || status.equals("FAILED")) {
            this.status = status;
        } else {
            System.out.println("Status should be one of: PENDING, PROCESSING, DONE, or FAILED!");
        }
    }

    @Override
    public String toString() {
        return String.format("Order{id=%s, amount=%d, status=%s}", id, amount, status);
    }
}
