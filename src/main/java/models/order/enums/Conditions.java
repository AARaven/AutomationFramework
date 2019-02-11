package models.order.enums;

public enum Conditions {
    
    DEFAULT,
    NEW( "New" );
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Conditions() {
        setNumber( ordinal() );
        setDescription( "None" );
    }
    
    Conditions( String description ) {
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
