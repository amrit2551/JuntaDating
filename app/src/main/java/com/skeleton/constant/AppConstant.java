package com.skeleton.constant;

/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */

public interface AppConstant {
    String DEVICE_TYPE = "ANDROID";

    //Intent Filter
    String NOTIFICATION_RECEIVED = "notification_received";

    //
    int SESSION_EXPIRED = 401;
    //USER_SIGNUP_KEYS
    String USER_FNAME = "firstName";
    String USER_LNAME = "lastName";
    String USER_DOB = "dob";
    String USER_COUNTRY_CODE = "countryCode";
    String USER_PHONE = "phoneNo";
    String USER_EMAIL = "email";
    String USER_PASSWORD = "password";
    String USER_LANGUAGE = "language";
    String USER_DEVICE_TYPE = "deviceType";
    String USER_DEVICE_TOKEN = "deviceToken";
    String USER_APP_VERSION = "appVersion";
    String USER_GENDER = "gender";
    String USER_ORIENTATION = "orientation";
    String USER_PROFILE_PIC = "profilePic";
    String USER_NEW_NUMBER = "newNumber";

    String USER_RELATONSHIP_HISTORY = "relationshipHistory";
    String USER_RELIGION = "religion";
    String USER_ETHNICITY = "ethnicity";
    String USER_BODY_TYPE = "bodyType";
    String USER_HEIGHT = "height";
    String USER_SMOKING = "smoking";
    String USER_DRINKING = "drinking";

    String USER_STEP_1_COMPLETE_OR_SKIP = "step1CompleteOrSkip";
    String USER_STEP_2_COMPLETE_OR_SKIP = "step2CompleteOrSkip";

    String KEY_STEP_NUMBER = "stepNumber";

    //OTP VERIFICATION
    String USER_OTP_CODE = "OTPCode";

    //USER_SIGNUP_VALUES
    String VALUE_USER_LANGUAGE = "EN";
    String VALUE_USER_DEVICE_TYPE = "ANDROID";

    //Request code
    int REQ_CODE_DEFAULT_SETTINGS = 16061;
    int REQ_CODE_PLAY_SERVICES_RESOLUTION = 16061;
    int REQ_CODE_SCREEN_OVERLAY = 10101;
    int RC_SIGN_UP = 0;
    int RC_SIGN_IN = 1;
    int RC_OTP = 2;
    int RC_HOME = 3;
    int RC_COMPLETE_PROFILE = 4;
    int RC_EDIT_NUM = 5;
}
