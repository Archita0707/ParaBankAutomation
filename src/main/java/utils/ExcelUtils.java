package utils;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class ExcelUtils {

    public static Object[][] getSheetData(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            DataFormatter formatter = new DataFormatter();
            Object[][] data = new Object[rowCount][colCount];

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i + 1);
                for (int j = 0; j < colCount; j++) {
                    Cell cell = (row == null) ? null : row.getCell(j);
                    data[i][j] = formatter.formatCellValue(cell);
                }
            }
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }
}
