package com.coforge.main.helper;

import com.coforge.main.entities.Entity;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Ecode","Ou","Name","Location","Service Line","Doj","Pa","Vbu","Project","Wfh","Ph no","Positive"};
    static String SHEET = "UserData";
    public static ByteArrayInputStream tutorialsToExcel(List<Entity> entities) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (Entity entity : entities) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(entity.getEcod());
                row.createCell(1).setCellValue(entity.getOu());
                row.createCell(2).setCellValue(entity.getName());
                row.createCell(3).setCellValue(entity.getLocation());
                row.createCell(4).setCellValue(entity.getService_line());
                row.createCell(5).setCellValue(entity.getDoj());
                row.createCell(6).setCellValue(entity.getPa());
                row.createCell(7).setCellValue(entity.getVbu());
                row.createCell(8).setCellValue(entity.getDetails().getProject());
                row.createCell(9).setCellValue(entity.getDetails().getLoc());
                row.createCell(10).setCellValue(entity.getDetails().getNumber());
                row.createCell(11).setCellValue(entity.getDetails().getPos());



            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }

}
