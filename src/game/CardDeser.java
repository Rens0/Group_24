package game;

import card.Card;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardDeser implements JsonDeserializer<List<Card>> {
    @Override
    public List<Card> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if(!jsonElement.isJsonObject())
            return null;
        JsonObject jsonObject = (JsonObject) jsonElement;
        List<Card>cards;
        cards = Arrays.asList(jsonDeserializationContext.deserialize(jsonObject.get("list"),new TypeToken<Card[]>(){}.getType()));



            /*

            for(int i = 0; i < tabellone.mappa.size(); i++){

                for(int j = 0; j<tabellone.mappa.get(i).size();j++){
                    Cella accCella = tabellone.mappa.get(i).get(j);
                    System.out.print(accCella.access);

                }
                System.out.println();
            }*/


            return cards;

    }
}
