package Cart.Service.cart.Service.dtos;

import java.util.List;

import Cart.Service.cart.Service.models.Description;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDtos {
    private Long id;
    private Long userId;
    private String date;
    private List<Description> descriptions;
}
