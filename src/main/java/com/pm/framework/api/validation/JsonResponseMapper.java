package com.pm.framework.api.validation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonResponseMapper {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private JsonResponseMapper(){
    }

    public static <T> T fromJson(String json,Class<T> responseType){

        try {

            return OBJECT_MAPPER.readValue(
                    json,
                    responseType
            );

        } catch (JsonProcessingException e) {

            throw new RuntimeException(
                    "Failed to deserialize API response into "
                            + responseType.getSimpleName(),
                    e
            );
        }
    }
}

