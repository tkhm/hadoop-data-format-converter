package me.tkhm.converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class CsvParquetConverter extends DataFormatConverter {

	private String delimiter = ",";

	public void convert(String path) {
		String line;
		int lineNumber = 0;

		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(Pattern.quote(delimiter));

				Arrays.stream(fields).forEach(field -> System.out.print(field));
				System.out.println();

				++lineNumber;
			}

			System.out.println(lineNumber + " rows");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read a file and return it as String. It read whole file to memory, so
	 * reading huge file is not intended.
	 * 
	 * @param path
	 *            Input path
	 * @return String of a file content.
	 * @throws IOException
	 *             File doesn't exist or can't read case.
	 */
	@SuppressWarnings("unused")
	private String readFile(String path) {
		StringBuilder stringBuilder = new StringBuilder();

		try (FileReader fr = new FileReader(path); BufferedReader br = new BufferedReader(fr)) {
			String line = null;
			String ls = System.getProperty("line.separator");

			while ((line = br.readLine()) != null) {
				stringBuilder.append(line);
				stringBuilder.append(ls);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return stringBuilder.toString();
	}
}
