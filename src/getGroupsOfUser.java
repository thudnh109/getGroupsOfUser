
/**
 * Created by hoaithu on 19/03/2018.
 */

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.json.JsonObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class getGroupsOfUser {
    public static void main(String args[]) {
        String APP_ID = "902621729846201";
        String APP_SECRET = "f019adfefa20a61a6b119ef82c483284";
        FacebookClient.AccessToken accessToken = new DefaultFacebookClient().obtainAppAccessToken(APP_ID, APP_SECRET);
        FacebookClient client = new DefaultFacebookClient(accessToken.getAccessToken());
        System.out.println(accessToken.getAccessToken());
        try {
            FileReader reader = new FileReader("input.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String ids;
            while ((ids = bufferedReader.readLine()) != null) {
                System.out.println(ids);
                try {
                    JsonObject groups = client.fetchObject(ids,JsonObject.class,Parameter.with("fields","name"));
                    //JsonObject groups = client.fetchObject(ids,JsonObject.class,Parameter.with("fields","group"));

                    System.out.println(ids.toString() + groups);

                } catch (Exception e) {
                    System.out.println("notfound");
                }
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
