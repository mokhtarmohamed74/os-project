/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terminalFunctions;

import java.io.*;
import java.util.*;
import java.util.Map.*;
 
public class sjk {
	
	
	/* public static void main(String[] args)
	    {
	         Mprocess proc[] = { new Mprocess(1, 6, 1),
	                            new Mprocess(2, 8, 1),
	                            new Mprocess(3, 7, 2),
	                            new Mprocess(4, 3, 3)};
	         GFG o= new GFG();
	        int tat[]=o.findavgTime(proc, proc.length);
	        int totaltat=0;
	        float avgtat=0;
	        for(int i=0;i<tat.length;i++) {
	        	totaltat+=tat[i];
	        }
	        avgtat=(float)totaltat/(float)tat.length;
	        
	    }*/
	
	public static class Mprocess
	{
	    int pid; // Process ID
	    int bt; // Burst Time
	    int art; // Arrival Time
	     
	    public Mprocess(int pid, int bt, int art)
	    {
	        this.pid = pid;
	        this.bt = bt;
	        this.art = art;
	    }
	   
	}
	 
	public static class GFG
	{
	    // Method to find the waiting time for all
	    // processes
	    public static void findWaitingTime(Mprocess proc[], int n,
	                                     int wt[])
	    {
	        int rt[] = new int[n];
	      
	        // Copy the burst time into rt[]
	        for (int i = 0; i < n; i++)
	            rt[i] = proc[i].bt;
	      
	        int complete = 0, t = 0, minm = Integer.MAX_VALUE;
	        int shortest = 0, finish_time;
	        boolean check = false;
	      
	        // Process until all processes gets
	        // completed
	        while (complete != n) {
	      
	            // Find process with minimum
	            // remaining time among the
	            // processes that arrives till the
	            // current time`
	            for (int j = 0; j < n; j++)
	            {
	                if ((proc[j].art <= t) &&
	                  (rt[j] < minm) && rt[j] > 0) {
	                    minm = rt[j];
	                    shortest = j;
	                    check = true;
	                }
	            }
	      
	            if (check == false) {
	                t++;
	                continue;
	            }
	      
	            // Reduce remaining time by one
	            rt[shortest]--;
	      
	            // Update minimum
	            minm = rt[shortest];
	            if (minm == 0)
	                minm = Integer.MAX_VALUE;
	      
	            // If a process gets completely
	            // executed
	            if (rt[shortest] == 0) {
	      
	                // Increment complete
	                complete++;
	                check = false;
	      
	                // Find finish time of current
	                // process
	                finish_time = t + 1;
	      
	                // Calculate waiting time
	                wt[shortest] = finish_time -
	                             proc[shortest].bt -
	                             proc[shortest].art;
	      
	                if (wt[shortest] < 0)
	                    wt[shortest] = 0;
	            }
	            // Increment time
	            t++;
	        }
	    }
	      
	    // Method to calculate turn around time
	   public static void findTurnAroundTime(Mprocess proc[], int n,
	                            int wt[], int tat[])
	    {
	        // calculating turnaround time by adding
	        // bt[i] + wt[i]
	        for (int i = 0; i < n; i++)
	            tat[i] = proc[i].bt + wt[i];
	    }
	      
	    // Method to calculate average time
	   public static int[] findavgTime(Mprocess proc[], int n)
	    {
	        int wt[] = new int[n], tat[] = new int[n];
	        findWaitingTime(proc, n, wt);
	        findTurnAroundTime(proc, n, wt, tat);
	      
	      return tat;
	    }
	    
	}
}