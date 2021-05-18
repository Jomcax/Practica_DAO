package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonaDAO implements Validar{
    
    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    
    @Override
    public int validar(Persona per) {
        int r=0;
        String sql = "Select * from usuarios where usuario=? and password=?";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, per.getUsuario());
            ps.setString(2, per.getPassword());
            rs=ps.executeQuery();
            while(rs.next()){
                r=r+1;
                per.setUsuario(rs.getString("usuario"));
                per.setPassword(rs.getString("password"));
            }
            if(r==1){
                return 1;
            }else{
                return 0;
            }
        } catch (Exception e) {
            return 0;
        }
    }
    
}
