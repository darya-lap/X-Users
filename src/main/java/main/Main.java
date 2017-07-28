package main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(new UpdateServlet()), "/update");
        contextHandler.addServlet(new ServletHolder(new AuthServlet()), "/auth");
        contextHandler.addServlet(new ServletHolder(new AddNewUser()), "/newUser");
        contextHandler.addServlet(new ServletHolder(new SearchByEmail()), "/searchByEmail");
        contextHandler.addServlet(new ServletHolder(new SearchByBirth()), "/searchByBirth");
        contextHandler.addServlet(new ServletHolder(new SearchByName()), "/searchByName");
        contextHandler.addServlet(new ServletHolder(new GetCurUser()), "/getCurUser");
        contextHandler.addServlet(new ServletHolder(new EditUser()), "/editUser");
        contextHandler.addServlet(new ServletHolder(new Logout()), "/logout");
        //contextHandler.addFilter(new FilterHolder(new AdminFilter()),"/*", EnumSet.allOf(DispatcherType.class));
        //contextHandler.addFilter(new FilterHolder(new AdminFilter()),"/newUser.html*", EnumSet.allOf(DispatcherType.class));
        //contextHandler.addFilter(new FilterHolder(new AdminFilter()),"/newUser", EnumSet.allOf(DispatcherType.class));


        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("web");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {resourceHandler, contextHandler});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.join();
        server.start();

        //HibernateUtil.getSessionFactory().close();

    }
}
