import javax.security.auth.login.LoginException;
import java.io.*;

public class Main {

    static final String dataPath = "data";

    public static void main(String[] args) {
        File file = new File(dataPath+"/config.txt");
        if (file.exists()) {

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                for (String line; (line = br.readLine()) != null; ) {
                    if (line.startsWith("token:")) {
                        String token = line.split(":", -1)[1];
                        new DiscordBot(token);
                    }
                }

            } catch (LoginException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                File dataDir = file.getParentFile();
                if(!dataDir.exists()){
                    dataDir.mkdir();
                }
                file.createNewFile();
                BufferedWriter br = new BufferedWriter(new FileWriter(file));
                //get token from https://discord.com/developers/applications
                br.write("token:");

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
