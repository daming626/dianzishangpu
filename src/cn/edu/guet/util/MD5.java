package cn.edu.guet.util;

import org.apache.commons.codec.binary.Base64;//JDK8������Ӧ�İ�������JDK12��û����

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MD5 {
    /**
     * ����MD5���м���
     *
     * @param str �����ܵ��ַ���
     * @return ���ܺ���ַ���
     * @throws NoSuchAlgorithmException     û�����ֲ�����ϢժҪ���㷨
     * @throws UnsupportedEncodingException
     */
    public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //ȷ�����㷽��
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        //���ܺ���ַ���
        String newstr = Base64.encodeBase64String(md5.digest(str.getBytes("UTF-8")));
        return newstr;
    }

    /**
     * �ж��û������Ƿ���ȷ
     *
     * @param newpasswd �û����������
     * @param oldpasswd ���ݿ��д洢�����룭���û������ժҪ
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static boolean checkpassword(String newpasswd, String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (encoderByMd5(newpasswd).equals(oldpasswd))
            return true;
        else
            return false;
    }
}