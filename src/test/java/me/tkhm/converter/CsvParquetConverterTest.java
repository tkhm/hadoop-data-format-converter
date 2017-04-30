package me.tkhm.converter;

import static org.junit.Assert.*;

import org.junit.Test;

public class CsvParquetConverterTest {

	@Test
	public void sampleTest() {
		String inputPath = "src/test/resources/me/tkhm/input/csv/test.csv";
		CsvParquetConverter converter = new CsvParquetConverter();

		// exercise
		converter.convert(inputPath);

		// verify
		fail();
	}
}
