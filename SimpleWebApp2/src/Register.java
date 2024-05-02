
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.*;
import java.io.IOException;
import java.io.PrintWriter;
import model.UserEntity;

@WebServlet(name = "/Register", urlPatterns = "/Register")

public class Register extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("name");
        String password = request.getParameter("pass");
        String email = request.getParameter("mail");


        if (UserEntity.isUserExists(username)) {
            out.println("Already exists.");
        } else {

            if (UserEntity.registerUser(username, password, email)) {

                response.sendRedirect("welcome.jsp");
            } else {
                out.println("Error.");
            }
        }
        out.close();
    }
}

