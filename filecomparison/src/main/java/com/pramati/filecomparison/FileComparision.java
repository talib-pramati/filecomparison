package com.pramati.filecomparison;

import java.util.Set;

public class FileComparision {

	public static void main(String args[]) {
		
		String firstSourceFilePath = "Files/File1.txt";
		String secondSourceFilepath = "Files/File2.txt";
		String outPutFilePath = "Files/result.text";//default path for output file
		
		if(args.length >2 && args[2] != null)
		{
			outPutFilePath = args[2];
		}

		FileManager fileManager = new FileManager();

		Set<String> contentOfFirstFile = fileManager.readFile(firstSourceFilePath);
		Set<String> contentOfSecondFile = fileManager.readFile(secondSourceFilepath);

		Set<String> partiallyMatchedData = fileManager.findPartiallyMatchedData(contentOfFirstFile,
				contentOfSecondFile);

		System.out.println("size = " + partiallyMatchedData.size());

		for (String str : partiallyMatchedData) {
			System.out.println(str);
		}

		fileManager.writeIntoTheFile(partiallyMatchedData,outPutFilePath);

	}

}
