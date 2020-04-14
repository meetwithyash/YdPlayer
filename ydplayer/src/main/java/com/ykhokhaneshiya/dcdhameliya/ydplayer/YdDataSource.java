package com.ykhokhaneshiya.dcdhameliya.ydplayer;

import java.util.HashMap;
import java.util.LinkedHashMap;

class YdDataSource {

    private static final String URL_KEY_DEFAULT = "URL_KEY_DEFAULT";

    int currentUrlIndex;
    LinkedHashMap urlsMap = new LinkedHashMap();
    String title = "";
    HashMap<String, String> headerMap = new HashMap<>();
    boolean looping = false;

    YdDataSource(String url, String title) {
        urlsMap.put(URL_KEY_DEFAULT, url);
        this.title = title;
        currentUrlIndex = 0;
    }

    private YdDataSource(LinkedHashMap urlsMap, String title) {
        this.urlsMap.clear();
        this.urlsMap.putAll(urlsMap);
        this.title = title;
        currentUrlIndex = 0;
    }

    Object getCurrentUrl() {
        return getValueFromLinkedMap(currentUrlIndex);
    }

    Object getCurrentKey() {
        return getKeyFromDataSource(currentUrlIndex);
    }

    String getKeyFromDataSource(int index) {
        int currentIndex = 0;
        for (Object key : urlsMap.keySet()) {
            if (currentIndex == index) {
                return key.toString();
            }
            currentIndex++;
        }
        return null;
    }

    private Object getValueFromLinkedMap(int index) {
        int currentIndex = 0;
        for (Object key : urlsMap.keySet()) {
            if (currentIndex == index) {
                return urlsMap.get(key);
            }
            currentIndex++;
        }
        return null;
    }

    YdDataSource cloneMe() {
        LinkedHashMap map = new LinkedHashMap();
        map.putAll(urlsMap);
        return new YdDataSource(map, title);
    }
}
