package models.user.enums;

public enum States {

    DEFAULT,
    ALABAMA( "Alabama" , 1 ),
    ALASKA( "Alaska" , 2 ),
    ARIZONA( "Arizona" , 3 ),
    ARKANSAS( "Arkansas" , 4 ),
    CALIFORNIA( "California" , 5 ),
    COLORADO( "Colorado" , 6 ),
    CONNECTICUT( "Connecticut" , 7 ),
    DELAWARE( "Delaware" , 8 ),
    DISTRICT_OF_COLUMBIA( "District of Columbia" , 53 ),
    FLORIDA( "Florida" , 9 ),
    GEORGIA( "Georgia" , 10 ),
    HAWAII( "Hawaii" , 11 ),
    IDAHO( "Idaho" , 12 ),
    ILLINOIS( "Illinois" , 13 ),
    INDIANA( "Indiana" , 14 ),
    IOWA( "Iowa" , 15 ),
    KANSAS( "Kansas" , 16 ),
    KENTUCKY( "Kentucky" , 17 ),
    LOUISIANA( "Louisiana" , 18 ),
    MAINE( "Maine" , 19 ),
    MARYLAND( "Maryland" , 20 ),
    MASSACHUSETTS( "Massachusetts" , 21 ),
    MICHIGAN( "Michigan" , 22 ),
    MINNESOTA( "Minnesota" , 23 ),
    MISSISSIPPI( "Mississippi" , 24 ),
    MISSOURI( "Missouri" , 25 ),
    MONTANA( "Montana" , 26 ),
    NEBRASKA( "Nebraska" , 27 ),
    NEVADA( "Nevada" , 28 ),
    NEW_HAMPSHIRE( "New Hampshire" , 29 ),
    NEW_JERSEY( "New Jersey" , 30 ),
    NEW_MEXICO( "New Mexico" , 31 ),
    NEW_YORK( "New York" , 32 ),
    NORTH_CAROLINA( "North Carolina" , 33 ),
    NORTH_DAKOTA( "North Dakota" , 34 ),
    OHIO( "Ohio" , 35 ),
    OKLAHOMA( "Oklahoma" , 36 ),
    OREGON( "Oregon" , 37 ),
    PENNSYLVANIA( "Pennsylvania" , 38 ),
    PUERTO_RICO( "Puerto Rico" , 51 ),
    RHODE_ISLAND( "Rhode Island" , 39 ),
    SOUTH_CAROLINA( "South Carolina" , 40 ),
    SOUTH_DAKOTA( "South Dakota" , 41 ),
    TENNESSEE( "Tennessee" , 42 ),
    TEXAS( "Texas" , 43 ),
    US_VIRGIN_ISLANDS( "US Virgin Islands" , 52 ),
    UTAH( "Utah" , 44 ),
    VERMONT( "Vermont" , 45 ),
    VIRGINIA( "Virginia" , 46 ),
    WASHINGTON( "Washington" , 47 ),
    WEST_VIRGINIA( "West Virginia" , 48 ),
    WISCONSIN( "Wisconsin" , 49 ),
    WYOMING( "Wyoming" , 50 );

    private int    number;
    private String description;

    private void setNumber( int number ) {
        this.number = number;
    }

    private void setDescription( String description ) {
        this.description = description;
    }

    States() {
        setNumber( ordinal() );
        setDescription( "" );
    }

    States( String description , int number ) {
        setNumber( number );
        setDescription( description );
    }

    public int getNumber() {
        return this.number;
    }

    public String getDescription() {
        return this.description;
    }
}

