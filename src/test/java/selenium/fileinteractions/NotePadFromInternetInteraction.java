package selenium.fileinteractions;

import java.io.*;
import java.net.URL;

public class NotePadFromInternetInteraction {
	
	public void getDataFromNotePadFromInternet() {
		try {
			
			String fileURL = "https://example-files.online-convert.com/document/txt/example.txt";
			String createnewfilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "notepad" + File.separator + "FileFromInternetCopy.txt";
			URL url = new URL(fileURL);

			InputStream inputstream = url.openStream();
			BufferedReader bufferreader = new BufferedReader(new InputStreamReader(inputstream));

			String line="";
			int linecount =0;
			
			File newfile = new File(createnewfilePath);
			FileWriter filewriter = new FileWriter(newfile);
			BufferedWriter bufferwriter = new BufferedWriter(filewriter);
			
			while( (line=bufferreader.readLine()) !=null ){
				linecount++;
				
				bufferwriter.write(line);
				bufferwriter.append(System.lineSeparator());
				
				if(linecount>10) {
					break;
				}
			}
			
			bufferreader.close();
			bufferwriter.close();
			
		} catch(Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	public static void main(String[] args) {
		NotePadFromInternetInteraction notepadobj = new NotePadFromInternetInteraction();
		notepadobj.getDataFromNotePadFromInternet();
	}

}