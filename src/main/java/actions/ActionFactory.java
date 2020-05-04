package actions;

import actions.departments.*;
import actions.employees.DeleteEmployeeAction;
import actions.employees.EmployeesListAction;
import actions.employees.InsertUpdateEmployeeAction;
import actions.employees.InsertUpdateEmployeeFormAction;

import java.util.HashMap;

public class ActionFactory {
    private HashMap<String, Action> actions = new HashMap<>();
    private static ActionFactory actionFactory;

    public ActionFactory(){
        actions.put("/departments/departments", new DepartmentsListAction());
        actions.put("/departments/departments/delete", new DeleteDepartmentAction());
        actions.put("/departments/departments/edit", new InsertUpdateDepartmentFormAction());
        actions.put("/departments/departments/update", new InsertUpdateDepartmentAction());

        actions.put("/departments/employees", new EmployeesListAction());
        actions.put("/departments/employees/edit", new InsertUpdateEmployeeFormAction());
        actions.put("/departments/employees/update", new InsertUpdateEmployeeAction());
        actions.put("/departments/employees/delete", new DeleteEmployeeAction());
    }

    public Action getAction(String actionName){
        return actions.get(actionName);
    }

    public static ActionFactory getInstance(){
        if (actionFactory == null){
            actionFactory = new ActionFactory();
        }
        return actionFactory;
    }
}
