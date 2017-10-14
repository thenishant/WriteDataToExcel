
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CSV {

    public static void main(String args[]) throws IOException {
        CSVWriter csvWriter = null;
        try {
            //Create CSVWriter for writing to Employee.csv
            csvWriter = new CSVWriter(new FileWriter("Employee.csv",true));
            //row1
            long data = 15000000;
            for (long i = 0; i <= data; i++) {
                System.out.println(i);
                String[] row1 = new String[10];
                List<String[]> rows = new ArrayList<String[]>();
                rows.add(new String[]{"priceline"+i, "segment"+i, "bagB"+i});
                //Writing list of rows to the csv file
                csvWriter.writeAll(rows);
            }
        } catch (
                Exception ee)

        {
            ee.printStackTrace();
        } finally

        {
            try {
                //closing the writer
                csvWriter.close();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }
}

