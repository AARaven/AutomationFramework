package models.order.enums;

public enum Colours {

    DEFAULT,
    BEIGE( "Beige" ),
    BLACK( "Black" ),
    BLUE( "Blue" ),
    GREEN( "Green" ),
    ORANGE( "Orange" ),
    PINK( "Pink" ),
    WHITE( "White" ),
    YELLOW( "Yellow" );

    private int    number;
    private String description;

    private void setNumber( int number ) {
        this.number = number;
    }

    private void setDescription( String description ) {
        this.description = description;
    }

    Colours() {
        setNumber( ordinal() );
        setDescription( "None" );
    }

    Colours( String description ) {
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
