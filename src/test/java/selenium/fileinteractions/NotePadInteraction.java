package selenium.fileinteractions;

import java.io.*;

public class NotePadInteraction {

	/* Read NotePad file from Local Machine */
	public void getDataFromNotePad() {
		try {
			String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "notepad" + File.separator + "SeleniumInfo.txt";
			String createnewfilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "notepad" + File.separator + "SeleniumInfoCopy.txt";

			FileReader filereader = new FileReader(filePath);
			BufferedReader bufferreader = new BufferedReader(filereader);

			String line = "";
			int linecount = 0;

			File newfile = new File(createnewfilePath);
			FileWriter filewriter = new FileWriter(newfile);
			BufferedWriter bufferwriter = new BufferedWriter(filewriter);

			while ((line = bufferreader.readLine()) != null) {
				linecount++;
				bufferwriter.write(line);
				bufferwriter.append(System.lineSeparator());

				if (linecount > 10) {
					break;
				}
			}

			bufferreader.close();
			bufferwriter.close();

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void main(String[] arguments) {
		NotePadInteraction notepadobj = new NotePadInteraction();
		notepadobj.getDataFromNotePad();
	}

}