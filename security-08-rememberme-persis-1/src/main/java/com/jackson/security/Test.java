package com.jackson.security;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //aGw5JTJGWG1wUDIzTDFwdzlBWnZiTmJBJTNEJTNEOjQxYzhmSlFFd0JvJTJGNE5Qd05ZRklnZyUzRCUzRA
        //s = hl9%2FXmpP23L1pw9AZvbNbA%3D%3D:41c8fJQEwBo%2F4NPwNYFIgg%3D%3D
        //%3D 表示 =
        //hl9%2FXmpP23L1pw9AZvbNbA==:41c8fJQEwBo%2F4NPwNYFIgg==
        //数据库记录
        //admin	hl9/XmpP23L1pw9AZvbNbA==	41c8fJQEwBo/4NPwNYFIgg==	2021-03-03 13:57:45
        String s = new String(Base64.getDecoder().decode("aGw5JTJGWG1wUDIzTDFwdzlBWnZiTmJBJTNEJTNEOjQxYzhmSlFFd0JvJTJGNE5Qd05ZRklnZyUzRCUzRA"), "UTF-8");
        System.out.println("s = " + s);
    }
}
