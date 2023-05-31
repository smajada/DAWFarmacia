

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class Release
 */
public class Release extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Release() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String mail = request.getParameter("mail");
        String session = request.getParameter("session");
        
        String idXip = request.getParameter("idXip");
        String stringMed = request.getParameter("idMed");
        String date = request.getParameter("date");
        String mailP = request.getParameter("mailP");
        
        Doctor doctor = new Doctor();
        doctor.load(mail);
        
        boolean isLogged = doctor.isLogged(mail, session);
        
        if (isLogged) {                
            BBDDFarmacia bd = new BBDDFarmacia();
            bd.conectar();
            
            String query = "SELECT * FROM medicine";
            ResultSet rs = bd.loadSelect(query);
            
            try {
                int idMed = 0;
                 
                while (rs.next()) { 
                    if (rs.getString("name").equals(stringMed)) {
                        idMed = rs.getInt("id");
                        break;
                    }
                }
                
                query = "INSERT INTO `xip`(`id`, `doctor_mail`, `id_medicine`, `id_patient`, `date`) VALUES ('"+idXip+"','"+doctor.mail+"','"+idMed+"','"+mailP+"','"+date+"')";
                bd.updateDoctor(query);
                
                response.getWriter().append("El xip " + idXip + " ha sido insertado correctamente");
            } catch (SQLException e) {
                System.out.println("Error en Release.doPost: " + e.getMessage());
        }
    }

		
		
				}

}
