/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization.Amazon.Admin;

import java.util.ArrayList;

/**
 *
 * @author Manish Gajare
 */
public class WorkQueue {
    
    private ArrayList<WorkRequest> workQueue;

    public WorkQueue() {
        workQueue = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkQueue() {
        return workQueue;
    }


    
}
