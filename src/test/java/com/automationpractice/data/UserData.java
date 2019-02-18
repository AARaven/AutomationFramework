package com.automationpractice.data;

import models.user.User;
import org.testng.annotations.DataProvider;

public class UserData extends Data {

    @DataProvider ( name = "User" )
    public Object[][] getUser() {
        return new Object[][] { { getData( "Mario",         User.class, USERS_VALID_PATH ) }, };
    }

    @DataProvider ( name = "UsersPair" )
    public Object[][] getUsersPair() {
        return new Object[][] { { getData( "Mario",         User.class, USERS_VALID_PATH ),
                                  getData( "Gene",          User.class, USERS_VALID_PATH ) } };
    }

    @DataProvider ( name = "Users", parallel = true )
    public Object[][] getUsers() {
        return new Object[][] { { getData( "Mario",         User.class, USERS_VALID_PATH ) },
                                { getData( "Gene",          User.class, USERS_VALID_PATH ) },
                                { getData( "Glenda",        User.class, USERS_VALID_PATH ) },
                                { getData( "Hedwig",        User.class, USERS_VALID_PATH ) }, };
    }

    ////////////////////////
    // For negative tests://
    ////////////////////////
    @DataProvider ( name = "EmptyUser" )
    public Object[][] getEmptyUser() {
        return new Object[][] { { getData( "EmptyUser",     User.class, USERS_INVALID_PATH ) } };
    }

    @DataProvider ( name = "IncorrectUser" )
    public Object[][] getIncorrectUser() {
        return new Object[][] { { getData( "IncorrectUser", User.class, USERS_INVALID_PATH ) } };
    }

    @DataProvider ( name = "LongDataUser" )
    public Object[][] getLongDataUser() {
        return new Object[][] { { getData( "LongDataUser",  User.class, USERS_INVALID_PATH ) } };
    }
}
