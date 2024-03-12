package Cart.Service.cart.Service.models;
import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cart {
    private long id;
    private long userId;
    private String date;
    private List<Description> products;
}
