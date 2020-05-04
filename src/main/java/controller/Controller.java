package controller;

import actions.ActionFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        try {
            ActionFactory.getInstance().getAction(req.getRequestURI()).execute(req, resp);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}