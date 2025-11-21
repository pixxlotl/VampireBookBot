import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
 
import javax.security.auth.login.LoginException;
 
public class Main {
    public static void main(String[] args) throws LoginException {
        String token = "YOUR_DISCORD_BOT_TOKEN";
        JDA jda = JDABuilder.createDefault(token)
               .enableIntents(GatewayIntent.MESSAGE_CONTENT)
               .disableCache(CacheFlag.VOICE_STATE)
               .setActivity(Activity.playing("Java Bot"))
               .build();
     jda.addEventListener(new MessageListener());
    }
}
