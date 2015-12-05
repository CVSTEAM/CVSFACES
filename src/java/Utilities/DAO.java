package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {

    private Connection cn;

    public Connection getConnection() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void Conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cvs?user=root&password=zantiago808");
        } catch (Exception e) {
            throw e;
        }
    }

    public void Cerrar() throws Exception {
        try {
            if (cn != null) {
                if (cn.isClosed() == false) {
                    cn.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }

    }

}
