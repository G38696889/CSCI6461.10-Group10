
import java.util.*;

import javax.tools.DocumentationTool.Location;

import Sample.InstructionWord;

import java.io.*;
import java.lang.*;
import java.lang.invoke.VarHandle;

public class FileHandler {
	private final String filePath = "E:\\Eclipse Workspace\\Sample\\InputFile.txt";
	public static File inputfile;

	public void LoadFile() throws FileNotFoundException {
		if (filePath == null || filePath.isEmpty()) {
			throw new FileNotFoundException("File path is null or empty.");
		}

		inputfile = new File(filePath);
		if (!inputfile.exists()) {
			throw new FileNotFoundException("File does not exist: " + filePath);
		}
	}

	public ArrayList<InstructionWord> ConvertTheFile() throws Exception {
		ArrayList<InstructionWord> instructionArrayList = new ArrayList<InstructionWord>();
		HexToBitConverter hexToBitConverter = HexToBitConverter.GetHexToBitConverterObj();
		String line = "";
		String[] lineArray;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(inputfile));
			String currentLine;
			while ((currentLine = bufferedReader.readLine()) != null) {
				line = currentLine;
				lineArray = line.split(" ");
				InstructionWord userInstructionWordLine;
				String location = hexToBitConverter.ReturnBitsFromHex(lineArray[0]);
				String address = hexToBitConverter.ReturnBitsFromHex(lineArray[1]);
				userInstructionWordLine = new InstructionWord(location, address);
				instructionArrayList.add(userInstructionWordLine);
			}
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			throw new IOException("Can't read the file");
		}

		return instructionArrayList;
	}
}
