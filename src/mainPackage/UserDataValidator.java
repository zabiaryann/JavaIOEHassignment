package mainPackage;

import java.io.*;

public class UserDataValidator {
	public static void main(String[] args) {
		try {
	// Inside a try block, instantiate 3 separate objects: a 'reader' that reads the
	// data inside user_data.txt, a 'validWriter' for
	// writing to a file with all the valid data,
	// and an errorWriter for writing to a file with all the faulty data.
			BufferedReader reader = new BufferedReader(new FileReader("user_data.txt"));
			BufferedWriter validWriter = new BufferedWriter(new FileWriter("valid_data.txt"));
			BufferedWriter errorWriter = new BufferedWriter(new FileWriter("error_data.txt"));
			// Run a while loop that iterates through each line of the file


	// In another try / catch block (inside the while loop), do the following:
	// 1. Use the .split() method on the current line on "," so we can get an array
	// of the name, email, and age of each user
	// 2. If the length of the array is different than 3, we know something is wrong
	// so throw an exception with message "Missing Data"
	// 3. Save each piece of data in the array to its own variable, making sure to
	// trim them of whitespace with .trim() and casting them to the correct datatype
	// (Email + Name are strings, Age is int)
	// 4. If age is less than or equal to 0, throw an exception with message
	// "Invalid Age"
			String line;
			while ((line = reader.readLine()) != null) {
				try {
					String[] userData = line.split(",");
					if (userData.length != 3) {
						throw new Exception("Missing Data");
					}

					String name = userData[0].trim();
					String email = userData[1].trim();
					int age = Integer.parseInt(userData[2].trim());

					if (age <= 0) {
						throw new Exception("Invalid Age");
					}

					validWriter.write(line);
					validWriter.newLine();
				} catch (Exception e) {
					errorWriter.write(line + " - " + e.getMessage());
					errorWriter.newLine();
				}
			}

			reader.close();
			validWriter.close();
			errorWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
