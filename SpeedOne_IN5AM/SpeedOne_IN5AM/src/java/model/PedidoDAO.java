
package model;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listar(){
        String sql = "Select * from Pedidos";
        List<Pedido> listaPedido = new ArrayList<>();
        try{
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
                while(rs.next()){
                    Pedido pd = new Pedido();
                    pd.setNumeroDePedido(rs.getInt(1));
                    pd.setFechaDePedido(rs.getDate(2));
                    pd.setTotalDelPedido(rs.getDouble(3));
                    pd.setFechaDeEnvio(rs.getDate(4));
                    pd.setCodigoFormaPago(rs.getInt(5));
                    pd.setCodigoCliente(rs.getInt(6));
                    pd.setCodigoEmpleado(rs.getInt(7));
                    listaPedido.add(pd);
                    
                }
        }catch(Exception e){
            e.printStackTrace();
        
        }
        return listaPedido;
    }
   
}   
