import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hpsf.HPSFException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Main {
    public static void main(String[] args) throws HPSFException {

        ArrayList data = new ArrayList();
        ArrayList headers = new ArrayList();

        File file123 = new File("sample.csv");

        headers.add("PRICELINE_CODE");
        headers.add("SEGMENT_CODE");
        headers.add("TYPE");

        for (long i = 1; i <= 15000000; i++) {
            ArrayList cells = new ArrayList();
            cells.add("priceline" + i);
            cells.add("segment" + i);
            cells.add("bag" + i);
            data.add(cells);
        }

        exportToExcel("Test", headers, data, file123);
    }

    public static void exportToExcel(String sheetName, ArrayList headers,
                                     ArrayList data, File outputFile) throws HPSFException {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);

        long rowIdx = 0;
        long cellIdx = 0;

        // Header
        HSSFRow hssfHeader = sheet.createRow(Math.toIntExact(rowIdx));
        HSSFCellStyle cellStyle = wb.createCellStyle();
        for (Iterator cells = headers.iterator(); cells.hasNext(); ) {
            HSSFCell hssfCell = hssfHeader.createCell(Math.toIntExact(cellIdx++));
            hssfCell.setCellStyle(cellStyle);
            hssfCell.setCellValue((String) cells.next());
        }
        // Data
        rowIdx = 1;
        for (Iterator rows = data.iterator(); rows.hasNext(); ) {
            ArrayList row = (ArrayList) rows.next();
            HSSFRow hssfRow = sheet.createRow(Math.toIntExact(rowIdx++));
            cellIdx = 0;
            for (Iterator cells = row.iterator(); cells.hasNext(); ) {
                HSSFCell hssfCell = hssfRow.createCell(Math.toIntExact(cellIdx++));
                hssfCell.setCellValue((String) cells.next());
            }
        }

        // wb.setSheetName(0, sheetName, HSSFWorkbook.ENCODING_COMPRESSED_UNICODE);
        try {
            FileOutputStream outs = new FileOutputStream(outputFile);
            wb.write(outs);
            outs.close();
        } catch (IOException e) {
            throw new HPSFException(e.getMessage());
        }

    }
}