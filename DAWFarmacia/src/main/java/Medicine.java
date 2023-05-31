import java.sql.ResultSet;
import java.sql.SQLException;

public class Medicine {
	private int id;
	private String name;
	private float Tmax;
	private float Tmin;
	
	public Medicine() {
	}

	public Medicine(int id, String name, float tmax, float tmin) {
		this.id = id;
		this.name = name;
		Tmax = tmax;
		Tmin = tmin;
	}
	
	//Métodes

	public void load (int id) {
		String query = "SELECT * FROM medicine where id ="+id+";";
		BBDDFarmacia bd = new BBDDFarmacia();
		bd.conectar();
		ResultSet rs = bd.loadSelect(query);
		
		try {
	        if (rs.next()) { // Verifica si hi ha alguna fila el resultSet
	        	this.setId(rs.getInt("id"));
	            this.setName(rs.getString("name"));
	            this.setTmax(rs.getFloat("tmax"));
	            this.setTmin(rs.getFloat("tmin"));
	        } else {
	            System.out.println("No se encontró ningún registro para el id: " + id);
	        }
	    } catch (SQLException e) {
	        System.out.println("Error en Medicine.load: " + e.getMessage());
	    }
	}
	
	//Getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getTmax() {
		return Tmax;
	}

	public void setTmax(float tmax) {
		Tmax = tmax;
	}

	public float getTmin() {
		return Tmin;
	}

	public void setTmin(float tmin) {
		Tmin = tmin;
	}
	
}
