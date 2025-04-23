package co.edu.udes.backend.controllers;

import co.edu.udes.backend.models.Order;
import co.edu.udes.backend.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/{customerId}")
    public ResponseEntity<Order> createOrder(@PathVariable Long customerId) {
        return ResponseEntity.ok(orderService.createOrder(customerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomer(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomer(customerId);
    }

    @PostMapping("/{orderId}/addProduct/{productId}")
    public ResponseEntity<Order> addProductToOrder(
            @PathVariable Long orderId,
            @PathVariable Long productId,
            @RequestParam int quantity) {
        return ResponseEntity.ok(orderService.addProductToOrder(orderId, productId, quantity));
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Order> updateOrderStatus(
            @PathVariable Long orderId,
            @RequestParam String status) {
        return ResponseEntity.ok(orderService.updateOrderStatus(orderId, status));
    }

    @GetMapping("/{orderId}/total")
    public double calculateTotal(@PathVariable Long orderId) {
        return orderService.calculateOrderTotal(orderId);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status) {
        return orderService.getOrdersByStatus(status);
    }

    @GetMapping("/recent")
    public List<Order> getRecentOrders(@RequestParam int days) {
        return orderService.getRecentOrders(days);
    }
}
