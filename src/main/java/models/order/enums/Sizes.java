package models.order.enums;

public enum Sizes {
    
    DEFAULT,
    S( "Small" ),
    M( "Medium" ),
    L( "Large" );
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Sizes() {
        setNumber( ordinal() );
        setDescription( "None" );
    }
    
    Sizes( String description ) {
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
