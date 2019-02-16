package models.order;

import lombok.*;
import models.order.enums.Colours;
import models.order.enums.Sizes;

@Setter ( AccessLevel.PRIVATE )
@Getter ( AccessLevel.PUBLIC )
@NoArgsConstructor ( access = AccessLevel.PUBLIC )
@AllArgsConstructor ( access = AccessLevel.PUBLIC )
public class Clothes {
    
    private int     quantity;
    private String  name;
    private Sizes   size;
    private Colours colour;
}
