package Dao;

import Model.PersonalModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonalDao extends DAO {

    public List<PersonalModel> listarA() throws Exception {
        this.Conectar();
        List<PersonalModel> lista;
        ResultSet rs;

        try {
            String sql = "SELECT * FROM Personal.DniPersonal, Personal.NomPersonal, Personal.ApePersonal,Personal.SexoPersonal, Personal.ProcedPersonal";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            PersonalModel model;
            while (rs.next()) {
                model = new PersonalModel();
                model.setDni(rs.getString("DniPersonal"));
                model.setNombre(rs.getString("NomPersonal"));
                model.setApellido(rs.getString("ApePersonal"));
                model.setSexo(rs.getString("SexoPersonal"));
                model.setProcedencia(rs.getString("ProcedPersonal"));
                lista.add(model);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void ingresar(PersonalModel model) throws Exception {
        this.Conectar();
        try {
            String sql = "insert into Personal(DniPersonal, NomPersonal, ApePersonal, SexoPersonal, ProcedPersonal)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, model.getDni());
            ps.setString(2, model.getNombre());
            ps.setString(3, model.getApellido());
            ps.setString(4, model.getSexo());
            ps.setString(5, model.getProcedencia());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void actualizar(PersonalModel Model) throws Exception {
        this.Conectar();
        try {
            String sql = "UPDATE Personal set DniPersonal, = ?, NomPersonal = ?, ApePersonal = ?, SexoPersonal = ?, ProcedPersonal = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getDni());
            ps.setString(2, Model.getNombre());
            ps.setString(3, Model.getApellido());
            ps.setString(4, Model.getSexo());
            ps.setString(5, Model.getProcedencia());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void eliminar(PersonalModel Model) throws Exception {
        this.Conectar();
        try {
            String sql = "UPDATE Personal set DniPersonal = 'I' where NomPersonal = ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }
}
