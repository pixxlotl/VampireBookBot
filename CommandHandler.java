import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
 
import java.util.HashMap;
import java.util.Map;
 
public class CommandHandler extends ListenerAdapter {
    private final Map<String, Command> commands = new HashMap<>();
 
    public CommandHandler() {
        commands.put("!ping", new PingCommand());
    }
 
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        String message = event.getMessage().getContentRaw();
        String[] parts = message.split(" ");
        String commandName = parts[0];
        if (commands.containsKey(commandName)) {
            commands.get(commandName).execute(event);
        }
    }
}
 
interface Command {
    void execute(MessageReceivedEvent event);
}
 
class PingCommand implements Command {
    @Override
    public void execute(MessageReceivedEvent event) {
        event.getChannel().sendMessage("Pong!").queue();
    }
}
