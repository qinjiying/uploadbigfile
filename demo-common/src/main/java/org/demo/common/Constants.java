package org.demo.common;

import java.util.HashMap;
import java.util.Map;

/**
 * ������
 * Created by ���� on 2017/05/02.
 * version 1.0
 */
public interface Constants {
    /**
     * �쳣��Ϣͳһͷ��Ϣ<br>
     * �ǳ��ź���֪ͨ��,���������쳣
     */
    public static final String Exception_Head = "boom��ը�ˡ�";
    /**
     * �����ֵ
     */
    public static final Map<Class<?>, String> cacheKeyMap = new HashMap<>();
    /**
     * �����ļ�����·����key��eg.FILE_MD5:1243jkalsjflkwaejklgjawe
     */
    public static final String FILE_MD5_KEY = "FILE_MD5:";
    /**
     * �����ϴ��ļ���״̬
     */
    public static final String FILE_UPLOAD_STATUS = "FILE_UPLOAD_STATUS";


}
