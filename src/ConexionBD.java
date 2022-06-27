import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	private final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	private final String DB_URL="jdbc:mysql://localhost:3306/supermarket";
	private final String USER="root";
	private final String PASS="1088";
	
	Connection connection=null;
	Statement stmt=null;
	
	public void conectar() {
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Conectando a la base de datos...");
			connection=DriverManager.getConnection(DB_URL,USER,PASS);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void cerrarConexion() {
		try {
			System.out.println("Cerrando conexion....");
			stmt=connection.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	//metodo consultas
	
	public ResultSet consultar(String consulta) {
		try {
			System.out.println("Creando consulta....");
			stmt=connection.createStatement();
			
			ResultSet rs=stmt.executeQuery(consulta);
			System.out.println("consulta exitosa");
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	//metodo para update(delete,update,insert)
	
	public void realizarUpdate(String sql) {
		try {
			System.out.println("Actualizando base....");
			stmt=connection.createStatement();
			stmt.executeUpdate(sql);
			System.out.println("Base actualizada");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultSet rs=null;
		ConexionBD con=new ConexionBD();;
		con.conectar();
		rs=con.consultar("Select * from city;");
		
		try {
			while(rs.next()) {
				int poblacion=rs.getInt("Population");
				String nombreString=rs.getString("Name");
				String codigoPais=rs.getString("CountryCode");
				
				System.out.println(" Codigo Pais:"+codigoPais);
				System.out.print(" Nombre:"+nombreString);
				System.out.print(" Poblacion:"+poblacion);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		con.cerrarConexion();
		
		/*ConexionBd cn= new ConexionBd;
		
		try {
			
			System.out.println("Creando sentencia....");
			stmt=connection.createStatement();
			String sql="Select * from city;";
			ResultSet rs=stmt.executeQuery(sql);
			int c=0;
			while(rs.next()) {
				int poblacion=rs.getInt("Population");
				String nombreString=rs.getString("Name");
				String codigoPais=rs.getString("CountryCode");
				
				System.out.println(" Codigo Pais:"+codigoPais);
				System.out.print(" Nombre:"+nombreString);
				System.out.print(" Poblacion:"+poblacion);
				c++;
			}
			System.out.println("Cantidad de registros "+c);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			try {
				if(stmt!=null) {
					stmt.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
				
		
		}*/
		
	}
}
