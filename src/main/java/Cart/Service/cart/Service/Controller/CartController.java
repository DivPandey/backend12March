package Cart.Service.cart.Service.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Cart.Service.cart.Service.models.Cart;
import Cart.Service.cart.Service.services.CartServices;

@RestController
public class CartController {
    private CartServices cs;

    public CartController(CartServices cs){
        this.cs=cs;
    }
    @GetMapping("/carts")
    public Cart[] getAllCart(){
        return cs.getAllCart();
    }

    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable("id")Long id){
        
        return CartServices.getSingleCart(id);
    }
     
    @PatchMapping("/carts/{id}")
    public Cart updateCart(@PathVariable("id")Long id){
        return cs.updateCart(id);
    }

    @DeleteMapping("/carts/{id}")
    public Cart deleteCart(@PathVariable("id")Long id){

        return CartServices.deleteCart(id);
    }

     @PostMapping("/carts")
    public Cart addNewCart(@RequestBody Cart cart){

        return CartServices.addNewCart(cart);
    }
}
