package com.jpmc.gti.adp.models;


public class CustomField extends BaseModel {


    private String customFieldType;
    private String customFieldTypeKey;


    public String getCustomFieldType() {
        return customFieldType;
    }

    public void setCustomFieldType(String customFieldType) {
        this.customFieldType = customFieldType;
    }

    public String getCustomFieldTypeKey() {
        return customFieldTypeKey;
    }

    public void setCustomFieldTypeKey(String customFieldTypeKey) {
        this.customFieldTypeKey = customFieldTypeKey;
    }
}