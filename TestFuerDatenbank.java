public class TestFuerDatenbank {
    public static void main(String[] args) {
        Datenbank datenbank = new Datenbank();
        try {
            datenbank.starten();
            datenbank.addmitarbeiter();
            datenbank.schliessen();
        } catch (Exception e) {
        }
    }
}
