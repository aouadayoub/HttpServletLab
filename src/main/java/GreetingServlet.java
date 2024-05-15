import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class GreetingServlet extends HttpServlet {
    private final String[] blacklist = {"EL harran", "Oussama", "ana"}; // Define your blacklist

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Check if the user has the "tomcat" role
        if (!request.isUserInRole("tomcat")) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "You don't have access to this resource.");
            return;
        }

        // Get the username from the request
        String username = request.getParameter("nom");
        
        // Check if the username is in the blacklist
        if (isInBlacklist(username)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access denied.");
            return;
        }

        // Proceed with the servlet logic
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
        String title = null;
        String nomPrenom = "Anonymous";

        if (username != null) {
            nomPrenom = username.toUpperCase();
        }

        title = "<H1>Greetings " + nomPrenom + "!</H1>\n";

        out.println(docType +
                "<HTML>\n" +
                "<HEAD><TITLE>Greetings Servlet</TITLE></HEAD>\n" +
                "<BODY BGCOLOR=\"#FDF5E6\">\n" +
                title); 

        // Database interaction (moved inside doGet())
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lottery", "root", "root")) {
            // Insert new user and winning amount
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (name, winning_amount) VALUES (?, ?)");
            stmt.setString(1, nomPrenom);
            stmt.setDouble(2, Math.random() * 10);
            stmt.executeUpdate();

            // Retrieve winning amount
            stmt = conn.prepareStatement("SELECT winning_amount FROM users WHERE name = ?");
            stmt.setString(1, nomPrenom);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double winningAmount = rs.getDouble("winning_amount");
                out.println("Vous avez gagne: " + winningAmount + " millions de dollars!");
            } 
        } catch (SQLException ex) {
            ex.printStackTrace(); // Handle exceptions appropriately
        }

        out.println("</BODY></HTML>");  
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // Delegate to doGet()
    }

    private boolean isInBlacklist(String username) {
        if (username == null) {
            return false; // If username is null, not in blacklist
        }
        for (String blacklistedName : blacklist) {
            if (blacklistedName.equals(username)) {
                return true; // Username found in blacklist
            }
        }
        return false; // Username not found in blacklist
    }
}
