import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Xip {
	private int id;
	private Medicine medicine;
	private Patient patient;
	private LocalDate date;
	
	//Constructors
	public Xip() {
		super();
	}

	public Xip(int id, Medicine medicine, Patient patient, LocalDate date) {
		super();
		this.id = id;
		this.medicine = medicine;
		this.patient = patient;
		this.date = date;
	}
	
	//Mètodes
	//load(int id): Carrega els atributs de la BBDD a l’objecte
	public void load(int id) {
		String query = "SELECT * FROM xip where id ='"+id+"';";
		BBDDFarmacia bd = new BBDDFarmacia();
		bd.conectar();
		ResultSet rs = bd.loadSelect(query);
		
		try {
	        if (rs.next()) { // Verifica si hi ha alguna fila el resultSet
	            this.setDate(rs.getDate("date").toLocalDate());
	            this.setId(rs.getInt("id"));
	            
				Patient paciente = new Patient();
				paciente.load(rs.getString("id_patient"));
				
				Medicine medicina = new Medicine();
				medicina.load(rs.getInt("id_medicine"));
	            
	            this.setMedicine(medicina);
	            this.setPatient(paciente);
	            
	        } else {
	            System.out.println("No se encontró ningún registro para el id del chip: " + id);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error en Xip.load: " + e.getMessage());
	    }
	}

	//Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
