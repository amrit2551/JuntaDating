package com.skeleton.database;

import com.skeleton.constant.PaperDbConstant;
import com.skeleton.modal.signupResponse.UserDetails;

import io.paperdb.Paper;

/**
 * Developer: Saurabh Verma
 * Dated: 19-02-2017.
 */
public final class CommonData implements PaperDbConstant {
    /**
     * Empty Constructor
     * not called
     */
    private CommonData() {
    }

    /**
     * Update fcm token.
     *
     * @param token the token
     */
//======================================== FCM token ==============================================
    public static void updateFCMToken(final String token) {
        Paper.book().write(PAPER_DEVICE_TOKEN, token);
    }

    /**
     * Gets fcm token.
     *
     * @return the fcm token
     */
    public static String getFCMToken() {
        return Paper.book().read(PAPER_DEVICE_TOKEN);
    }

    /**
     * Save access token.
     *
     * @param accessToken the access token
     */
//======================================== Access Token ============================================
    public static void saveAccessToken(final String accessToken) {
        Paper.book().write(PAPER_ACCESS_TOKEN, accessToken);
    }

    /**
     * Gets access token.
     *
     * @return the access token
     */
    public static String getAccessToken() {
        return Paper.book().read(PAPER_ACCESS_TOKEN);
    }


    //======================================== Clear Data ===============================================

    /**
     * Delete paper.
     */
    public static void clearData() {
        String deviceToken = getFCMToken();
        Paper.book().destroy();
        updateFCMToken(deviceToken);
    }

    /**
     * @param userDetails userinfo
     */
    public static void saveUserDetail(final UserDetails userDetails) {
        Paper.book().write("data", userDetails);
    }

    /**
     * @return userdetails
     */
    public static UserDetails getUserDetail() {
        return Paper.book().read("data");
    }
}
