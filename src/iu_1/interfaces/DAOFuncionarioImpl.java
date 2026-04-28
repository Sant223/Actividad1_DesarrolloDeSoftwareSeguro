package iu_1.interfaces;

import iu_1.clases.Funcionario;
import iu_1.service.DbConnection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.time.LocalDate;
/**
 *
 * @author santi
 */
public class DAOFuncionarioImpl extends DbConnection implements DAOFuncionario {

    @Override
    public void registrar(Funcionario funcionario) throws Exception {
        try {
            this.connect();
            PreparedStatement st = this.connection.prepareStatement("INSERT  INTO funcionario(documento,nombres"
                    + ",apellidos,fecha_nacimiento,direccion,telefono,id_tipo_docu,id_estado_civil) VALUES(?,?,?,?,?,?,?,?)");
            
            st.setInt(1, funcionario.getDocumento());
            st.setString(2, funcionario.getNombres());
            st.setString(3, funcionario.getApellidos());
            st.setDate(4, Date.valueOf(funcionario.getFecha_nacimiento()));
            st.setString(5, funcionario.getDireccion());
            st.setString(6, funcionario.getTelefono());
            st.setInt(7, funcionario.getId_tipo_documento());
            st.setInt(8, funcionario.getId_estado_civil());
            
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Funcionario funcionario) throws Exception {
        try {
            this.connect();

            String sql = "UPDATE funcionario SET documento = ?,nombres = ?,apellidos = ?,"
                    + "fecha_nacimiento = ?,direccion = ?,telefono = ?,id_tipo_docu = ?,id_estado_civil = ? WHERE id= ?";

            PreparedStatement st = this.connection.prepareStatement(sql);
            st.setInt(1, funcionario.getDocumento());
            st.setString(2, funcionario.getNombres());
            st.setString(3, funcionario.getApellidos());
            st.setDate(4, Date.valueOf(funcionario.getFecha_nacimiento())); // si es LocalDate
            st.setString(5, funcionario.getDireccion());
            st.setString(6, funcionario.getTelefono());
            st.setInt(7, funcionario.getId_tipo_documento());
            st.setInt(8, funcionario.getId_estado_civil());
            st.setInt(9, funcionario.getId());
            
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Funcionario funcionario) throws Exception {
         try {
            this.connect();

            String sql = "DELETE FROM funcionario WHERE id = ?";
        
            PreparedStatement st = this.connection.prepareStatement(sql);
            
            st.setInt(1,funcionario.getId());
            
            
            int rowsAffected = st.executeUpdate();
            
            if (rowsAffected == 0){
                throw new Exception("No se encontró el funcionario con ID: " + funcionario.getId());
            }
        } catch (SQLException e) {
            throw new Exception("Error al eliminar el funcionario: " + e.getMessage());
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Funcionario> listar() throws Exception {
        List<Funcionario> lista = new ArrayList();
        try {
            this.connect();

            String sql = "SELECT * FROM funcionario";
        
            PreparedStatement st = this.connection.prepareStatement(sql);
            
            
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                Funcionario funcio = new Funcionario();
                funcio.setId(rs.getInt("id"));
                funcio.setDocumento(rs.getInt("documento"));
                funcio.setNombres(rs.getString("nombres"));
                funcio.setApellidos(rs.getString("apellidos"));
                funcio.setFecha_nacimiento(rs.getObject("fecha_nacimiento", LocalDate.class));
                funcio.setDireccion(rs.getString("direccion"));
                funcio.setTelefono(rs.getString("telefono"));
                funcio.setId_tipo_documento(rs.getInt("id_tipo_docu"));
                funcio.setId_estado_civil(rs.getInt("id_estado_civil"));
                
                lista.add(funcio);
            }
            
            rs.close();
            st.close();
     
        } catch (SQLException e) {
            throw new Exception("Error al obtener la lista de funcionarios: " + e.getMessage());
        } finally {
            this.cerrar();
        }
        return lista;
    }

}
