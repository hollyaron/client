package client;

import com.caucho.hessian.server.HessianServlet;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.Context;

public class MyServlet extends HessianServlet implements CommunicationService {

    private static final long serialVersionUID = -3429056066423924965L;

    public String communicate(User user) {
    	
        return "Server echo: " + user.getName() + " " + user.getEmail() + " " + user.date;
        
    }

    public static void main(String[] args) throws Exception {
    	
        Server server = new Server(7080);
        Context context = new Context(server, "/", Context.SESSIONS);
        context.addServlet(MyServlet.class, "/communication-service");
        server.start();
        
    }
    
}
