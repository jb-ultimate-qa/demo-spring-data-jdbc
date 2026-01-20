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
        System.out.println("***** Created order: \t\t\t\t" + newOrder);
        var orderId = newOrder.getId();
        var shopId = newOrder.getShop().getId();

        orderService.readOrderById(orderId)
                .ifPresentOrElse(
                        o -> System.out.println("***** Fetched order by order id: \t" + o),
                        () -> System.out.println("Order not found")
                );

        orderService.readBuyerByOrderId(orderId)
                .ifPresentOrElse(
                        b -> System.out.println("***** Fetched buyer by order id: \t" + b),
                        () -> System.out.println("Buyer not found")
                );

        orderService.readShopByOrderId(orderId)
                .ifPresentOrElse(
                        s -> System.out.println("***** Fetched shop by order id: \t" + s),
                        () -> System.out.println("Shop not found")
                );

        orderService.readFirstOrderByShopId(shopId)
                .ifPresentOrElse(
                        e -> System.out.println("***** Fetched order by shop id: \t" + e),
                        () -> System.out.println("Order not found")
                );

        orderService.readFirstOrderByShopReference(newOrder.getShop())
                .ifPresentOrElse(
                        e -> System.out.println("***** Fetched order by shop ref: \t" + e),
                        () -> System.out.println("Order not found")
                );

        orderService.readFirstProductByOrderId(orderId)
                .ifPresentOrElse(
                        p -> System.out.println("***** Fetched product by order id: \t" + p),
                        () -> System.out.println("Product not found")
                );
    }
}
