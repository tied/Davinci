package com.jpmc.gti.adp.impl;

import java.util.ArrayList;
import java.util.List;
import com.jpmc.gti.adp.api.TargetCustomFields;
import com.jpmc.gti.adp.models.CustomField;


public class TargetCustomFieldsImpl implements TargetCustomFields
{
    private List<CustomField> customFields;


    public TargetCustomFieldsImpl() {
        this.customFields = new ArrayList<CustomField>();
    }


    public List<CustomField> getCustomFields() {

        for (int i = 0; i < 10; i++) {
            CustomField field = new CustomField();
            field.setName("Custom Field " + (i+1)*100);
            field.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempo.");
            field.setCustomFieldType("Lorem ipsum dolor sit amet");
            field.setCustomFieldTypeKey("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
            this.customFields.add(field);
        }
        return this.customFields;
    }



}