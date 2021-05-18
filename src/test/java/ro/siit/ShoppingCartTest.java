package ro.siit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ShoppingCartTest {

    @Test
    void testCalculateTotalPrice() {
        final ShoppingCart sc = new ShoppingCart();
        sc.addItem(new Item(new Product("mere", BigDecimal.TEN), 5));
        sc.addItem(new Item(new Product("prune", BigDecimal.valueOf(15)), 10));
        sc.addItem(new Item(new Product("avocado", BigDecimal.valueOf(3.5D)), 4));
        sc.addItem(new Item(new Product("mere", BigDecimal.TEN), 3));
        Assertions.assertEquals(BigDecimal.valueOf(244.0), sc.calculateTotalPrice());
    }

    @Test
    void testIncreaseQuantity() {
        final Product product = new Product("mere", BigDecimal.valueOf(13));
        final Item item = new Item(product, 10);
        final ShoppingCart sc = new ShoppingCart();
        sc.addItem(item);
        sc.increaseQuantity(new Item(product, 0), 7);
        Assertions.assertTrue(17 == sc.getItems().get(0).getQuantity());
    }

    @Test
    void testDecreaseQuantity() {
        final Product product = new Product("mere", BigDecimal.valueOf(13));
        final Item item = new Item(product, 10);
        final ShoppingCart sc = new ShoppingCart();
        sc.addItem(item);
        sc.decreaseQuantity(new Item(product, 0), 20);
        Assertions.assertTrue(0 == sc.getItems().get(0).getQuantity());
    }
}
