import org.json.JSONObject;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

/**
 * Created by Trenton on 3/18/2015.
 */
public class CategoryParser {
    private JSONObject object;

    /**
     *
     * @throws Exception
     */
    public CategoryParser() throws Exception
    {
        JSONParser parser = new JSONParser();
        object = (JSONObject) parser.parse(new FileReader("Resources/Data/FoodMenu.json"));
    }
}
