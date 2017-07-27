package main;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.AddNewUser;
import servlets.AuthServlet;
import servlets.UpdateServlet;

public class Main {
    public static void main(String[] args) throws Exception {

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(new UpdateServlet()), "/update");
        contextHandler.addServlet(new ServletHolder(new AuthServlet()), "/auth");
        contextHandler.addServlet(new ServletHolder(new AddNewUser()), "/newUser");

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
