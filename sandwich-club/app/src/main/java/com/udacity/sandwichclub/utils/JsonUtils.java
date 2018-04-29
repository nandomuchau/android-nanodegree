package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static final String JSON_NAME_KEY = "name";
    public static final String JSON_MAIN_NAME_KEY = "mainName";
    public static final String JSON_ALSO_KNOWN_AS_KEY = "alsoKnownAs";
    public static final String JSON_PLACE_OF_ORIGIN_KEY = "placeOfOrigin";
    public static final String JSON_DESCRIPTION_KEY = "description";
    public static final String JSON_IMAGE_KEY = "image";
    public static final String JSON_INGREDIENTS_KEY = "ingredients";

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject sandwichObject = new JSONObject(json);

            JSONObject nameObject = sandwichObject.optJSONObject(JSON_NAME_KEY);
            String mainName = nameObject.optString(JSON_MAIN_NAME_KEY);

            JSONArray alsoKnownAsArray = nameObject.optJSONArray(JSON_ALSO_KNOWN_AS_KEY);
            List<String> alsoKnownAs = new ArrayList<>();
            for(int i = 0; i < alsoKnownAsArray.length(); i++){
                alsoKnownAs.add(alsoKnownAsArray.optString(i));
            }

            String placeOfOrigin = sandwichObject.optString(JSON_PLACE_OF_ORIGIN_KEY);

            String description = sandwichObject.optString(JSON_DESCRIPTION_KEY);

            String image = sandwichObject.optString(JSON_IMAGE_KEY);

            JSONArray ingredientsArray = sandwichObject.optJSONArray(JSON_INGREDIENTS_KEY);
            List<String> ingredients = new ArrayList<>();
            for(int i = 0; i < ingredientsArray.length(); i++){
                ingredients.add(ingredientsArray.optString(i));
            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image,
                    ingredients);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
