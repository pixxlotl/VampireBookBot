import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
 
public class PermissionListener extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            // Execute admin - only commands
            event.getChannel().sendMessage("You are an administrator.").queue();
        } else {
            event.getChannel().sendMessage("You do not have the required permissions.").queue();
        }
    }
}
