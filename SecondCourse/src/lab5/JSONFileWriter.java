package lab5;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONFileWriter {

	public static void jsonWriter(ArrayList<Sportsman> se) throws IOException {
		JSONArray employeeList = new JSONArray();
		for (Sportsman s : se) {
			if (s.getPol().equals("м")) {
				JSONObject employeeDetails = new JSONObject();
				employeeDetails.put("Дата рождения", s.getBd());
				employeeDetails.put("Год соревнования", s.getYear());
				employeeDetails.put("Награды", s.getAward());

				JSONObject employeeObject = new JSONObject();
				employeeObject.put(s.getName(), employeeDetails);

				employeeList.add(employeeObject);

			}

			try (FileWriter file = new FileWriter("jsonTest.json")) {

				file.write(employeeList.toJSONString());
				file.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
