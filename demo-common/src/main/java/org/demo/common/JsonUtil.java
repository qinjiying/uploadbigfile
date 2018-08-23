package org.demo.common;


import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Jsonͨ�ô�����
 * 
 * @author xiaohui
 * @version 2016��10��29��
 * @see JsonUtil
 * @since
 */
public final class JsonUtil
{

    private static ObjectMapper objectMapper;

    public JsonUtil()
    {}

    /**
     * ������ת���ַ���Json
     * 
     * @param obj
     *            ����
     * @return Json��
     * @throws JsonProcessingException
     * @see
     */
    public static String writeObject2JSON(Object obj)
       
    {
    	
        try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
    }

    /**
     * ��Json��ת�ɶ���
     * 
     * @param json
     *            json��
     * @param obj
     *            ����class
     * @return ����
     * @throws IOException
     * @see
     */
    public static Object writeJSON2Object(String json, Class obj)
        throws IOException
    {
        return objectMapper.readValue(json, obj);
    }

    /**
     * ��json��ת�ɶ���
     * 
     * @param json
     *            json��
     * @param collectionClas
     *            ���϶���
     * @param elementClasses
     *            ��������
     * @return
     * @throws IOException
     * @see
     */
    public static Object writeJSON2List(String json, Class collectionClass, Class elementClasses[])
        throws IOException
    {
        com.fasterxml.jackson.databind.JavaType jt = objectMapper.getTypeFactory().constructParametricType(
            collectionClass, elementClasses);
        return objectMapper.readValue(json, jt);
    }

    static
    {
        // ��ʼ��
        objectMapper = new ObjectMapper();
        objectMapper.configure(com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_SINGLE_QUOTES,
            true);
        objectMapper.configure(
            com.fasterxml.jackson.core.JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
}
