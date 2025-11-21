import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
 
public class ErrorHandlingListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        try {
            // Your code here
        } catch (Exception e) {
            event.getChannel().sendMessage("An error occurred: " + e.getMessage()).queue();
        }
    }
}
