package models.order.enums;

public enum Compositions {
    
    DEFAULT,
    COTTON( "Cotton" ),
    POLYESTER( "Polyester" ),
    VISCOSE( "Viscose" );
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Compositions() {
        setNumber( ordinal() );
        setDescription( "None" );
    }
    
    Compositions( String description ) {
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
