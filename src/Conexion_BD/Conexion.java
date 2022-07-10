package Conexion_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

	private String JDBC_DRIVER;
	private String DB_URL;
	private String USER;
	private String PASS;
	private Connection connection;
	private Statement stmt;
	private ResultSet rs;
	
	public Conexion (String jDBC_DRIVER, String dB_URL, String uSER, String pASS) {
		super();
		JDBC_DRIVER = jDBC_DRIVER;
		DB_URL = dB_URL;
		USER = uSER;
		PASS = pASS;
		this.connection=null;
		this.stmt=null;
		this.rs=null;
	}
	
	public boolean conectar() {
		boolean rta=true;
		
		try {
			Class.forName(this.JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			connection=DriverManager.getConnection(DB_URL,USER,PASS);
			this.stmt=this.connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rta=false;
		}
		
		return rta;
	}
	
	public String select(String query) {  // Metodo para traer datos
		
		String string="";
		
		try {
			this.rs=this.stmt.executeQuery(query);
			ResultSetMetaData rsmd=this.rs.getMetaData();
		
			while(rs.next()) {
					for(int i=1;i<=rsmd.getColumnCount();i++) {
						switch (rsmd.getColumnType(i)) {
							case 12: 
								string=string+rs.getString(i);
							break;
							case 4:
								string=string+rs.getInt(i);
							break;
							case 93:
								string=string+rs.getDate(i);
							break;
							case 3:
								string=string+rs.getDouble(i);
							break;
							case -5:
								string=string+rs.getInt(i);
							break;
							default:
								System.out.println("Tipo:"+rsmd.getColumnType(i));
						}
						if(i<rsmd.getColumnCount()) {
							string=string+",";
						}
					
				}
				string=string+";";	
			}
		} catch (SQLException e) {
			System.out.println("Error!!!!" + e);
			string="";
		}
		
		return string;
	}
	
	public boolean insert(String query) {     //  Metodo para insertar Datos
		boolean rta=true;
		
		try {
			this.stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error!!!" + e);
			rta=false;
		}
		
		return rta;
		
	}

	
	
	public boolean update(String query) {   // Metodo para modificar datos
		boolean rta=true;
		
		try {
			this.stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			rta=false;
		}
		
		return rta;
	}
	
	public boolean delete(String query) {    // metodo para borrar datos
		boolean rta=true;
		
		try {
			this.stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			rta=false;
		}
		
		return rta;
		
	}
	
	
	
	public boolean cerrar() {
		boolean rta=true;
		try {
			if(this.stmt!=null) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			rta=false;
		}
		
			try {
				if(this.connection!=null) {
				connection.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				rta=false;
			}

			
				try {
					if(this.rs!=null) {
						this.rs.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					rta=false;
				}
			
		
		return rta;
	}
	
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
	


}



	
	

