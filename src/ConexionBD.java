import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
	static final String DB_URL="jdbc:mysql://localhost:3306/world";
	static final String USER="root";
	static final String PASS="1088";
	
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
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ConexionBd cn= new ConexionBd;
		
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
			
				try {
					if(connection!=null) {
					connection.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		
		}
		
	}
}
