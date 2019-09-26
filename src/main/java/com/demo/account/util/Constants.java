package com.demo.account.util;

public class Constants {

    public static final int HTTP_200 = 200;
    public static final int HTTP_400 = 400;
    public static final int HTTP_404 = 404;
    public static final int HTTP_500 = 500;

    public static final String ACCOUNT_NOT_FOUND_ERRORCODE = "1000";
    public static final String TRANSACTION_NOT_FOUND_ERRORCODE = "1001";

    public static final String USER_ID_REGEX ="[0-9]+";
    public static final int USER_ID_LENGTH = 10;
    public static final String ACCT_NUM_REGEX ="[0-9-]+";
    public static final int ACCT_NUM_LENGTH = 16;
}
