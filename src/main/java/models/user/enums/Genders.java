package models.user.enums;

public enum Genders {

    DEFAULT,
    MALE( "Male" ),
    FEMALE( "Female" );

    private int    number;
    private String description;

    private void setNumber( int number ) {
        this.number = number;
    }

    private void setDescription( String description ) {
        this.description = description;
    }

    Genders() {
        setNumber( ordinal() );
        setDescription( "None" );
    }

    Genders( String description ) {
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
