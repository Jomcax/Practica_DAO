package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogDaoimpl extends Conexion implements BlogDAO{

    Connection con;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    @Override
    public void insert(Blog blog) throws Exception {
        try {
            con=cn.getConnection();
            String sql = "insert into posts (fecha,titulo,contenido) values (?,?,?)";
            ps=con.prepareStatement(sql);
            ps.setString(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            //ejecutar la consulta
            ps.executeQuery();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void update(Blog blog) throws Exception {
        try {
            con=cn.getConnection();
            String sql = "update posts set fecha=?, titulo=?, contenido=? where id=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.setInt(4, blog.getId());
            //ejecutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void delete(int id) throws Exception {
       try {
            con=cn.getConnection();
            String sql = "delete from posts where id=?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            //ejecutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Blog getById(int id) throws Exception {
       Blog avi = new Blog();
        try {
            con=cn.getConnection();
            
            String sql = "select * from posts where id = ?";
            ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()){
                avi.setId(rs.getInt("id"));
                avi.setFecha(rs.getString("fecha"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
            }
        } catch (Exception e) {
            throw e;
        }
        return avi;
    }

    @Override
    public List<Blog> getAll() throws Exception {
       List<Blog> lista = null;
        try {
            con=cn.getConnection();
            String sql = "select * from posts";
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<Blog>();
            while (rs.next()){
                Blog avi = new Blog();
                avi.setId(rs.getInt("id"));
                avi.setFecha(rs.getString("fecha"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setContenido(rs.getString("contenido"));
                
                //adicionar a la conexion
                lista.add(avi);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }
 }
