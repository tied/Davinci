package com.jpmc.gti.adp.ui.panels.context;

import com.jpmc.gti.adp.models.IssueType;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.config.ConstantsManager;
import com.atlassian.plugin.web.ContextProvider;
import com.atlassian.plugin.PluginParseException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class IssueTypePanelContextProvider implements ContextProvider {


    @Override
    public void init(Map<String, String> params) throws PluginParseException {

    }


    @Override
    public Map<String, Object> getContextMap(Map<String, Object> context) {

        context.put("issue-types", this.issueTypeList());
        context.put("sub-task-issue-types", this.subTaskIssueTypeList());
        return context;
    }


    private List<IssueType> issueTypeList() {

        Collection<com.atlassian.jira.issue.issuetype.IssueType> issueTypes =
                ComponentAccessor.getConstantsManager().getRegularIssueTypeObjects();

        List<IssueType> issueTypeList = new ArrayList<IssueType>();
        for (com.atlassian.jira.issue.issuetype.IssueType issueType : issueTypes) {
            IssueType result = new IssueType();
            result.setName(issueType.getName());
            result.setDescription(issueType.getDescription());
            issueTypeList.add(result);
        }
        return issueTypeList;
    }


    private List<IssueType> subTaskIssueTypeList() {

        Collection<com.atlassian.jira.issue.issuetype.IssueType> issueTypes =
                ComponentAccessor.getConstantsManager().getSubTaskIssueTypeObjects();

        List<IssueType> issueTypeList = new ArrayList<IssueType>();
        for (com.atlassian.jira.issue.issuetype.IssueType issueType : issueTypes) {
            IssueType result = new IssueType();
            result.setName(issueType.getName());
            result.setDescription(issueType.getDescription());
            issueTypeList.add(result);
        }
        return issueTypeList;
    }
}