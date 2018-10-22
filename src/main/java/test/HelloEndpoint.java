package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.entity.*;
import test.repositories.*;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@RestController
public class HelloEndpoint {

    private final OrderRepository orderRepository;
    private final OrderPosRepository orderPosRepository;
    private final UserRepository userRepository;
    private final IsuePointRepository isuePointRepository;
    private final ProductRepository productRepository;
    private final ProductGroupRepository productGroupRepository;

    private Random random = new Random();

    @Autowired
    public HelloEndpoint(OrderRepository orderRepository, OrderPosRepository orderPosRepository, UserRepository userRepository, IsuePointRepository isuePointRepository, ProductRepository productRepository, ProductGroupRepository productGroupRepository){

        this.orderRepository = orderRepository;
        this.orderPosRepository = orderPosRepository;
        this.userRepository = userRepository;
        this.isuePointRepository = isuePointRepository;
        this.productRepository = productRepository;
        this.productGroupRepository = productGroupRepository;
    }

    @RequestMapping("hi/hello")
    String abc() {

        User user = new User();
        IsuePoint isuePoint = new IsuePoint();
        ProductGroup productGroup = new ProductGroup();

        user.setUsername("FirstUser");
        user.setUserphone("88005553535");

        userRepository.save(user);

        isuePoint.setIsuePointName("FirstPoint");
        isuePoint.setAddress("Lenina 20");
        isuePointRepository.save(isuePoint);

        productGroup.setProductGroupName("GoodProducts");
        productGroup.setRemark("FreshProducts");
        productGroupRepository.save(productGroup);


        for(int i = 0; i<=5; i++) {
            {
            Set<Order> order = new HashSet<Order>();
            Order order1 = new Order();
            order1.setUser(user);
            order1.setIsuePoint(isuePoint);
            order1.setPhone("8- "+String.valueOf(random.nextInt()));
            order1.setRemark("Remark "+String.valueOf(random.nextInt()));

            user.setOrder(order);
            isuePoint.setOrder(order);
            orderRepository.save(order1);}



        }

        for(int i = 0; i<=5; i++){
            Set<Product> products = new HashSet<Product>();
            productGroup.setProduct(products);

            Product product = new Product();
            product.setProductGroup(productGroup);
            product.setProductName(String.valueOf(random.nextInt()));
            product.setProductPrice(random.nextInt());

            productRepository.save(product);
        }


        for(int j = 0; j<=5; j++){
            Order order = new Order();
            Product product = new Product();

            Set<OrderPos> orderPoses = new HashSet<OrderPos>();
            OrderPos orderPos = new OrderPos();

            orderPos.setOrder(order);
            orderPos.setProduct(product);

            orderPos.setPrice(random.nextDouble());
            orderPos.setQuantity(random.nextInt());
            orderPos.setGoodName(String.valueOf(random.nextInt()));

            order.setOrderPoses(orderPoses);
            product.setOrderPos(orderPoses);
            orderPosRepository.save(orderPos);

        }


        return "OK";
    }
}
