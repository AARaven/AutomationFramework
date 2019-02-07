package Models.Order.Enums;

public enum Manufacturers {
    
    DEFAULT(),
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
        this.setNumber( ordinal() );
        this.setDescription( "None" );
    }
    
    Manufacturers( String description ) {
        this.setNumber( this.ordinal() );
        this.setDescription( description );
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    
}
