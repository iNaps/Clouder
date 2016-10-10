package com.clouder.database;

import com.clouder.tools.Element;
import java.util.ArrayList;

public interface DataPullerDAO {
    boolean isLoginExist(String login);
    boolean isMailExist(String email);
    boolean isLinkCorrect(String link, int id);
    String getPassword(String email);
    boolean removeFile(String path, int id);
    boolean uploadFile(String fileName, String filePath, int id);
    ArrayList<Element> getFileList(int id);
    boolean isFileExist(String fileName, String filePath, int id);
}