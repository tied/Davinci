package com.jpmc.gti.adp.ui.panels.context;

import com.jpmc.gti.adp.models.Action;
import com.jpmc.gti.adp.models.Status;
import com.jpmc.gti.adp.models.Step;
import com.jpmc.gti.adp.models.Workflow;
import com.atlassian.jira.component.ComponentAccessor;
import com.atlassian.jira.workflow.JiraWorkflow;
import com.atlassian.jira.workflow.WorkflowManager;
import com.atlassian.plugin.web.ContextProvider;
import com.atlassian.plugin.PluginParseException;
import com.opensymphony.workflow.loader.ActionDescriptor;
import com.opensymphony.workflow.loader.StepDescriptor;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class WorkflowPanelContextProvider implements ContextProvider {


    @Override
    public void init(Map<String, String> params) throws PluginParseException {

    }


    @Override
    public Map<String, Object> getContextMap(Map<String, Object> context) {

        context.put("workflow-list", this.workflowList());
        return context;
    }


    private List<Workflow> workflowList() {

        Collection<JiraWorkflow> jiraWorkflows =
                ComponentAccessor.getWorkflowManager().getActiveWorkflows();

        List<Workflow> workflowList = new ArrayList<Workflow>();
        for (JiraWorkflow jiraWorkflow : jiraWorkflows) {

            Workflow result = new Workflow();
            result.setName(jiraWorkflow.getName());
            result.setDescription(jiraWorkflow.getDescription());
            result.setActions(this.actionList(jiraWorkflow));
            result.setStatuses(this.statusList(jiraWorkflow));
            workflowList.add(result);
        }
        return workflowList;
    }


    private List<Action> actionList(JiraWorkflow jiraWorkflow) {

        List<Action> actions = new ArrayList<Action>();
        for (ActionDescriptor actionDescriptor : jiraWorkflow.getAllActions()) {
            Action action = new Action();
            action.setName(actionDescriptor.getName());

            List<Step> steps = new ArrayList<Step>();
            for (StepDescriptor stepDescriptor : jiraWorkflow.getStepsForTransition(actionDescriptor)) {
                Step step = new Step();
                step.setName(stepDescriptor.getName());
                steps.add(step);
            }
            action.setSteps(steps);
        }
        return actions;
    }


    private List<Status> statusList(JiraWorkflow jiraWorkflow) {
        List<Status> statuses = new ArrayList<Status>();
        for (com.atlassian.jira.issue.status.Status linkedStatus : jiraWorkflow.getLinkedStatusObjects()) {
            Status status = new Status();
            status.setName(linkedStatus.getName());
            status.setDescription(linkedStatus.getDescription());
            statuses.add(status);
        }
        return statuses;
    }
}