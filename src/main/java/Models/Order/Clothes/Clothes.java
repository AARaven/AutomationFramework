package Models.Order.Clothes;

import Models.Order.Clothes.Enums.ForOrdering.Colours;
import Models.Order.Clothes.Enums.ForOrdering.Sizes;
import lombok.Data;

@Data
public class Clothes {
    private int          quantity;
    private String       name;
    private Sizes        size;
    private Colours      colour;
}
