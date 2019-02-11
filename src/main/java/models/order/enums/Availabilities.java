package models.order.enums;

public enum Availabilities {
    
    DEFAULT,
    IN_STOCK( "In stock" );
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Availabilities() {
        setNumber( ordinal() );
        setDescription( "None" );
    }
    
    Availabilities( String description ) {
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
