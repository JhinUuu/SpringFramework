package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private OrderService orderService;

    // ShoppingCart 테스트
    @Test
    public void testShoppingCart() {

        // shoppingCart Null
        assertNotNull(shoppingCart);

        // 상품 2개
        assertEquals(2, shoppingCart.getProducts().size());

        // 첫 번째 상품 이름
        assertEquals("노트북", shoppingCart.getProducts().get(0).getName());

        // 두 번째 상품 이름 검증
        assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
        
        System.out.println(shoppingCart.toString());
    }

    // OrderService 테스트
    @Test
    public void testOrderService() {

        // orderService Null
        assertNotNull(orderService);

        // shoppingCart 주입 검증
        assertNotNull(orderService.getShoppingCart());

        // 주문 총액
        assertEquals(950000.0, orderService.calculateOrderTotal());
        
        System.out.println(orderService.toString());
    }
}