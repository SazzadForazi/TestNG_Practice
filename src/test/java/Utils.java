import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {
    public void saveData(String email,String password) throws IOException, ParseException {
        String fileName="./src/test/resources/customer.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONObject customerObj = new JSONObject();

        customerObj.put("email", email);
        customerObj.put("password", password);

        JSONArray jsonArray = (JSONArray) obj;
        jsonArray.add(customerObj);

        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();

    }
}
