
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.*;



@WebServlet(name = "SelectAllServlet", urlPatterns = {"/SelectAllServlet"})
public class SelectAllServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem","root", "root");
            Statement ps = con.createStatement();
            String query = "select * from employeetable";
            ResultSet rs = ps.executeQuery(query);
            while(rs.next()){
                out.println("Employee Id : "+rs.getInt(1));
                out.println("Employee Name : "+rs.getString(2));
                out.println("Employee Phone : "+rs.getString(3));
                out.println("Employee Address : "+rs.getString(4));
                out.println("--------------------------------------------------");
                out.println();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
