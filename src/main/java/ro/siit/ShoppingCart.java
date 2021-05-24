package ro.siit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean addItem(final Item item) {
        if (items.contains(item)) {
            final int index = items.indexOf(item);
            final Item existingItem = items.get(index);
            items.set(index, new Item(item.getProduct(),
                    existingItem.getQuantity() + item.getQuantity()));
        } else {
            return items.add(item);
        }
        return true;
    }

    public boolean removeItem(final Item item) {
        return items.remove(item);
    }

    public void increaseQuantity(final Item item, final int number) {
        if (items.contains(item)) {
            final int index = items.indexOf(item);
            final Item existingItem = items.get(index);
            existingItem.setQuantity(existingItem.getQuantity() + number);
        }
    }

    public void decreaseQuantity(final Item item, final int number) {
        if (items.contains(item)) {
            final int index = items.indexOf(item);
            final Item existingItem = items.get(index);
            existingItem.setQuantity(
                    existingItem.getQuantity() > number ?
                            (existingItem.getQuantity() - number) :
                            0
            );
        }
    }

    public BigDecimal calculateTotalPrice() {
        BigDecimal sum = BigDecimal.ZERO;
        for (Item item : items) {
            sum = sum.add(item.getProduct().getPrice()
                    .multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        return sum;
    }

    public int retrieveItemsNumber() {
        return items.size();
    }
}
