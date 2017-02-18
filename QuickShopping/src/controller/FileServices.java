package controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileServices {

	public void saveToTXT(List<String> sortedProductList) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("sortedList.txt"))) {

			for (int i = 1 ; i <= sortedProductList.size() ; i++ )
			{
				bw.write(sortedProductList.get(i) +"\n");
			}
		// no need to close it.
			bw.close();
			System.out.println("Done");
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
