package com.frank.utils;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {
    public static byte[] decode(byte[] base64bytes) {
        return Base64.decodeBase64(base64bytes);
    }

    public static byte[] encode(byte[] strbytes) {
        return Base64.encodeBase64(strbytes);
    }
}
