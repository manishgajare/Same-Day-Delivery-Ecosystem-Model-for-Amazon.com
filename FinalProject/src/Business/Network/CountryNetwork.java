/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class CountryNetwork {
    
    
    private String countryName;
    private String status;
    private ArrayList<StateNetwork> stateNetworkList;

    public CountryNetwork() {
        
        stateNetworkList = new ArrayList<>();
        
    }
    
    
    
    
    
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    public ArrayList<StateNetwork> getStateNetworkList() {
        return stateNetworkList;
    }


    @Override
    public String toString() {
        return countryName;
    }
    
        public StateNetwork createAndAddStateNetwork(String stateName){
        StateNetwork stateNetwork = new StateNetwork();
        stateNetwork.setStateName(stateName);
        stateNetworkList.add(stateNetwork);
        return stateNetwork;
    }
    
    
}
