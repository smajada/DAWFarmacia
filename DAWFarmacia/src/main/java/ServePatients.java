

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;

/**
 *  implementation class ServePatients
 */
public class ServePatients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServePatients() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail = request.getParameter("mail");
		String session = request.getParameter("session");
		
		Doctor doctor = new Doctor();
		boolean isLogged = doctor.isLogged(mail, session);
		
		if(isLogged) {
			doctor.load(mail);
			
			String jsonString = null;
			JSONArray ja = new JSONArray();
			
			try {
				String query = "SELECT * FROM patient;";
				BBDDFarmacia bd = new BBDDFarmacia();
				bd.conectar();
				ResultSet rs = bd.loadSelect(query);
				
		        while (rs.next()) { 

		        	String patientMail = rs.getString("mail");
		        	ja.put(patientMail);
		        }
		        
		        jsonString = ja.toString();
		    } catch (SQLException e) {
		        System.out.println("Error en ServePatients.doGet: " + e.getMessage());
		    }
			
			
			response.getWriter().append(jsonString);
			
			
		} else {
			System.out.println("El usuario no está loggeado");
		}
	}


}
