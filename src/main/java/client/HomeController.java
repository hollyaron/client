package client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;

import org.quartz.JobDetail;

import static org.quartz.SimpleScheduleBuilder.*;

import com.caucho.hessian.client.HessianProxyFactory;

@Controller
public class HomeController {
	
	boolean firstRun = true;
	
	static User defaultUser = new User(new java.util.Date());
	
	static String[] history  = new String[10];
	
	String url = "http://localhost:7080/communication-service";
    HessianProxyFactory factory = new HessianProxyFactory();
    static CommunicationService basic;
    
    JobDetail job = newJob(MyJob.class)
		      .withIdentity("job1", "group1")
		      .build();
	 
	 Trigger trigger = newTrigger()
		      .withIdentity("trigger1", "group1")
		      .startNow()
		      .withSchedule(simpleSchedule()
		              .withIntervalInSeconds(30)
		              .repeatForever())
		      .build();
	 
	 Scheduler scheduler;

	
	@ModelAttribute("user")
	private User construct() {
		
		return new User(new java.util.Date());
		
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.POST, params = "send")
	public String doRegister(Model model, @ModelAttribute("user") User user) {
		
			for(int f = 9; f != 0; f--)
			{
				
				history[f] = history[f - 1];
				
			}
			
			history[0] =  basic.communicate(user);
		  
		  	System.out.println(history[0]);
		  	
		  	for(int f = 0; f < 10; f++) {
		  		model.addAttribute("history" + f, history[f]);
		  	}
		  
		  	return "/WEB-INF/jsp/welcome.jsp";
	  }
	
  @RequestMapping("/index")
  public String welcome(Model model) throws Exception {
	  
	  if(firstRun) {
		  
		  defaultUser.setEmail("default@email.com");
		  defaultUser.setName("Default");
		  defaultUser.setPassword("default");
		  
		 basic = (CommunicationService) factory.create(CommunicationService.class, url);
		
		 scheduler = StdSchedulerFactory.getDefaultScheduler();
		 scheduler.scheduleJob(job, trigger);
		 scheduler.start();
		 
		 firstRun = false;
		 
	  }
	  	
	  	for(int f = 0; f < 10; f++) {
	  		model.addAttribute("history" + f, history[f]);
	  	}
	  	
      return "/WEB-INF/jsp/welcome.jsp";
      
  }
  
}