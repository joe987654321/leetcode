package com.yahoo.nevec.egs.product.consumer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;

import org.apache.commons.codec.binary.Base64;

public class AAA { 
    public static void main(String[] args) throws IOException{
        String testinstring = "test compressed text";
        
        //String compressedString = z64(testinstring);
        //System.out.println(compressedString);
        
        //String testoutstring;
        //testoutstring = decompress(compressedString);
        //System.out.println(testoutstring);
        
        String compress_string = "eJylULtOxDAQ/BVk2lPkR5Jz0iMqKiqqyNh7l0jnOPJugAjdv7M+nhIFBe48O7Mzs68iLZAdTWkWvYAXgjmInYhAbgiOnOhfxQxP4AfMfhgTEtMiZDiirsBXtOhqc2NKlU+Rhe9cmiIgubgwWdWyk2pvrW1abbX8IuGGBJEZd5D96OYwIVzd3N4X+ykwLsur61aZpqjwAj7oZm+V6UyrGHMXrIgxRdCdldfHA+NLLrVo46ELCwPepwD8o2dx5v14LMX+bRNLUdF/V2Q5OVpR9JpDfExNoxrbyb0tgm0pMR4dTv6PnDuRDodPA1Vradpi4E8JYUA/QlhPkAe+5UylTV7nS0xjlOxUZxreQPhTzM1XZMmv2OfzG+p+mik=";
        String output = normal_decompress(compress_string);
        System.out.println(output);
        return;
    }
    
    public static String z64(String s) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DeflaterOutputStream dos = new DeflaterOutputStream(baos);
        dos.write(s.getBytes("UTF-8"));
        dos.close();
        baos.close();
        byte [] b =  baos.toByteArray();
        return "--gz_base64--"+Base64.encodeBase64String(b);

    }
    
    public static String decompress(String s) throws IOException{
        while (true){
            if (s.startsWith("--gz_base64--")){
                System.out.println(s+"####");
                s = s.substring("--gz_base64--".length());
                System.out.println(s+"####");
                byte[] decodeBase64 = Base64.decodeBase64(s.getBytes("UTF-8"));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                try {
                    InflaterOutputStream ios = new InflaterOutputStream(baos);
                    try {
                        ios.write(decodeBase64);
                        s = new String(baos.toByteArray(),"UTF-8");
                    } finally {
                        ios.close();
                    }
                } finally {
                    baos.close();
                }
            }
            else
                break;
        }
        return s;
        /*
        byte[] decodeBase64 = Base64.decodeBase64(s);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            InflaterOutputStream ios = new InflaterOutputStream(baos);
            try {
                ios.write(decodeBase64);
                return new String(baos.toByteArray(), "UTF-8");
            } finally {
                ios.close();
            }
        } finally {
            baos.close();
        }
        */
    }
    
    public static String normal_decompress(String s) throws IOException{
        
        byte[] decodeBase64 = Base64.decodeBase64(s);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            InflaterOutputStream ios = new InflaterOutputStream(baos);
            try {
                ios.write(decodeBase64);
                return new String(baos.toByteArray(), "UTF-8");
            } finally {
                ios.close();
            }
        } finally {
            baos.close();
        }
        
        
    }
}


