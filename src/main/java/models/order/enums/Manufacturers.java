package models.order.enums;

public enum Manufacturers {

    DEFAULT,
    FASHION( "Fashion" );

    private int    number;
    private String description;

    private void setNumber( int number ) {
        this.number = number;
    }

    private void setDescription( String description ) {
        this.description = description;
    }

    Manufacturers() {
        setNumber( ordinal() );
        setDescription( "None" );
    }

    Manufacturers( String description ) {
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
