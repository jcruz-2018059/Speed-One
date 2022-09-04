
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DetallePedidosDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    
    
    public List listar(){
        String sql = "select * from DetallePedidos";
        List <DetallePedidos> listaDetallePedidos = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                DetallePedidos dp = new DetallePedidos();
                dp.setCodigoDetallePedidos(rs.getInt(1));
                dp.setCantidad(rs.getString(2));
                dp.setPrecio(rs.getString(3));
                dp.setNumeroDePedido(rs.getInt(4));
                dp.setCodigoProducto(rs.getInt(5));
                listaDetallePedidos.add(dp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaDetallePedidos;
    }
    
}
