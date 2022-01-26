package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
    }

    public long countOrdersByStatus(String status) {
        return orders.stream()
                .filter(order -> order.getStatus().equals(status))
                .count();
    }

    public List<Order> getOrdersBetweenDates(LocalDate firstDate, LocalDate secondDate) {
        if (secondDate.isAfter(firstDate)) {
            return orders.stream()
                    .filter(order -> order.getOrderDate().isAfter(firstDate) && order.getOrderDate().isBefore(secondDate))
                    .toList();
        } else if (firstDate.isAfter(secondDate)) {
            return orders.stream()
                    .filter(order -> order.getOrderDate().isAfter(secondDate) && order.getOrderDate().isBefore(firstDate))
                    .toList();
        } else {
            throw new IllegalArgumentException("Invalid dates.");
        }
    }

    public boolean isOrderWithLessProductThan(int numberOfProducts) {
        return orders.stream()
                .anyMatch(order -> order.getProducts().size() < numberOfProducts);
    }

    public Order getOrderWithMostProduct() {
        return orders.stream().
                max(Comparator.comparingInt(order -> order.getProducts().size())).orElseThrow(() -> new IllegalArgumentException("No orders"));
    }

    public List<Order> getOrdersWithCategory(String category) {
        return orders.stream()
                .filter(order -> order.getProducts()
                        .stream().anyMatch(product -> product.getCategory().equals(category)))
                .toList();
    }

    public List<Product> findProductsOverPrice(int amount) {
        return orders.stream()
                .flatMap(o -> o.getProducts().stream())
                .filter(p -> p.getPrice() > amount)
                .distinct()
                .toList();
    }
}
