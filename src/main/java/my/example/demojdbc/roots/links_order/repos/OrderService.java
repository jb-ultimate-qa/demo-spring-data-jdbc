package my.example.demojdbc.roots.links_order.repos;


import my.example.demojdbc.roots.links_order.*;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepo;
    private final ShopRepository shopRepo;
    private final BuyerRepository buyerRepo;

    public OrderService(OrderRepository orderRepository, ProductRepository productRepo, ShopRepository shopRepo, BuyerRepository buyerRepo) {
        this.orderRepository = orderRepository;
        this.productRepo = productRepo;
        this.shopRepo = shopRepo;
        this.buyerRepo = buyerRepo;
    }

    @Transactional
    public Order createSampleOrder(){
        Product product1 = new Product("Laptop", BigDecimal.valueOf(1000));
        Product product2 = new Product("Mouse", BigDecimal.valueOf(50));
        productRepo.saveAll(List.of(product1, product2));

        Shop shop = new Shop("Tech Store");
        shopRepo.save(shop);

        Buyer buyer = new Buyer("Alice");
        buyerRepo.save(buyer);

        OrderItem item1 = new OrderItem(product1.getId(), 1);
        OrderItem item2 = new OrderItem(product2.getId(), 2);

        Order order = new Order();
        order.setBuyerId(buyer.getBuyerId());
        order.setShop(AggregateReference.to(shop.getId()));
        order.setItems(new java.util.ArrayList<>());
        order.addItem(item1);
        order.addItem(item2);

        return orderRepository.save(order);
    }

    public Optional<Order> readOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public Optional<Buyer> readBuyerByOrderId(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isEmpty()) { return Optional.empty(); }

        Long buyerId = order.get().getBuyerId();
        return buyerRepo.findById(buyerId);
    }

    public Optional<Shop> readShopByOrderId(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isEmpty()) { return Optional.empty(); }

        var shopId = order.get().getShop().getId();
        if (shopId == null) { return Optional.empty(); }
        return shopRepo.findById(shopId);
    }

    public Optional<Order> readFirstOrderByShopId(Integer shopId) {
        List<Order> order = orderRepository.findOrderByShop(shopId);
        if (order.isEmpty()) { return Optional.empty(); }
        return Optional.ofNullable(order.get(0));
    }

    public Optional<Order> readFirstOrderByShopReference(AggregateReference<Shop, Integer> shop) {
        List<Order> order = orderRepository.findOrderByShop(shop);
        if (order.isEmpty()) { return Optional.empty(); }
        return Optional.ofNullable(order.get(0));
    }

    public Optional<Product> readFirstProductByOrderId(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isEmpty()) { return Optional.empty(); }

        var items = order.get().getItems();
        if (items == null) { return Optional.empty(); }

        Long productId = items.get(0).getProductId();
        if (productId == null) { return Optional.empty(); }
        return productRepo.findById(productId);
    }
}