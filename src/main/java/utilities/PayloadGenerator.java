package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PayloadGenerator {

	public String generatePayload(String fileName) throws IOException
	{
		String resourceFolder=new String("./APIAutomationWithCucumber/src/main/java/resources/");
		String filepath=resourceFolder+fileName;
		String payload=new String(Files.readAllBytes(Paths.get(filepath)));
		return payload;
	}
}
