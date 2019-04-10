package io.github.pengfeicheng.util_hub;

import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:
 * @Author: ChengPengFei
 * @CreateDate: 2019/4/10 10:54 AM
 * @Version: 1.0
 */
public class MD5Utils {

    /**
     * 计算 MD5 值， 返回32位的结果
     * @param src
     * @return 32位的结果
     */
    public static String calculate(String src) {

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            md.update(src.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte b[] = md.digest();
        StringBuffer buf = new StringBuffer();
        byte2Hex(b,buf);
        return buf.toString();
    }

    private static void byte2Hex(byte[] b,StringBuffer buf){
        int i;
        for (int offset = 0; offset < b.length; offset++) {
            i = b[offset];
            if (i < 0) i += 256;
            if (i < 16) buf.append("0");
            buf.append(Integer.toHexString(i));
        }
    }

    /**
     * 计算文件 MD5 值
     * @param file
     * @return
     */
    public static String calculate(File file){
        if(file == null || !file.exists() || !file.canRead()) return null;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            InputStream in = FileUtils.openFileInputStream(file.getPath());
            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1){
                md.update(buffer,0,read);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        byte b[] = md.digest();
        StringBuffer buf = new StringBuffer();
        byte2Hex(b,buf);
        return buf.toString();
    }
}
