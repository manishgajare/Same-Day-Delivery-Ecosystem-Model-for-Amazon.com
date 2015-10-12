/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Role.System.SystemAdminRole;
import Business.UserAccount.UserAccount;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author Manish Gajare
 */
public class ConfigureASystem {

    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
  
        Employee employee = new Employee();
        employee.setName("Manish Gajare");
        
        UserAccount userAccount = new UserAccount();
        userAccount.setUsername("sysadmin");
        userAccount.setPassword("sysadmin");
        userAccount.setEmployee(employee);
        userAccount.setRole(new SystemAdminRole());

        system.getUserAccountDirectory().getUserAccountList().add(userAccount);
        
        
        return system;
      
    
    
    
    }
    
    
    
    
    
}
