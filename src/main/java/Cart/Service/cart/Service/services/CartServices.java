package Cart.Service.cart.Service.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Cart.Service.cart.Service.dtos.CartDtos;
import Cart.Service.cart.Service.models.Cart;

@Service
public class CartServices{
    private static RestTemplate restTemplate = new RestTemplate();

    public Cart[] getAllCart(){
        ResponseEntity<Cart[]> response = restTemplate.getForEntity("https://fakestoreapi.com/carts", Cart[].class);
        Cart[] allCarts = response.getBody();
        return allCarts;
    }

    
    public static Cart getSingleCart(Long id){
        ResponseEntity<Cart> response = restTemplate.getForEntity("https://fakestoreapi.com/carts/1", Cart.class);
            Cart singleCart = response.getBody();
            return singleCart;
    }

    public Cart updateCart(Long id){
        Cart ct = getSingleCart(id);
        CartDtos crt = new CartDtos();
        crt.setDate(ct.getDate());
        crt.setId(ct.getId());
        crt.setUserId(ct.getUserId());

        restTemplate.put("https://fakestoreapi.com/carts"+id,crt);
        return ct;
    }


    public static Cart deleteCart(Long id){
        Cart cartToBeDeleted = getSingleCart(id);
        restTemplate.delete("https://fakestoreapi.com/carts"+id);

        return cartToBeDeleted;
    }

    public static Cart addNewCart(Cart cart) {

        CartDtos newProduct = new CartDtos();
        newProduct.setId(cart.getId());
        newProduct.setDate(cart.getDate());
        newProduct.setUserId(cart.getUserId());

        restTemplate.postForObject(
                "https://fakestoreapi.com/carts",
                newProduct,
                CartDtos.class
        );

        return cart;
    }
    
}
