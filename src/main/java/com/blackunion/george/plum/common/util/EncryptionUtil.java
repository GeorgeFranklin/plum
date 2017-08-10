package com.blackunion.george.plum.common.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * 加密工具类。用于加密和解密。
 * Created by George on 2017-08-09.
 */
public class EncryptionUtil {

    /** 加密算法名称 */
    public static final String MD5 = "MD5";
    private static final String SHA1 = "SHA-1";


    /**
     * 获取字符串对应编码格式的Base64加密结果。
     * @param encodeStr 待加密字符串
     * @param charset 编码格式，类似UTF-8、GBK等
     * @return String 返回Base64加密后的字符串
     * @throws UnsupportedCharsetException 指定编码格式不支持异常
     * @throws NullPointerException 待加密字符串空值异常
     */
    public static String base64Encode(String encodeStr,String charset) throws UnsupportedCharsetException,NullPointerException {
        Charset charset1 = Charset.forName(charset);

        return Base64.encodeBase64String(encodeStr.getBytes(charset1));
    }

    /**
     * 获取Base64加密字符串对应编码格式的解密结果。
     * @param decodeStr 带解密字符串
     * @param charset 编码格式
     * @return String 返回Base64解密后的字符串
     * @throws UnsupportedEncodingException 指定编码格式不支持异常
     */
    public static String base64Decode(String decodeStr,String charset) throws UnsupportedEncodingException {
        return new String(Base64.decodeBase64(decodeStr),charset);
    }
}
