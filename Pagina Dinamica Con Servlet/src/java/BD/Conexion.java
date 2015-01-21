package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    // Valores nesesarios para la conexion
    
    private String userBD;              //Usuario de la base
    private String passwordBD;          //Contraseña
    private String urlBD;               //URL de la base
    private String driverClassName;     //Driver nesesario, MySQL, Oracle, Maria, etc
    private Connection conexion = null; //Valor de la conexion
    private Statement estancia;         //Estancia

    /* En este Constructor Asentamos los valores de la coneccion, si queremos cambiar de base, 
    o de gestor de bases, debemos especificarlo aqui */

    public Conexion() {
   
        this.userBD = "root";
        this.passwordBD = "n0m3l0";
        this.urlBD = "jdbc:mysql://127.0.0.1:3306/cosas_de_java";
        this.driverClassName = "com.mysql.jdbc.Driver";
    }
    
    // En este Constructor recibimos los datos que especificamos arriba
    
    public Conexion(String userBD, String passwordBD, String urlBD, String driverClassName) {
        
        this.userBD = userBD;
        this.passwordBD = passwordBD;
        this.urlBD = urlBD;
        this.driverClassName = driverClassName;
    }
    
    // Metodos para establecer los valores de conexion a la base de datos
    
    public void setUsuarioBD(String usuario) throws SQLException {
        
        this.userBD = usuario;
    }
    
    public void setPassBD(String pass) throws SQLException {
        this.passwordBD = pass;
    } 
    
    public void setUrlBD(String url) throws SQLException {
        
        this.urlBD = url;
    }
    
    public void setConn(Connection conn) throws SQLException {
        
        this.conexion = conn;
    }
    
    public void setDriverClassName(String driverClassName) throws SQLException {
        
        this.driverClassName = driverClassName;
    }
    
    // Conexion a la base de datos
    
    public void conectarDB () throws SQLException {
        
        try {
            Class.forName(this.driverClassName).newInstance();
            this.conexion = DriverManager.getConnection(this.urlBD, this.userBD, this.passwordBD);
 
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }
    
    //Metodos para ejecutar sentencias SQL

    public ResultSet consulta(String consulta) throws SQLException {

        this.estancia = (Statement) conexion.createStatement();
        return this.estancia.executeQuery(consulta);
    } 

    public void actualizar(String actualiza) throws SQLException {

        this.estancia = (Statement) conexion.createStatement();
        estancia.executeUpdate(actualiza);
    }
     
    public ResultSet borrar(String borra) throws SQLException {
    	
        Statement st = (Statement) this.conexion.createStatement();
        return (ResultSet) st.executeQuery(borra);
    } 
    
    public int insertar(String inserta) throws SQLException {
    	
        Statement st = (Statement) this.conexion.createStatement();
        return st.executeUpdate(inserta);
    }
}