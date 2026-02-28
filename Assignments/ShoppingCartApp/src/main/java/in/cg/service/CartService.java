package in.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import in.cg.model.CartItem;
import in.cg.model.Product;

@Service
public class CartService {

    private List<CartItem> cart = new ArrayList<>();

    public void addToCart(Product product, int quantity) {
        cart.add(new CartItem(product, quantity));
    }

    public List<CartItem> getCartItems() {
        return cart;
    }

    public double getTotalAmount() {
        return cart.stream()
                   .mapToDouble(CartItem::getTotal)
                   .sum();
    }
}