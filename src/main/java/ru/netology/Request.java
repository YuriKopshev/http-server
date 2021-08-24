package ru.netology;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class Request {

    public  Map<String, String> parseQuerystring(String queryString) {
        Map<String, String> map = new HashMap<String, String>();
        if ((queryString == null) || (queryString.equals(""))) {
            return map;
        }
        String[] params = queryString.split("&");
        for (String param : params) {
            try {
                String[] keyValuePair = param.split("=", 2);
                String name = URLDecoder.decode(keyValuePair[0], "UTF-8");
                if (name == "") {
                    continue;
                }
                String value = keyValuePair.length > 1 ? URLDecoder.decode(
                        keyValuePair[1], "UTF-8") : "";
                map.put(name, value);
            } catch (UnsupportedEncodingException e) {
                // ignore this parameter if it can't be decoded
            }
        }
        return map;
    }

    public String queryString(String uri){
        return uri.split("\\?")[1];
    }
}
