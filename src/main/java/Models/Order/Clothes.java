package Models.Order;

import Models.Order.Enums.Colours;
import Models.Order.Enums.Sizes;
import lombok.*;

@Setter( AccessLevel.PRIVATE )
@Getter( AccessLevel.PUBLIC )
@NoArgsConstructor( access = AccessLevel.PUBLIC )
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class Clothes {
    
    private int     quantity;
    private String  name;
    private Sizes   size;
    private Colours colour;
}
