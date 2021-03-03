package com.jackson.security;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //YWRtaW46MTYxNTk1OTA0NzUxMToyNGRkMWExZTZhMmE0MzY4NmJlNTJhZDE0YjMxNzZhNg
        //s = admin:1615958654307:49e2b0bd84245ab3434ab9b4b094b324
        //username + ":" + tokenExpire + ":" + password + ":" + key
        String s = new String(Base64.getDecoder().decode("YWRtaW46MTYxNTk1OTA0NzUxMToyNGRkMWExZTZhMmE0MzY4NmJlNTJhZDE0YjMxNzZhNg"), "UTF-8");
        System.out.println("s = " + s);
    }
}
