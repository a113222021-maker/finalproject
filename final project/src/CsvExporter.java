import java.io.BufferedWriter; // 匯入 BufferedWriter
import java.io.IOException; // 匯入 IOException
import java.nio.file.Files; // 匯入 Files
import java.nio.file.Path; // 匯入 Path
import java.util.List; // 匯入 List

public class CsvExporter { // 類別開始：CsvExporter

    public static void export(Path path, List<String[]> rows, String[] headers) throws IOException { // 方法：將 rows 與 headers 輸出到 path
        try (BufferedWriter bw = Files.newBufferedWriter(path)) { // 建立 BufferedWriter 並自動關閉
            if (headers != null && headers.length > 0) { // 如果 headers 不為 null 且有長度
                writeLine(bw, headers); // 寫入 header 行
            }
            for (String[] row : rows) { // 逐列處理 rows
                writeLine(bw, row); // 寫入該列
            }
        } // try-with-resources 結束，自動關閉 bw
    } // 方法結束

    private static void writeLine(BufferedWriter bw, String[] cols) throws IOException { // 方法：將欄位陣列寫成 CSV 行
        StringBuilder sb = new StringBuilder(); // 建立 StringBuilder 組合欄位
        for (int i = 0; i < cols.length; i++) { // 迴圈每個欄位
            if (i > 0) sb.append(','); // 若非第一欄，先加逗號
            sb.append(escape(cols[i])); // 加入轉義後的欄位值
        }
        bw.write(sb.toString()); // 寫入該行字串
        bw.newLine(); // 換行
    } // 方法結束

    private static String escape(String s) { // 方法：處理欄位內的雙引號與需要包引號的情境
        if (s == null) return ""; // 若為 null，回傳空字串
        String out = s.replace("\"", "\"\""); // 將 " 轉成 ""
        boolean needQuote = out.contains(",") || out.contains("\"") || out.contains("\n") || out.contains("\r"); // 判斷是否需包引號
        if (needQuote) out = "\"" + out + "\""; // 若需包，引號包起來
        return out; // 回傳處理後的欄位字串
    } // 方法結束
} // 類別結束
