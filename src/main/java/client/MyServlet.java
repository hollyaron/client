package client;

import com.caucho.hessian.server.HessianServlet;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;

import org.apache.log4j.Logger;

public class MyServlet extends HessianServlet implements CommunicationService {

    private static final long serialVersionUID = -3429056066423924965L;
    
    static Logger logger = Logger.getLogger(HomeController.class);

    public String communicate(User user) {
    	
        return "Server echo: " + user.getName() + " " + user.getEmail() + " " + user.date;
        
    }

    public static void main(String[] args) throws Exception {
    	
    	logger.info("Entering main");
    	
        Server server = new Server(7080);
        Context context = new Context(server, "/", Context.SESSIONS);
        context.addServlet(MyServlet.class, "/communication-service");
        server.start();
        
        logger.info("Exiting main");
        
    }
    
}
