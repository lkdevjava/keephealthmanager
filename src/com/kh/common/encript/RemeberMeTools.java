package com.kh.common.encript;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.shiro.codec.Base64;

public class RemeberMeTools {

    //生成加密cookie信息密钥
    public static void main(String[] args) throws Exception {
	KeyGenerator kg = KeyGenerator.getInstance("AES");
	kg.init(128);// 要生成多少位，只需要修改这里即可128, 192或256
	SecretKey sk = kg.generateKey();
	byte[] b = sk.getEncoded();
	System.out.println(Base64.encodeToString(b));
    }

}
