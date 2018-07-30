package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        Sandwich parsedSandwich =  new Sandwich();

        final String S_NAME = "name";
        final String S_MNAME = "mainName";

        final String S_AKAS = "alsoKnownAs";
        final String S_POORIGIN = "placeOfOrigin";

        final String S_DESCRIPTION = "description";

        final String S_IMAGE = "image";

        final String S_INGREDIENTS = "ingredients";

        try {
            JSONObject sandwichObject = new JSONObject(json);

            JSONObject name = sandwichObject.getJSONObject(S_NAME);

            parsedSandwich.setMainName(name.getString(S_MNAME));


            List<String> aString = new ArrayList<>();
            if (name.getJSONArray(S_AKAS) != null) {
                for (int i=0;i<name.getJSONArray(S_AKAS).length();i++){
                    aString.add(name.getJSONArray(S_AKAS).getString(i));
                }
            }

            parsedSandwich.setAlsoKnownAs(aString);

            parsedSandwich.setPlaceOfOrigin(sandwichObject.getString(S_POORIGIN));

            parsedSandwich.setDescription(sandwichObject.getString(S_DESCRIPTION));

            parsedSandwich.setImage(sandwichObject.getString(S_IMAGE));

            List<String> iString = new ArrayList<>();
            if (name.getJSONArray(S_INGREDIENTS) != null) {
                for (int i=0;i<name.getJSONArray(S_INGREDIENTS).length();i++){
                    iString.add(name.getJSONArray(S_INGREDIENTS).getString(i));
                }
            }

            parsedSandwich.setIngredients(iString);




        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parsedSandwich;
    }
}
