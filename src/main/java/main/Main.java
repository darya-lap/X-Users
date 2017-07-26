package main;

import DAO.Factory;

public class Main {
    public static void main(String[] args) throws Exception {


        System.out.println(Factory.getInstance().getUserDAO().getUsersById(1).getFirstname());

        /*ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        //contextHandler.addServlet(new ServletHolder(new GetScheduleServlet(sheetsService)), "/schedule");
        contextHandler.addServlet(new ServletHolder(new UpdateServlet()), "/update");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase("web");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[] {resourceHandler, contextHandler});

        Server server = new Server(8080);
        server.setHandler(handlers);

        server.join();
        server.start();*/
    }
}
