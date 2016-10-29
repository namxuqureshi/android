package com.example.dev.officebox.helpers;

/**
 * Created by dev on 10/27/16.
 */

public class ApiURI {
    private static final String base_uri = "http:192.168.0.107:5000/api";
    public static final String facbook_login = base_uri+"/facebook/login";
    public static final String login = base_uri+"/user/login";
    public static final String register = base_uri+"/user/register";
}
