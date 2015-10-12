/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Network.CountryNetwork;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.System.SystemAdminRole;

import java.util.ArrayList;


/**
 *
 * @author Manish Gajare
 */
public class EcoSystem extends Organization{
    
   
    private static EcoSystem system;
    private ArrayList<CountryNetwork> countryNetworkList;
    
    public static EcoSystem getInstance(){
        if (system == null){
            system = new EcoSystem();
        }
        return system;
    }

    private EcoSystem() {
        super(null);
        countryNetworkList = new ArrayList<>();
    }

    public ArrayList<CountryNetwork> getCountryNetworkList() {
        return countryNetworkList;
    }



    @Override
    public ArrayList<Role> getSupportedRole() {
        
        SystemAdminRole role = new SystemAdminRole();
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);
        return roleList;
        
    }
    
     public CountryNetwork createAndAddCountryNetwork(String countryName){
        CountryNetwork countryNetwork = new CountryNetwork();
        countryNetwork.setCountryName(countryName);
        countryNetworkList.add(countryNetwork);
        return countryNetwork;
    }
    
   
    
}
