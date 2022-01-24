package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean isLessProductThan(int numberOfProducts) {
        return orders.stream().anyMatch(order -> order.getProducts().size() < numberOfProducts);
    }
}
