package taskivanitsyarest.view;


import org.hibernate.type.SerializationException;
import org.json.JSONException;
import org.json.JSONWriter;
import org.springframework.stereotype.Component;
import taskivanitsyarest.dao.entity.User;
import taskivanitsyarest.web.Response;
//import taskivanitsyarest.web.Response;

import java.io.Writer;

/**
 * Created by Администратор on 23.06.2016.
 */
@Component
public class JsonSerializer {

    public void serializeResponse(Response response, Writer writer) throws SerializationException {

        try {
            JSONWriter jsonWriter = new JSONWriter(writer);
            jsonWriter.object();
            jsonWriter.key("response").object();
            jsonWriter.key("users");
            jsonWriter.array();
            for (User user : response.getUsers()) {
                serializeUser(user, jsonWriter);
            }
            jsonWriter.endArray();

            jsonWriter.endObject();
            jsonWriter.endObject();
        } catch (JSONException e) {
            throw new SerializationException(null, e);
        }
    }

    private void serializeUser(User user, JSONWriter jsonWriter) {
        jsonWriter.object();
        serializeField("userName", user.getUsername(), jsonWriter);
        serializeField("password", user.getPassword(), jsonWriter);
        serializeField("isActive", user.getIsactive().toString(), jsonWriter);
        jsonWriter.endObject();


    }

    private void serializeField(String key, String value, JSONWriter jsonWriter) {
        if (key != null && value != null) {
            jsonWriter.key(key).value(value);
        }
    }
}
