package org.demo.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class PropertiesUtil extends PropertyPlaceholderConfigurer {
    private static Map<String, Object> ctxPropertiesMap; 
    
    @Override 
    protected void processProperties( 
            ConfigurableListableBeanFactory beanFactoryToProcess, 
            Properties props) throws BeansException { 
        super.processProperties(beanFactoryToProcess, props); 
        ctxPropertiesMap = new HashMap<String, Object>(); 
        for (Object key : props.keySet()) { 
            String keyStr = key.toString(); 
            String value = props.getProperty(keyStr); 
            ctxPropertiesMap.put(keyStr, value); 
        }  
    } 
 
    public static Object getContextProperty(String name) { 
        return ctxPropertiesMap.get(name); 
    } 
    
	/**
	 * 根据key读取对应的value
	 * 
	 * @param key
	 * @return
	 */
	public static String get(String key) {
		return (String) ctxPropertiesMap.get(key);
	}
}
