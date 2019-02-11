package models.order.enums;

public enum Properties {
    
    DEFAULT,
    COLORFUL( "Colorful" ),
    MAXI( "Maxi" ),
    MIDI( "Midi" ),
    SHORT( "Short" );
    
    private int    number;
    private String description;
    
    private void setNumber( int number ) {
        this.number = number;
    }
    
    private void setDescription( String description ) {
        this.description = description;
    }
    
    Properties() {
        setNumber( ordinal() );
        setDescription( "None" );
    }
    
    Properties( String description ) {
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
