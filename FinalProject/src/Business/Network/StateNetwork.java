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
public class StateNetwork {
 
    
    private String stateName;
    private String status;
    private ArrayList<RegionNetwork> regionNetworkList;

    public StateNetwork() {
        
      regionNetworkList = new ArrayList<>();  
        
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String StateName) {
        this.stateName = StateName;
    }

    public ArrayList<RegionNetwork> getRegionNetworkList() {
        return regionNetworkList;
    }


    @Override
    public String toString() {
        return stateName;
    }
    
     public RegionNetwork createAndAddRegionNetwork(String regionName){
        RegionNetwork regionNetwork = new RegionNetwork();
        regionNetwork.setRegionName(regionName);
        regionNetworkList.add(regionNetwork);
        return regionNetwork;
    }
    
    
}
