package ru.netology;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Request {
    public static Map<String, String> parseQueryString(String queryString) {
        Map<String, String> map = new HashMap<>();
        if ((queryString == null) || (queryString.equals(""))) {
            return map;
        }
        String[] params = queryString.split("&");
        for (String param : params) {
            String[] keyValuePair = param.split("=", 2);
            String name = URLDecoder.decode(keyValuePair[0], StandardCharsets.UTF_8);
            if (Objects.equals(name, "")) {
                continue;
            }
            String value = keyValuePair.length > 1 ? URLDecoder.decode(
                    keyValuePair[1], StandardCharsets.UTF_8) : "";
            map.put(name, value);
        }
        return map;
    }

    public static String queryString(String uri) throws MalformedURLException {
        return uri.substring(2);
    }

    public static String getParamByName(Map<String, String> map,String name){
       return map.get(name);
    }
}

