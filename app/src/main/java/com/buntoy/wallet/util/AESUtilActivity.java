package com.buntoy.wallet.util;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * AESUtil
 *
 */
public class AESUtilActivity extends AppCompatActivity{
    private LogUtil log=LogUtil.getInstance();
    public static final String DATA = "KzTU2hpqSXwJCXCnEdK1iZvVNdug3aecPoiDMFQnGfLyvhceNMM7";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aes);

        try {
            byte[] aesKey =AESUtil.initKey();
            log.i("AES privateKey : " + AESUtil.fromBytesToHex(aesKey));
            //1. save privateKey (AESUtil.fromBytesToHex(aesKey)) to your local
            //2. get privateKey (AESUtil.hexStringToByteArray())
            //byte[] bb=AESUtil.hexStringToByteArray(AESUtil.fromBytesToHex(aesKey));

            //with pwd 769012  parameter (byte[] aesKey)
            //byte[] aesKey2 = AESUtil.addBytes(AESUtil.hexStringToByteArray(AESUtil.fromBytesToHex(aesKey)),"769012".getBytes());
            //log.i("AES privateKey : " + AESUtil.fromBytesToHex(aesKey2));

            //encrypt
            byte[] encrypt = AESUtil.encryptAES(DATA.getBytes(), aesKey);
            log.i(" AES encrypt: " + AESUtil.fromBytesToHex(encrypt));

            //decrypt
            byte[] plain = AESUtil.decryptAES(encrypt, aesKey);
            log.i(" AES decrypt : " + new String(plain));

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
