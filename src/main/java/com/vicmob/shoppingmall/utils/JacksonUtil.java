package com.vicmob.shoppingmall.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by migo on 7/30/14.
 */
public class JacksonUtil {

    private static final Logger log = LoggerFactory.getLogger(JacksonUtil.class);

    static ObjectMapper mapper = new ObjectMapper();

    public static <T> String objToJson(T data) {
        try {
            return mapper.writeValueAsString(data).trim();
        } catch (Exception e) {
            log.error("objToJson error");
            log.error(e.getMessage(),e);
            return "";
        }
    }

    public static List<?> jsonToList(String json) {
        try {
            return mapper.readValue(json, List.class);
        } catch (Exception e) {
            log.error("jsonToList error");
            log.error(e.getMessage(),e);
            return null;
        }
    }

    public static <T> T jsonToObject(String json, Class<T> t) {
        try {
            return mapper.readValue(json, t);
        } catch (Exception e) {
            log.error("jsonToObject error");
            log.error(e.getMessage(),e);
            return null;
        }
    }


    public static JavaType getCollectionType(ObjectMapper mapper, Class<?> collectionClass, Class<?>... elementClasses) {
        return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
