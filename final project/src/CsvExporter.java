// 中文註解：CsvExporter 提供簡單的 CSV 匯出功能，能將表頭與多列字串陣列寫入檔案，並處理必要的跳脫。
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvExporter {

    // 將 headers 與 rows 寫入指定路徑的 CSV 檔案
    public static void export(Path path, List<String[]> rows, String[] headers) throws IOException {
        try (BufferedWriter bw = Files.newBufferedWriter(path)) {
            if (headers != null && headers.length > 0) {
                writeLine(bw, headers);
            }
            for (String[] row : rows) {
                writeLine(bw, row);
            }
        }
    }

    // 將一列字串以逗號串接並寫入 BufferedWriter
    private static void writeLine(BufferedWriter bw, String[] cols) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cols.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(escape(cols[i]));
        }
        bw.write(sb.toString());
        bw.newLine();
    }

    // 處理字串內的雙引號與必要時加上雙引號包覆
    private static String escape(String s) {
        if (s == null) return "";
        String out = s.replace("\"", "\"\"");
        boolean needQuote = out.contains(",") || out.contains("\"") || out.contains("\n") || out.contains("\r");
        if (needQuote) out = "\"" + out + "\"";
        return out;
    }
}
