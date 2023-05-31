

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class ServMedicines
 */
public class ServMedicines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServMedicines() {
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
		doctor.load(mail);
		
		boolean isLogged = doctor.isLogged(mail, session);
		
		if(isLogged) {
			String jsonString = null;
			JSONArray ja = new JSONArray();
			
			BBDDFarmacia bd = new BBDDFarmacia();
			bd.conectar();

			try {
				String query = "SELECT * FROM medicine";
				ResultSet rs = bd.loadSelect(query);
				Class.forName("org.json.JSONObject");
				
				while (rs.next()) {
					int medicineID = rs.getInt("id");
					String medicineName = rs.getString("name");
					float medicineTmax = rs.getFloat("tmax");
					float medicineTmin = rs.getFloat("tmin");
					
					Medicine medicine = new Medicine(medicineID, medicineName, medicineTmax, medicineTmin);
					JSONObject json = new JSONObject(medicine);
					ja.put(json);
				}
				
				jsonString = ja.toString();
				response.getWriter().append(jsonString);
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("Error al getCountry: "+e.getMessage());
			}
		}
	}



}
