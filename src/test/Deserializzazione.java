package test;

import assets.card.Card;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
//--- Lettura dei parametri dal json000
public class Deserializzazione implements JsonDeserializer<Card> {

    @Override
    public Card deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext ctx) throws JsonParseException {
        if(!jsonElement.isJsonObject())
            return null;
        JsonObject jsonObject = (JsonObject) jsonElement;
        if(!jsonObject.has("id"))
            return null;
        if(jsonObject.has("mappa")){
          /* JsonArray access =  jsonObject.get("mappa").getAsJsonArray();
           for()
               JsonArray check = access.get(i).getAsJsonArray();
                for()*/
            List<List<Integer>>array = ctx.deserialize(jsonObject.get("mappa"),new TypeToken<List<List<Integer>>>(){}.getType());
            array.get(0).get(0);
            array.get(0).set(0,2);
        }
        return null;

    }
}
