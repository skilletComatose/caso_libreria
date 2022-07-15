package com.ceiba.biblioteca.Utils;

import java.util.HashMap;

public class GlobalResponse {
    private HashMap<String, Object> response = new HashMap<>();
    private int code;
    
   
    public HashMap<String, Object> getResponse() {
        return response;
    }

    public void setResponse(HashMap<String, Object> response) {
        this.response = response;
    }


    public void addValue(String key, Object value){
        this.response.put(key, value);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    
}
