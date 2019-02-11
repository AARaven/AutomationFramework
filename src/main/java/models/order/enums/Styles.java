package models.order.enums;

public enum Styles {
    
    DEFAULT,
    CASUAL( "Casual" ),
    DRESSY( "Dressy" ),
    GIRLY( "Girly" );
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Styles() {
        setNumber( ordinal() );
        setDescription( "None" );
    }
    
    Styles( String description ) {
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
