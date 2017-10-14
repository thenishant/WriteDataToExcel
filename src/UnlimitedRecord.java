import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVWriter;
public class UnlimitedRecord {
    public static void main(String args[]) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter("Employee.csv", true));
        for (long i = 0; i <= 15000000; i++) {
            List<String[]> rows = new ArrayList<String[]>();
            //data to enter in coloumn seperated by comma
            rows.add(new String[]{"priceline" + i, "segment" + i, "bagB" + i});
            csvWriter.writeAll(rows);
            csvWriter.close();
        }
    }
}