package in.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import in.cg.service.ProductService;
import in.cg.service.CartService;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @GetMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/addToCart")
    public String addToCart(
            @RequestParam("id") int id,
            @RequestParam("quantity") int quantity) {

        // Find product by id
        var product = productService.getAllProducts()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        // If product exists, add to cart
        if (product != null) {
            cartService.addToCart(product, quantity);
        }

        // Redirect to cart page
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotalAmount());
        return "cart";
    }
}