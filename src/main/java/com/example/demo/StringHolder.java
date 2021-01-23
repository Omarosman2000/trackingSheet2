package com.example.demo;

public class StringHolder {
    private String value;
    public StringHolder(){
        value ="";
    }
    public StringHolder(String value){
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String val){
        value = val;
    }
    
}
