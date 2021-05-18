package ro.siit;

import java.util.Objects;

public class Item {

    private Product product;
    private Integer quantity;

    public Item(final Product product, final Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Item)) {
            return false;
        }
        final Item item = (Item) o;
        return item.product.equals(this.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }
}
