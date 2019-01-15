import java.io.PrintWriter;

import java.io.PrintWriter;
public class my_main {
    public static void main(String[] args) {
        String download_path="C:\\youtube_db_java";
        String url="https://www.youtube.com/watch?v=VW0pphKy46Q";
        String[] command =
                {
                        "cmd",
                };
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("cd \""+download_path+"\"");
            stdin.println(download_path+"\\youtube-dl "+url);
            stdin.close();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}