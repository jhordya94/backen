package co.edu.udes.backend.services;

import co.edu.udes.backend.models.*;
import co.edu.udes.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    /**
     * Crear una nueva orden para un cliente dado
     */
    public Order createOrder(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Order order = new Order();
        order.setCustomer(customer);
        order.setStatus("pendiente");
        order.setItems(new ArrayList<>());

        return orderRepository.save(order);
    }

    /**
     * Obtener una orden por su ID
     */
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * Obtener todas las órdenes de un cliente
     */
    public List<Order> getOrdersByCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
        return orderRepository.findByCustomer(customer);
    }

    /**
     * Agregar un producto con cantidad a una orden existente
     */
    public Order addProductToOrder(Long orderId, Long productId, int quantity) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        OrderItem item = new OrderItem(); // sin builder
        item.setOrder(order);
        item.setProduct(product);
        item.setQuantity(quantity);

        order.getItems().add(item);
        orderItemRepository.save(item);

        return orderRepository.save(order);
    }

    /**
     * Actualizar el estado de una orden
     */
    public Order updateOrderStatus(Long orderId, String newStatus) {
        return orderRepository.findById(orderId).map(order -> {
            order.setStatus(newStatus);
            return orderRepository.save(order);
        }).orElseThrow(() -> new RuntimeException("Orden no encontrada"));
    }

    /**
     * Calcular el total de una orden sumando precios * cantidades
     */
    public double calculateOrderTotal(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Orden no encontrada"));

        return order.getItems().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    /**
     * Eliminar una orden por su ID
     */
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    /**
     * Filtrar órdenes por estado
     */
    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    /**
     * Obtener órdenes creadas en los últimos X días (ajustable luego por fecha real)
     */
    public List<Order> getRecentOrders(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        Date dateThreshold = calendar.getTime();

        return orderRepository.findAll().stream()
                .filter(order -> order.getId() != null && order.getId() > 0)
                .toList();
    }
}
