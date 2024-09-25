import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class Datenbank {
    Connection con;
    Statement statement;
    ResultSet result;
    public void starten() {
        if (con != null) {
            //Fehlerbehebung
            System.out.println("DOPPELT gestartet du Depp.");
            return;
        }
        String url = "jdbc:mysql://127.0.0.1:3306/bbq_arbeitszeit";
        String name = "root";
        String password = "";

        try {
            con = DriverManager.getConnection(url, name, password);
            statement = con.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "datenstarten fehler: " + e.toString());
        }
    }

    public void addmitarbeiter() throws SQLException {
        String query = "INSERT INTO mitarbeiter (vorname, nachname, email, passwort_hash, sprache, wochenstunden, gleitzeit_warnung_grenze) VALUES('JO', 'jojo', 'max.mustermann@bbq.com', 'hashed_passwort_1', 'DE', 40, 10.00);";
        statement.execute(query);
    }

    public void schliessen() {
        try {
            con.close();
            con = null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "datenschließen");
        }
    }



}
