import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/SearchServlet"})
public class SearchServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int employeeId = Integer.parseInt(request.getParameter("employeeId"));
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root", "root");
            PreparedStatement ps = con.prepareStatement("select * from employeetable where employee_id = ?");
            ps.setInt(1,employeeId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            out.println("Employee Id : "+rs.getInt(1));
            out.println("Employee Name : "+rs.getString(2));
            out.println("Employee Phone : "+rs.getString(3));
            out.println("Employee Address : "+rs.getString(4));
            }
            else{
                out.println("No Employee Found At Employee Id : "+employeeId);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
    }

}
