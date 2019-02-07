package Models.Order;

import Models.Order.Enums.*;
import lombok.*;

@Getter( value = AccessLevel.PUBLIC )
@Setter( AccessLevel.PUBLIC )
@NoArgsConstructor( access = AccessLevel.PUBLIC )
@AllArgsConstructor( access = AccessLevel.PUBLIC )
public class Filter {
    
    private Availabilities availabilities;
    private Categories     categories;
    private Colours        colours;
    private Compositions   compositions;
    private Conditions     conditions;
    private Manufacturers  manufacturers;
    private Properties     properties;
    private Sizes          sizes;
    private Styles         styles;
}
