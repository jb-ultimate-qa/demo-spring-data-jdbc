package my.example.demojdbc.runner;

import my.example.demojdbc.AppProfile;
import my.example.demojdbc.roots.links_order.Order;
import my.example.demojdbc.roots.links_order.repos.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(AppProfile.ORDER)
class OrderCrudRunner implements CommandLineRunner {

    private final OrderService orderService;

    public OrderCrudRunner(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) {
        Order newOrder = orderService.createSampleOrder();
        System.out.println("*** Created order: " + newOrder);
        var orderId = newOrder.getId();

        orderService.readOrderById(orderId)
                .ifPresentOrElse(
                        o -> System.out.println("*** Fetched order: " + o),
                        () -> System.out.println("Order not found")
                );

        orderService.readBuyerByOrderId(orderId)
                .ifPresentOrElse(
                        b -> System.out.println("*** Fetched buyer: " + b),
                        () -> System.out.println("Buyer not found")
                );

        orderService.readShopByOrderId(orderId)
                .ifPresentOrElse(
                        s -> System.out.println("*** Fetched shop: " + s),
                        () -> System.out.println("Shop not found")
                );

        orderService.readSomeProductByOrderId(orderId)
                .ifPresentOrElse(
                        p -> System.out.println("*** Fetched product: " + p),
                        () -> System.out.println("Product not found")
                );
    }
}
