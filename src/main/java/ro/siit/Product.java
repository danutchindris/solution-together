package ro.siit;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private String name;
    private BigDecimal price;
    private double discount;

    public Product(String name, BigDecimal price) {
        this(name, price, 0.0D);
    }

    public Product(String name, BigDecimal price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof Product)) {
            return false;
        }
        final Product product = (Product) o;
        return this.name.equals(product.name)
                && this.price.equals(product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
