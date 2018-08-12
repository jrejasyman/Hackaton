package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAO {

    private Connection cn;

    public void Conectar() throws Exception {

        try {
            String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
            String url = "jdbc:sqlserver://sql.jcondori.com;databaseName=ETransporte";
            String user = "root";
            String password = "root";

            Class.forName(Driver).newInstance();
            cn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la Conexion" + e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) throws Exception {
        DAO dao = new DAO();
        dao.Conectar();
        if (dao.getCn() != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("Error");
        }
    }

    public void Cerrar() throws SQLException {
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();

            }
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

}
