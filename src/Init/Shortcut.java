package Init;

import java.nio.file.LinkOption;
import net.jimmc.jshortcut.JShellLink;
import java.nio.file.Paths;
import src.main.Main;

/**
 * @author Adrien BUFFAT 
 */

public class Shortcut {
    JShellLink linkNotifs;
    JShellLink linkFiles;
    String NotifsPath;
    String AppPath;
    String FilesPath;
    

    public Shortcut() {
        try{
            linkNotifs = new JShellLink();
            NotifsPath = JShellLink.getDirectory("") + 
                    Paths.get("./").toRealPath(LinkOption.NOFOLLOW_LINKS) +
                    "\\lib\\Bdd_daemon.jar";
            linkFiles = new JShellLink();
            FilesPath = JShellLink.getDirectory("") + 
                    Main.PathApp;
            AppPath = JShellLink.getDirectory("") + 
                    Paths.get("./").toRealPath(LinkOption.NOFOLLOW_LINKS) +
                    "\\Paulinote.jar";
        } 
        catch (Exception ex) {
        }
    }

    public void createNotifsShortcut() {
        try {
            linkNotifs.setFolder(JShellLink.getDirectory("") + System.getProperty("user.home") + 
                    "\\AppData\\Roaming\\Microsoft\\Windows\\Start Menu\\Programs\\Startup");
            linkNotifs.setName("NotifsPTUT");
            linkNotifs.setPath(NotifsPath);
            linkNotifs.save();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void createFilesShortcut() {
        try {
            linkFiles.setFolder(JShellLink.getDirectory("") + System.getProperty("user.home") + 
                    "\\Desktop");
            linkFiles.setName("Fichier_Paulinote");
            linkFiles.setPath(FilesPath);
            linkFiles.save();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void createAppShortcut() {
        try {
            linkFiles.setFolder(JShellLink.getDirectory("") + System.getProperty("user.home") + 
                    "\\Desktop");
            linkFiles.setName("Paulinote");
            linkFiles.setPath(AppPath);
            linkFiles.save();
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String a[]) {
        Shortcut racc = new Shortcut();
        racc.createNotifsShortcut();
        racc.createAppShortcut();
        racc.createFilesShortcut();
    }
}