
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;



@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeePhone = request.getParameter("employeePhone");
        String employeeAddress = request.getParameter("employeeAddress");
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root", "root");
            PreparedStatement ps = con.prepareStatement("update employeetable set employee_phone = ?,employee_address = ? where employee_id = ?");
            ps.setInt(3, employeeId);
            ps.setString(1, employeePhone);
            ps.setString(2,employeeAddress);
            int rows = ps.executeUpdate();
            out.println(rows+" rows Affected");
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
