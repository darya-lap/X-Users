package main;

import DAO.Factory;
import entity.Address;
import entity.Users;
import persistence.HibernateUtil;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {

        Users u = new Users("Vanya","Ivanov","vanka-vstanka","222","vanya@mail.ru","2015-05-05", new Date(),1);
        Address a = new Address(90210,"Belarus","Mohilew","Zadneprovie","Grishina");
        Factory.getInstance().getAddressDAO().updateZip(1,90220);

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
        HibernateUtil.getSessionFactory().close();
    }
}
