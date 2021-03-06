package models.user.enums;

public enum Months {

    DEFAULT,
    JANUARY( "January" ),
    FEBRUARY( "February" ),
    MARCH( "March" ),
    APRIL( "April" ),
    MAY( "May" ),
    JUNE( "June" ),
    JULY( "July" ),
    AUGUST( "August" ),
    SEPTEMBER( "September" ),
    OCTOBER( "October" ),
    NOVEMBER( "November" ),
    DECEMBER( "December" );

    private int    number;
    private String description;

    private void setNumber( int number ) {
        this.number = number;
    }

    private void setDescription( String description ) {
        this.description = description;
    }

    Months() {
        setNumber( ordinal() );
        setDescription( "" );
    }

    Months( String description ) {
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
