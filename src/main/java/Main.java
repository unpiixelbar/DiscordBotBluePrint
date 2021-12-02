import javax.security.auth.login.LoginException;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("config.txt");
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
                BufferedWriter br = new BufferedWriter(new FileWriter(file));
                //get token from https://discord.com/developers/applications
                br.write("token:");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
