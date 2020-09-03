package softplan;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import softplan.model.StarWarsCharactersModel;

public class StarWarsCharactersApplication {

    public static void main(String[] args) {

        try {

            // Get input from the user
            BufferedReader characterReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the Star Wars character: ");
            String characterName = characterReader.readLine();

            // Check for null, empty or blank input
            if (isNullOrEmptyOrBlank(characterName)) {
                System.out.println("The input cannot be left empty or blank!");
                return;

            } else {
                System.out.println("Star Wars character: " + characterName.toUpperCase());
            }

            URL url = new URL(StarWarsCharactersModel.getUrlAddress() + characterName);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed:: HTTP Error Code: " + connection.getResponseCode());
            }

            InputStreamReader input = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(input);

            String output;
            while ((output = bufferedReader.readLine()) != null) {

                JSONObject wholeJSONObject = new JSONObject(output);
                JSONArray results = wholeJSONObject.getJSONArray("results");

                // Total result
                int resultNumber = wholeJSONObject.getInt("count");
                System.out.println("\nFound " + resultNumber + " result(s) with the keyword " + "'" + characterName + "'" + "\n");

                for (int index = 0; index < results.length(); index++) {

                    JSONObject resultFromJSONArray = results.getJSONObject(index);

                    // StarWarsCharactersApplication Character Data
                    System.out.println("RESULT:\n");
                    String name = resultFromJSONArray.getString("name");
                    System.out.println("Name: " + name);
                    String height = resultFromJSONArray.getString("height");
                    System.out.println("Height: " + height);
                    String mass = resultFromJSONArray.getString("mass");
                    System.out.println("Mass: " + mass);
                    String hairColor = resultFromJSONArray.getString("hair_color");
                    System.out.println("Hair Color: " + hairColor);
                    String skinColor = resultFromJSONArray.getString("skin_color");
                    System.out.println("Skin Color: " + skinColor);
                    String eyeColor = resultFromJSONArray.getString("eye_color");
                    System.out.println("Eye Color: " + eyeColor);
                    String birthYear = resultFromJSONArray.getString("birth_year");
                    System.out.println("Birth Year: " + birthYear);
                    String gender = resultFromJSONArray.getString("gender");
                    System.out.println("Gender: " + gender);
                }
            }
            connection.disconnect();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static boolean isNullOrEmptyOrBlank(String characterName) {
        return characterName == null || characterName.isEmpty() || characterName.isBlank();
    }

}
