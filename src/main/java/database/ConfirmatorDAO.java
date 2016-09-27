package database;

public interface ConfirmatorDAO {
    void addLink(String oldEmail, String newEmail, String md5);
    void getNewEmail(String md5);
    boolean updateMail(String oldEmail, String newEmail) ;
}
