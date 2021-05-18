package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Blog;
import modelo.BlogDAO;
import modelo.BlogDaoimpl;

@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
            BlogDAO dao = new BlogDaoimpl();
            //revise el numero de id
            int id;
            //para gestionar registros
            Blog avi = new Blog();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch(action){
                case "add":
                    //nuevo registro
                    request.setAttribute("blog", avi);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "edit":
                    //editar un registro
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    request.setAttribute("blog", avi);
                    request.getRequestDispatcher("frmaviso.jsp").forward(request, response);
                    break;
                case "delete":
                    //eliminar un registro
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
                default:
                    //listar los registros
                    List<Blog> lista = dao.getAll();
                    request.setAttribute("blog", lista);
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       BlogDAO dao = new BlogDaoimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");
        String contenido = request.getParameter("contenido");
        
        
        Blog avi = new Blog();
        
        avi.setId(id);
        avi.setFecha(fecha);
        avi.setTitulo(titulo);
        avi.setContenido(contenido);
        
        if (id == 0){
            //nuevo registro
            try {
                dao.insert(avi);
                response.sendRedirect("Inicio");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }else{
            //edicion de registro
            try {
                dao.update(avi);
                response.sendRedirect("Inicio");
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        }
    }

}
