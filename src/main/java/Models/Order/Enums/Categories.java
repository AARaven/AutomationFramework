package Models.Order.Enums;

public enum Categories {
    
    DEFAULT(),
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
        this.setNumber( this.ordinal() );
        this.setDescription( "" );
    }
    
    Categories( String description ) {
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
