package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtils {

    private static final Gson GSON = new GsonBuilder().create();

    public static <T> String toJson(T t) {
        return GSON.toJson(t);
    }
}
