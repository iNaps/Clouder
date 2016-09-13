package database;
import org.apache.log4j.Logger;

public class Remover {

    private static Remover inst;
    private Remover(){}
    public static Remover getInst() {
        if (inst == null) {
            inst = new Remover();
        }
        return inst;
    }

    public boolean remove(String path) {
        String sql = "DELETE FROM files where filepath=\"" + path + '"';
        try {
            Connector.execute(sql);
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).error(e.getMessage());
            return false;
        }
    }
}
