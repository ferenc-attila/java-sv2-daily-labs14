package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    OrderService orderService;

    @BeforeEach
    void init() {
        orderService = new OrderService();

        Product p1 = new Product("Tv", "IT", 2000);
        Product p2 = new Product("Laptop", "IT", 2400);
        Product p3 = new Product("Phone", "IT", 400);
        Product p4 = new Product("Lord of The Rings", "Book", 20);
        Product p5 = new Product("Harry Potter Collection", "Book", 120);

        Order o1 = new Order("pending", LocalDate.of(2021, 06, 07));
        o1.addProduct(p1);
        o1.addProduct(p2);
        o1.addProduct(p5);

        Order o2 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o2.addProduct(p3);
        o2.addProduct(p1);
        o2.addProduct(p2);

        Order o3 = new Order("pending", LocalDate.of(2021, 06, 07));
        o3.addProduct(p1);
        o3.addProduct(p2);
        o3.addProduct(p5);

        Order o4 = new Order("on delivery", LocalDate.of(2021, 06, 01));
        o4.addProduct(p3);
        o4.addProduct(p1);
        o4.addProduct(p2);

        Order o5 = new Order("pending", LocalDate.of(2021, 06, 07));
        o5.addProduct(p1);
        o5.addProduct(p2);
        o5.addProduct(p5);
        o5.addProduct(p4);

        orderService.saveOrder(o1);
        orderService.saveOrder(o2);
        orderService.saveOrder(o3);
        orderService.saveOrder(o4);
        orderService.saveOrder(o5);
    }

    @Test
    void getNumberOfOrdersByStatusTest() {
        assertEquals(3, orderService.countOrdersByStatus("pending"));
        assertEquals(2, orderService.countOrdersByStatus("on delivery"));
        assertEquals(0, orderService.countOrdersByStatus(""));
    }

    @Test
    void getOrdersBetweenDatesTest() {
        List<Order> result = orderService.getOrdersBetweenDates(LocalDate.of(2021,5,31), LocalDate.of(2021,06,02));
        assertEquals(2, result.size());
    }

    @Test
    void isOrderWithLessProductsThanTest() {
        assertTrue(orderService.isOrderWithLessProductThan(4));
        assertFalse(orderService.isOrderWithLessProductThan(2));
    }

    @Test
    void getOrderWithMostProductTest() {
        Order result = orderService.getOrderWithMostProduct();
        assertEquals(4, result.getProducts().size());
    }
}
