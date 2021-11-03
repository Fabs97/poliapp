package com.polimi.thesis.fsiciliano.poliapp.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.polimi.thesis.fsiciliano.poliapp.exception.InternalServerErrorException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class U {
    public static Object patch(Object original, Object patch) throws InternalServerErrorException {
        try {
            Gson gson = new Gson();
            JsonObject jsonPatch = gson.toJsonTree(patch).getAsJsonObject();
            JsonObject jsonOriginal = gson.toJsonTree(original).getAsJsonObject();
            jsonPatch.entrySet().stream().forEach(elementEntry -> {
                String key = elementEntry.getKey();
                if (jsonOriginal.has(key) && jsonOriginal.get(key).isJsonPrimitive()) {
                    jsonOriginal.remove(key);
                    jsonOriginal.add(key, elementEntry.getValue());
                }
            });

            return gson.fromJson(jsonOriginal, Class.forName(patch.getClass().getName()));

        } catch (Exception e) {
            throw new InternalServerErrorException(e.getMessage());
        }
    }

    public static String formatDateToORCL(Date date) {
        return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S")).format(date);
    }
}
