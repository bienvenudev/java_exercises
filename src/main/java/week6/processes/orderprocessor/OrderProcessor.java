package week6.processes.orderprocessor;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OrderProcessor {
        public static void main(String[] args) throws InterruptedException {
            int cores = Runtime.getRuntime().availableProcessors();
            Scanner scanner = new Scanner(System.in);
            boolean running = true;
            ExecutorService executor = Executors.newFixedThreadPool(cores);
            List<Order> orders = Collections.synchronizedList(new ArrayList<>());

            while (running) {
                String input = scanner.nextLine();
                switch (input) {
                    case "add":
                        UUID uuid = UUID.randomUUID();
                        String id = uuid.toString();
                        System.out.println("Input the amount of the order");
                        int amount = Integer.parseInt(scanner.nextLine().trim());
                        orders.add(new Order(id, amount, "PENDING"));
                        System.out.println("Order added: " + orders.getLast());
                        break;
                    case "process":
                        for (Order order: orders) {
                            if (order.status.equals("PENDING")) {
                                    System.out.println(LocalDateTime.now());
                                    executor.execute(() -> {
                                        try {
                                            synchronized (order) {
                                                if (!order.status.equals("PENDING")) return;
                                                order.setStatus("PROCESSING");
                                                }
                                                Thread.sleep(3000);
                                                if (new Random().nextBoolean()) {
                                                    throw new RuntimeException("Random processing failure");
                                                }
                                                order.setStatus("DONE");
                                                System.out.println("ORDER CHANGED STATUS SUCCESSFULLY: " + order);

                                        } catch (RuntimeException e) {
                                            order.setStatus("FAILED");
                                            System.out.println("Order failed: " + order);
                                        } catch (InterruptedException e) {
                                            Thread.currentThread().interrupt();
                                        }
                                    });

                                break;
                            }
                        }
                        break;
                    case "status":
                        int count = 0;
                        for (Order order: orders) {
                            if (order.status.equals("DONE")) {
                                count++;
                            }
                        }
                        System.out.println("Done orders: " + count);
                        System.out.println("All orders: " + orders);
                        break;
                    case "stop":
                        executor.shutdownNow();
                        executor = Executors.newFixedThreadPool(cores);
                        System.out.println("Stopped. Orders: " + orders);
                        break;
                    case "exit":
                        System.out.println("Exiting...");
                        executor.shutdownNow();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input! " + input);
                }
            }
            System.out.println("here in main thread! Orders are:" + orders);
        }
    }