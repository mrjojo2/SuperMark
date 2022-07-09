package SupermarK;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {
	private String JDBC_DRIVER;//"com.mysql.cj.jdbc.Driver";
	private String DB_URL;//"jdbc:mysql://localhost:3306/supermark";
	private String USER;//"root";
	private String PASS;//"jochis";
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	
	
	public String getJDBC_DRIVER() {
		return JDBC_DRIVER;
	}

	public void setJDBC_DRIVER(String jDBC_DRIVER) {
		JDBC_DRIVER = jDBC_DRIVER;
	}

	public String getDB_URL() {
		return DB_URL;
	}

	public void setDB_URL(String dB_URL) {
		DB_URL = dB_URL;
	}

	public String getUSER() {
		return USER;
	}

	public void setUSER(String uSER) {
		USER = uSER;
	}

	public String getPASS() {
		return PASS;
	}

	public void setPASS(String pASS) {
		PASS = pASS;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStmt() {
		return stmt;
	}

	public void setStmt(Statement stmt) {
		this.stmt = stmt;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public ConexionBD (String jDBC_DRIVER, String dB_URL, String uSER, String pASS) {
		super();
		JDBC_DRIVER = jDBC_DRIVER;
		DB_URL = dB_URL;
		USER = uSER;
		PASS = pASS;
		this.connection=null;
		this.stmt=null;
		this.rs=null;
	}
	
	
	
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
		try {
			if(stmt!=null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(rs!=null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//metodo consultas
	
	public ResultSet consultar(String consulta) {
		try {
			System.out.println("Creando consulta....");
			stmt=connection.createStatement();
			
			rs=stmt.executeQuery(consulta);
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
		
		ConexionBD con=new ConexionBD("com.mysql.cj.jdbc.Driver","jdbc:mysql://localhost:3306/supermarket","root","1088");
		con.conectar();
		ResultSet registros=con.consultar("Select * from city;");
		
		try {
			while(registros.next()) {
				int poblacion=registros.getInt("Population");
				String nombreString=registros.getString("Name");
				String codigoPais=registros.getString("CountryCode");
				
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
