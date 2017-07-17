package client;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements org.quartz.Job {

    public MyJob() {
    	
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
    	
    	HomeController.defaultUser.setDate(new java.util.Date());
    	
    	for(int f = 9; f != 0; f--)
		{
			
			HomeController.history[f] = HomeController.history[f - 1];
			
		}
    	
    	HomeController.history[0] = "Scheduled: " + HomeController.basic.communicate(HomeController.defaultUser);
    	
    	System.out.println(HomeController.history[0]);
    	
    }
    
}
