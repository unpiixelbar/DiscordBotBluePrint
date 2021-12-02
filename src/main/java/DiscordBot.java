import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import javax.security.auth.login.LoginException;

public class DiscordBot extends ListenerAdapter {

    JDA jda;

    public DiscordBot(String token) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault(token);

        //to catch onReady
        builder.addEventListeners(this);

        jda = builder.build();
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        System.out.println("Bot "+jda.getSelfUser().getName()+" is ready");

        jda.addEventListener(new DemoEventlistener());
    }
}
