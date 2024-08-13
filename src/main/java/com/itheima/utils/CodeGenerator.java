package com.itheima.utils;

public class CodeGenerator {

    private static final String[] placeholder = {"000000", "00000", "0000", "000", "00", "0", ""};


    public static String generateCode(String telephoneNo) {
        int hash = telephoneNo.hashCode();
        int encription = 20240419;
        long result = hash ^ encription;

        long currentTimestamp = System.currentTimeMillis();
        long code = (result ^ currentTimestamp)%1000000;

        code = code < 0 ? -code : code;
        String codeStr = code + "";

        codeStr = placeholder[codeStr.length()] + codeStr;
        return codeStr;
    }

}
