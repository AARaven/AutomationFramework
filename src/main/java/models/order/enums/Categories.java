package models.order.enums;

public enum Categories {

    DEFAULT,
    CASUAL( "Casual" ),
    EVENING( "Evening" ),
    SUMMER( "Summer" );

    private int    number;
    private String description;

    private void setNumber( int number ) {
        this.number = number;
    }

    private void setDescription( String description ) {
        this.description = description;
    }

    Categories() {
        setNumber( ordinal() );
        setDescription( "" );
    }

    Categories( String description ) {
        setNumber( ordinal() );
        setDescription( description );
    }

    public int getNumber() {
        return this.number;
    }

    public String getDescription() {
        return this.description;
    }
}
