package com.novli.order.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;

import java.io.IOException;

/**
 * Created by 廖师兄
 * 2018-02-21 10:40
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static  <T> T fromJson(String str, TypeReference typeReference) {
        try {
            return objectMapper.readValue(str, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
