package com.jpmc.gti.adp.api;

import com.jpmc.gti.adp.api.TargetCustomFields;
import com.jpmc.gti.adp.impl.TargetCustomFieldsImpl;
import com.jpmc.gti.adp.models.CustomField;
import java.util.List;

public class TargetCustomFieldsFactory
{
    public static List<CustomField> getTargetCustomFields() {

        return new TargetCustomFieldsImpl().getCustomFields();
    }
}