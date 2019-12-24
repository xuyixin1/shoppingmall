package com.vicmob.shoppingmall.utils;


import com.alibaba.fastjson.JSON;
import com.github.wxpay.sdk.WXPayUtil;
import com.vicmob.shoppingmall.web.goods.entity.Template;
import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigDecimal;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/**
 * AES加密和解密工具,可以对字符串进行加密和解密操作 
 * 
 *
 */
public class AesEncrypt {

    private static final Logger log = LoggerFactory.getLogger(AesEncrypt.class);

    /**
     * 密钥算法
     */
    private static final String ALGORITHM = "AES";
    /**
     * 加解密算法/工作模式/填充方式
     */
    private static final String ALGORITHM_MODE_PADDING = "AES/ECB/PKCS7Padding";


    /**
	 * AES 加密
	 * @param sSrc 需要解密的字符串
	 * @param sKey 秘钥（ 此处使用AES-128-ECB加密模式，key需要为16位。）
	 * @return
	 * @throws Exception
	 */
    public static String encrypt(String sSrc, String sKey){
        if (sKey == null) {
            log.error("key为空");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            log.error("Key长度不是16位");
            return null;
        }
        byte[] raw;
		try {
			raw = sKey.getBytes("utf-8");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
			
			return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
			
		} catch (Exception e) {
            log.error("AES 加密失败");
            log.error(e.getMessage(), e);
            return null;
		}
 
    }
 
    /**
     * AES解密
     * @param sSrc 解密的字符串
     * @param sKey 秘钥
     * @return
     * @throws Exception
     */
    public static String decrypt(String sSrc, String sKey) {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                log.error("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                log.error("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original,"utf-8");
            return originalString;


        } catch (Exception e) {
            log.error("AES 解密失败");
            log.error(e.getMessage(), e);
            return null;
        }
    }
    
    /**
     * 通过appId加密数据minaId
     * @param appId 公众号appId
     * @param minaId 小程序Id
     * @return enString 加密后的小程序Id
     * @throws Exception
     */
    public static String aesEncryption(String appId,String minaId){
        String enString="";
        try {
            //截取appId的前16位
            String aesKey=appId.substring(0, 16);
            enString = AesEncrypt.encrypt(minaId, aesKey);
		} catch (Exception e) {
            log.error("加密失败");
            log.error(e.getMessage(), e);
			enString = "";
		}
        return enString;
    }
    
    /**
     * 
     * @param appId 小程序Id
     * @param minaIdAes 加密后的小程序Id
     * @return deString 解密后的小程序Id
     * @throws Exception
     */
    public static String aesDecryption(String appId,String minaIdAes) {
    	String deString="";
		try {
            //截取appId的前16位
            String aesKey=appId.substring(0, 16);
			deString = AesEncrypt.decrypt(minaIdAes, aesKey);
		} catch (Exception e) {
            log.error("解密失败 appId ==》{}，minaIdAes ==>{}",appId,minaIdAes);
            log.error(e.getMessage(), e);
			deString = "";
		}
    	return deString;
    }

    /**
     * AES加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encryptData(String data,String md5Key) throws Exception {
        SecretKeySpec key = new SecretKeySpec(WXPayUtil.MD5(md5Key).toLowerCase().getBytes(), ALGORITHM);
        Security.addProvider(new BouncyCastleProvider());
        // 创建密码器
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING, "BC");
        // 初始化
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return Base64.encodeBase64String(cipher.doFinal(data.getBytes()));
    }

    /**
     * AES解密
     *
     *（1）对加密串A做base64解码，得到加密串B
     *（2）用key*对加密串B做AES-256-ECB解密（PKCS7Padding）
     * @param base64Data
     * @return
     * @throws Exception
     */
    public static String decryptData(String base64Data,String md5Key) throws Exception {
        SecretKeySpec key = new SecretKeySpec(WXPayUtil.MD5(md5Key).toLowerCase().getBytes(), ALGORITHM);
        Security.addProvider(new BouncyCastleProvider());
        Cipher cipher = Cipher.getInstance(ALGORITHM_MODE_PADDING, "BC");
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal( Base64.decodeBase64(base64Data)));
    }

    public static void main(String[] args) throws Exception {
        String aa=AesEncrypt.aesEncryption("wxf97345a42494307f","96");
        String bb = AesEncrypt.aesDecryption("wx481e26ad3edd92b9",aa);
        System.out.println(aa);
        System.out.println(bb);
        String a = "ab";
        String c =  a + "c";
        String d =  a + "c";
        String c1 =  a;
        String c2 =  "ab" + "c";
        String d2 = "ab" + "c";
        System.out.println(c == "abc");
        System.out.println(c == d);
        System.out.println(c1 == a);
        System.out.println(c2 == d2);
    }
}

