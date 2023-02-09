package HwTracker.model;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Arrays;
import java.util.List;
import java.io.File;

// JSON imports
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FileOperator {
	public String fileName;
	public JSONObject jsonObject;
	public Schedule schedule;

	// JSON declaration
	public HashMap<String,Object> dataMap;
	public JSONArray jsonArray;
	public List<JSONObject> arrayOfJsonObj;

	// Constructor
	public FileOperator() {
		fileName = "testFile.txt";
		schedule = new Schedule();

		// JSON initialization
		arrayOfJsonObj = new ArrayList<JSONObject>();
		dataMap = new HashMap<String,Object>();
		jsonObject = new JSONObject();
		jsonArray = new JSONArray();
	}











	public void ReadInputTextFile() throws IOException { 

		File file = new File(fileName);
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line = null;
		List<String> data;

		while((line = br.readLine()) != null) {

			// At each line, split the items
			data = Arrays.asList(line.split(","));

			// Create new assignment object
			Assignment newAssign = new Assignment(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4));

			// Append to list of assignments
			schedule.assignments.add(newAssign);

			// -- Testing purposes -- 
			System.out.println(newAssign.toString());
		}

		// Saves all assignments into json
		SaveToDisk(schedule.assignments);

		// Close the BufferedReader once done working with file
		br.close();
	}














	public void SaveToDisk(List<Assignment> assignments) {

		// Iterate over all assigments
		for (int i = 0; i < assignments.size(); i++) {
			Assignment assign = assignments.get(i);

			// Insert key-value pairs into json object
			dataMap.put("Course", assign.course);
			dataMap.put("Item description", assign.item);
			dataMap.put("Due date", assign.dueDate);

			jsonObject = new JSONObject(dataMap);
			arrayOfJsonObj.add(jsonObject);
    }

		// Add all JSONobjects into JSONarray
		jsonArray.addAll(arrayOfJsonObj);

		try {
			FileWriter file = new FileWriter("./data.json");
			file.write(jsonArray.toJSONString());
			file.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}

		// -- Testing purposes -- 
		// To show the JSONarray has been successfully created
		System.out.println("JSON file created: " + jsonArray);
	}
}
