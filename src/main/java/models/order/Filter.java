package models.order;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import models.order.enums.*;

@Getter ( AccessLevel.PUBLIC )
@Setter ( AccessLevel.PRIVATE )
@AllArgsConstructor ( access = AccessLevel.PUBLIC )
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
