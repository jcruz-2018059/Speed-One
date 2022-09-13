
package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public Connection conexion;
    
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBSpeedOne?useSSL=false", "root", "alejandro");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("La conexion ha fallado: " + e);
        }
        return conexion;
    }
}
