package assets.LivingRoom;

import assets.component.Cella;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TabelloneDeserializer implements JsonDeserializer<Tabellone> {
    @Override
    public Tabellone deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!jsonElement.isJsonObject())
            return null;
        JsonObject jsonObject = (JsonObject) jsonElement;
        if (!jsonObject.has("mappa"))
            return null;
        else {

            Tabellone tabellone = new Tabellone();
            List<List<Integer>> mappa = jsonDeserializationContext.deserialize(jsonObject.get("mappa"), new TypeToken<List<List<Integer>>>() {
            }.getType());
            ArrayList<Cella> matrice;
            for (int i = 0; i < mappa.size(); i++) {
                matrice = new ArrayList<>();
                for (int j = 0; j < mappa.get(i).size(); j++) {
                    int accCella = mappa.get(i).get(j);
                    switch (accCella) {
                        case 0, 2, 3, 4: {
                            Cella cella = new Cella();
                            cella.setAccessibilitaCella(accCella);
                            matrice.add(cella);
                            break;
                        }
                    }
                }

                tabellone.getMappa().add(matrice);

            }

            return tabellone;
        }
    }
}
