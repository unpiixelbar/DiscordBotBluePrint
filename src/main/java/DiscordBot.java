import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    public DiscordBot(String token) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.build();
    }
}
