package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Formulario_Dinamico", urlPatterns = {"/Formulario_Dinamico"})
public class Formulario_Dinamico extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String nombre = request.getParameter("nombrep");
            String aPaterno = request.getParameter("paternop");
            String aMaterno = request.getParameter("maternop");
            String edad = request.getParameter("edadp");
            String email = request.getParameter("emailp");


           if((nombre == null) || (email == null) || (edad==null) || (aMaterno==null) || (aPaterno == null)) {

                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Formulario Dinamico con Servlets</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Formulario</h1>");
                out.println("<form method='get' action='/Pagina_Dinamica_Con_Servlet/Formulario_Dinamico'>");
                out.print("Tu Nombre: ");
                out.println("<input type='text' name='nombrep'/>");
                out.print("Apellido Paterno: ");
                out.println("<input type='text' name='paternop'/>");
                out.print("Apellido Materno: ");
                out.println("<input type='text' name='maternop'/>");
                out.print("Tu Edad: ");
                out.println("<input type='text' name='edadp'/>");
                out.print("Tu Email: ");
                out.println("<input type='text' name='emailp'/>");
                out.println("<input type='submit' name='Registrar'/>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
            }
            else
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet PaginaDinamica</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("Nombre: " + nombre + "");
                out.println("Paterno: " + aPaterno + "");
                out.println("Materno: " + aMaterno + "");
                out.println("Edad: " + edad + "");
                out.println("Email: " + email + "");
                out.println("</body>");
                out.println("</html>");
            }
        }
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
