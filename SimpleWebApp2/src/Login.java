import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "/Login", urlPatterns = "/Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");

        String url = "jdbc:mysql://localhost:3306/users";
        String dbUsername = "root";
        String dbPassword = "password";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, dbUsername, dbPassword);
            if (con != null) {
                System.out.println("Connected to the database test1");
            }
            PreparedStatement ps = con.prepareStatement("SELECT name, password, role FROM user WHERE name=? AND password=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getString("role").equals("admin")) {
                    response.sendRedirect("welcomeadmin.jsp");
                } else {
                    response.sendRedirect("welcomeuser.jsp");
                }
            } else {
                response.sendRedirect("error.jsp");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
