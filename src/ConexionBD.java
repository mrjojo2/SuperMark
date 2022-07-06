import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class ConexionBD {
	//declaracion de variables
	private String JDBC_DRIVER;//"com.mysql.cj.jdbc.Driver";
	private String DB_URL;//"jdbc:mysql://localhost:3306/supermarket";
	private String USER;//"root";
	private String PASS;//"1088";
	
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	
	//Metodos Getters y Setters
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

	//constructor
	public ConexionBD(String jdbc_driver,String db_url,String user,String pass) {
		this.JDBC_DRIVER=jdbc_driver;
		this.DB_URL=db_url;
		this.USER=user;
		this.PASS=pass;
		
		this.connection=null;
		this.stmt=null;
		this.rs=null;
	}
	
	//Metodos
	//crea la coneccion
	public void conectar() {
		try {
			Class.forName(JDBC_DRIVER);
			//System.out.println("Conectando a la base de datos...");
			this.connection=DriverManager.getConnection(DB_URL,USER,PASS);
			this.stmt=this.connection.createStatement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//crea la conexion y retorna un booleano
	public boolean abrirConecion() {
		boolean rta=true;
		try {
			Class.forName(JDBC_DRIVER);
		}catch(Exception e){
			e.printStackTrace();
		}
		try {
			this.connection=DriverManager.getConnection(DB_URL,USER,PASS);
			this.stmt=this.connection.createStatement();
		} catch (Exception e) {
			// TODO: handle exception
			rta=false;
		}
		return rta;
	}
	//cierra la conexion
	public void cerrarConexion() {
		
		try {
			if(this.stmt!=null) {
				this.stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (this.connection!=null) {
				this.connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			if(this.rs!=null) {
				this.rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//metodo consultas
	//Realiza una consulta y retorna un resulset
	public ResultSet consultar(String consulta) {
		try {
			System.out.println("Creando consulta....");
			this.stmt=this.connection.createStatement();
			
			this.rs=this.stmt.executeQuery(consulta);
			System.out.println("consulta exitosa");
			return this.rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public String selectBD(String consulta) {
		String string="";
		try {
			this.rs=this.stmt.executeQuery(consulta);
			ResultSetMetaData rsmd=this.rs.getMetaData();
			while(this.rs.next()) {
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					switch(rsmd.getColumnType(i)) {
					case 12:
						string=string+rs.getString(i);
						break;
					case 4:
						string=string+rs.getInt(i);
						break;
					case 93:
						string=string+rs.getDate(i);
						break;
					case 8:
						string=string+rs.getDouble(i);
						break;
						
					case 3:
						string=string+rs.getDouble(i);
						break;
						default:
							System.out.println("Typo: "+rsmd.getColumnType(i));		
					}
					if(i<rsmd.getColumnCount()) {
						string=string+",";
					}			
				}
				string=string+";";
			}
		} catch (Exception e) {
			// TODO: handle exception
			string="";
		}
		return string;
	}
	
	//metodo para update(delete,update,insert)
	
	public boolean realizarUpdate(String sql) {
		try {
			//System.out.println("Actualizando base....");
			this.stmt=connection.createStatement();
			this.stmt.executeUpdate(sql);
			//System.out.println("Base actualizada");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	
	
		
}
