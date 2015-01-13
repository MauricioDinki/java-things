package Logica;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String errorMessages = "";

        try {

            String signo = request.getParameter("operador");
            String primerTermino = request.getParameter("primerTermino");
            String segundoTermino = request.getParameter("segundoTermino");

            double a = Double.parseDouble(primerTermino);
            double b = Double.parseDouble(segundoTermino);
            double resultado = 0;

            if (signo.equals("suma")) {
                resultado = a + b;
            } else if (signo.equals("resta")) {
                resultado = a - b;
            } else if (signo.equals("multiplicacion")) {
                resultado = a * b;
            } else if ((signo.equals("division"))) {
                resultado = a / b;
            }
            
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Resultado</title>");      
                out.println("<link rel=\"stylesheet\" href=\"css/estilos.css\"/>");
                out.println("<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\"/>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class=\"container\">");
                out.println("<div class=\"row\">");
                out.println("<div class=\"col-md-6\">");
                out.println("<h1>El Resultado Es " + resultado + "</h1>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
                

        } catch (NullPointerException | IllegalArgumentException e) {
            errorMessages = e.getMessage();
        }
        
        /*request.setAttribute("", errorMessages);
        

        RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
        view.forward(request, response);*/
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
