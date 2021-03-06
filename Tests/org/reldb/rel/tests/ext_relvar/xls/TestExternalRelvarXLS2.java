package org.reldb.rel.tests.ext_relvar.xls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.reldb.rel.tests.BaseOfTest;

public class TestExternalRelvarXLS2 extends BaseOfTest {
	
	private final String path = "test.xls";
	private File file = new File(path);

	private static void insert(int rowNum, HSSFSheet sheet, HSSFRow row, HSSFCell cell, int arg0, int arg1, int arg2) {
		row = sheet.createRow(rowNum);
        cell = row.createCell(0);
		cell.setCellValue(arg0);
		cell = row.createCell(1);
		cell.setCellValue(arg1);
		cell = row.createCell(2);
		cell.setCellValue(arg2);
	}
	
	@Before
	public void testXLS1() throws IOException {
        try (HSSFWorkbook workbook = new HSSFWorkbook()) {
	        HSSFSheet sheet = workbook.createSheet();
	        HSSFRow row = null;
	        HSSFCell cell = null;
	        row = sheet.createRow(0);
	        cell = row.createCell(0);
			cell.setCellValue("A");
			cell = row.createCell(1);
			cell.setCellValue("B");
			cell = row.createCell(2);
			cell.setCellValue("C");
			
			insert(1,sheet,row,cell,1,2,3);
			insert(2,sheet,row,cell,4,5,6);
			insert(3,sheet,row,cell,4,5,6);
			insert(4,sheet,row,cell,1,2,3);
			insert(5,sheet,row,cell,7,8,9);
			insert(6,sheet,row,cell,7,8,9);
			insert(7,sheet,row,cell,4,5,6);
	        
			try (FileOutputStream out = new FileOutputStream(file)) {
			    workbook.write(out);
			} catch (IOException e) {
				e.printStackTrace();
			}
        }

		String src = 
				"BEGIN;\n" +
						"var myvar external xls \"" + file.getAbsolutePath() + "\" dup_remove;" +
				"END;\n" +
				"true";
		testEquals("true", src);
	}
	
	@Test
	public void testXLS2() {
		String src = "myvar";		
		testEquals(	"RELATION {A CHARACTER, B CHARACTER, C CHARACTER} {" +
					"\n\tTUPLE {A \"1\", B \"2\", C \"3\"}," +
					"\n\tTUPLE {A \"4\", B \"5\", C \"6\"}," +
					"\n\tTUPLE {A \"7\", B \"8\", C \"9\"}\n}", src);
	}
	
	@After
	public void testXLS3() {
		String src = 
				"BEGIN;\n" +
						"drop var myvar;" +
				"END;\n" +
				"true";
		file.delete();
		testEquals("true", src);
	}
}
