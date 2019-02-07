package Models.Order;

import Models.Order.Clothes.Enums.ForOrdering.Colours;
import Models.Order.Clothes.Enums.ForOrdering.Compositions;
import Models.Order.Clothes.Enums.ForOrdering.Properties;
import Models.Order.Clothes.Enums.ForOrdering.Sizes;
import Models.Order.Clothes.Enums.ForUserChoice.*;
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
