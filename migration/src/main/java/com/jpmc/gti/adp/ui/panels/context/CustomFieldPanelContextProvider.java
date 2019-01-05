package com.jpmc.gti.adp.ui.panels.context;

import com.jpmc.gti.adp.api.TargetCustomFields;
import com.jpmc.gti.adp.api.TargetCustomFieldsFactory;
import com.jpmc.gti.adp.models.CustomField;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.issue.CustomFieldManager;
import com.atlassian.jira.user.ApplicationUser;
import com.atlassian.plugin.web.ContextProvider;
import com.atlassian.plugin.PluginParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CustomFieldPanelContextProvider implements ContextProvider {


    @Override
    public void init(Map<String, String> params) throws PluginParseException {

    }


    @Override
    public Map<String, Object> getContextMap(Map<String, Object> context) {

        context.put("target-fields", this.targetCustomFields());
        context.put("custom-fields", this.migrationCustomField());
        return context;
    }


    private List<CustomField> targetCustomFields() {

        return TargetCustomFieldsFactory.getTargetCustomFields();
    }


    private List<CustomField> migrationCustomField() {

        List<com.atlassian.jira.issue.fields.CustomField> customFields =
                ComponentAccessor.getCustomFieldManager().getCustomFieldObjects();

        List<CustomField> results = new ArrayList<CustomField>();

        for (com.atlassian.jira.issue.fields.CustomField customField : customFields) {

            CustomField field = new CustomField();
            field.setName(customField.getFieldName());
            field.setDescription(customField.getDescription());
            field.setCustomFieldType(customField.getCustomFieldType().getName());
            field.setCustomFieldTypeKey(customField.getCustomFieldType().getKey());
            results.add(field);
        }
        return results;
    }
}
