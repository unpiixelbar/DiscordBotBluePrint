import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import okhttp3.EventListener;
import org.jetbrains.annotations.NotNull;

public class DemoEventlistener extends ListenerAdapter {
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        Message message = event.getMessage();
        if("hi".equals(message.getContentStripped())) {
            event.getChannel()
                    .sendMessage("hi "+ event.getAuthor().getName())
                    .queue(); //queue the message to be send
        }
    }
}
