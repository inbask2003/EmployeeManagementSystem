


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;


@WebServlet(name = "AddServlet", urlPatterns = {"/AddServlet"})
public class AddServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        String employeeName = request.getParameter("employeeName");
        String employeePhone = request.getParameter("employeePhone");
        String employeeAddress = request.getParameter("employeeAddress");
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root", "root");
            PreparedStatement ps = con.prepareStatement("insert into employeetable values(?,?,?,?)");
            ps.setInt(1,employeeId);
            ps.setString(2,employeeName);
            ps.setString(3,employeePhone);
            ps.setString(4,employeeAddress);
            int rows = ps.executeUpdate();
            out.println(rows+" rows Affected");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
