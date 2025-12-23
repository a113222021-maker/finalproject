// java
// 來源註解：由 decompiler 產生的註解保留，說明來源
// (powered by FernFlower decompiler) // 來源註解
import java.io.IOException; // 匯入 IOException 用於處理 I/O 錯誤
import java.nio.file.Path; // 匯入 Path 類別
import java.nio.file.Paths; // 匯入 Paths 工具類
import java.util.ArrayList; // 匯入 ArrayList 類別
import java.util.Collections; // 匯入 Collections 工具類
import java.util.LinkedHashSet; // 匯入 LinkedHashSet 類別
import java.util.List; // 匯入 List 介面
import java.util.Scanner; // 匯入 Scanner 類別
import java.util.Set; // 匯入 Set 介面

public class OnlineExamSystemMain { // 類別宣告：主程式入口
    public static void main(String[] args) { // 主方法：程式開始
        Exam exam = new Exam("OOP Online Exam"); // 建立考試物件並設定標題
        Question q1 = new SingleChoiceQuestion("Q1", "Java 是物件導向語言嗎？", (double)10.0F, "Yes"); // 建立單選題 Q1
        Question q2 = new MultipleChoiceQuestion("Q2", "以下哪些是 Java 的特性？", (double)20.0F, Set.of("OOP", "Platform Independent")); // 建立多選題 Q2
        Question q3 = new TrueFalseQuestion("Q3", "Java 支援多重繼承。", (double)10.0F, false); // 建立是非題 Q3
        Question q4 = new FillInBlankQuestion("Q4", "Java 的關鍵字，用來建立物件的是？", (double)10.0F, Set.of("new")); // 建立填空題 Q4
        Question q5 = new ShortAnswerQuestion("Q5", "請簡述什麼是多型（Polymorphism）？", (double)20.0F); // 建立簡答題 Q5
        exam.addQuestion(q1); // 把 Q1 加入考試
        exam.addQuestion(q2); // 把 Q2 加入考試
        exam.addQuestion(q3); // 把 Q3 加入考試
        exam.addQuestion(q4); // 把 Q4 加入考試
        exam.addQuestion(q5); // 把 Q5 加入考試
        List<Student> students = new ArrayList(); // 建立學生清單
        students.add(new Student("S001", "Alice")); // 新增學生 Alice
        students.add(new Student("S002", "Bob")); // 新增學生 Bob
        students.add(new Student("S003", "Carol")); // 新增學生 Carol
        students.add(new Student("S004", "David")); // 新增學生 David
        students.add(new Student("S005", "Eve")); // 新增學生 Eve
        Scanner scanner = new Scanner(System.in); // 建立 Scanner 讀取使用者輸入
        List<String[]> csvRows = new ArrayList(); // 建立 CSV 列資料清單
        String[] csvHeaders = new String[]{"Student ID", "Name", "Total Score"}; // CSV 標頭陣列

        for(int idx = 0; idx < students.size(); ++idx) { // 迴圈：對每位預設學生處理
            Student student = (Student)students.get(idx); // 取得當前學生
            ExamSession session = new ExamSession(exam, student); // 建立考試場次給該學生
            switch (idx) { // 根據索引模擬不同學生答案
                case 0: // 第一位學生的模擬答案
                    session.submitAnswer(q1, new ChoiceAnswer(Set.of("Yes"))); // 提交 Q1 答案
                    session.submitAnswer(q2, new ChoiceAnswer(Set.of("OOP", "Garbage Collection"))); // 提交 Q2 答案
                    session.submitAnswer(q3, new ChoiceAnswer(Set.of("false"))); // 提交 Q3 答案
                    session.submitAnswer(q4, new TextAnswer(" new ")); // 提交 Q4 答案（含空白）
                    session.submitAnswer(q5, new PendingAnswer()); // Q5 等待人工評分
                    break; // 跳出 switch
                case 1: // 第二位學生的模擬答案
                    session.submitAnswer(q1, new ChoiceAnswer(Set.of("No"))); // 提交 Q1 答案
                    session.submitAnswer(q2, new ChoiceAnswer(Set.of("OOP", "Platform Independent"))); // 提交 Q2 答案
                    session.submitAnswer(q3, new ChoiceAnswer(Set.of("false"))); // 提交 Q3 答案
                    session.submitAnswer(q4, new TextAnswer("new")); // 提交 Q4 答案
                    session.submitAnswer(q5, new TextAnswer("Polymorphism means objects can take many forms.")); // 提交 Q5 簡答
                    break; // 跳出 switch
                case 2: // 第三位學生的模擬答案
                    session.submitAnswer(q1, new ChoiceAnswer(Set.of("Yes"))); // 提交 Q1 答案
                    session.submitAnswer(q2, new ChoiceAnswer(Set.of("Platform Independent"))); // 提交 Q2 答案
                    session.submitAnswer(q3, new ChoiceAnswer(Set.of("true"))); // 提交 Q3 答案
                    session.submitAnswer(q4, new TextAnswer("create")); // 提交 Q4 答案
                    session.submitAnswer(q5, new PendingAnswer()); // Q5 等待人工評分
                case 3: // 第四位學生的 case（此處沒有提交答案）
                    break; // 跳出 switch
                case 4: // 第五位學生的模擬答案
                    session.submitAnswer(q1, new ChoiceAnswer(Set.of("Yes"))); // 提交 Q1 答案
                    session.submitAnswer(q2, new ChoiceAnswer(Set.of("OOP", "Platform Independent"))); // 提交 Q2 答案
                    session.submitAnswer(q3, new ChoiceAnswer(Set.of("false"))); // 提交 Q3 答案
                    session.submitAnswer(q4, new TextAnswer("new")); // 提交 Q4 答案
                    session.submitAnswer(q5, new TextAnswer("多型是同一介面不同實作的行為")); // 提交 Q5 中文答案
                    break; // 跳出 switch
                default: // 其他情況的預設答案
                    session.submitAnswer(q1, new ChoiceAnswer(Set.of("Yes"))); // 提交 Q1 答案
                    session.submitAnswer(q2, new ChoiceAnswer(Set.of("OOP"))); // 提交 Q2 答案
                    session.submitAnswer(q3, new ChoiceAnswer(Set.of("false"))); // 提交 Q3 答案
                    session.submitAnswer(q4, new TextAnswer("new")); // 提交 Q4 答案
                    session.submitAnswer(q5, new PendingAnswer()); // Q5 等待人工評分
            } // 結束 switch

            double totalScore = session.calculateScore(); // 計算總分
            GradeReport report = new GradeReport(student, totalScore); // 建立成績報告
            System.out.println("===== Exam Result ====="); // 印出分隔標頭
            System.out.println("\ud83c\udfebStudent ID: " + student.getId()); // 印出學生學號
            System.out.println("\ud83c\udf92Student: " + student.getName()); // 印出學生姓名
            System.out.println("\ud83d\udcafTotal Score: " + totalScore); // 印出總分
            System.out.println("================================"); // 印出分隔線
            System.out.println(report.getSummary()); // 印出成績摘要
            System.out.println(); // 空行
            csvRows.add(new String[]{student.getId(), student.getName(), String.format("%.2f", totalScore)}); // 把該學生成績加入 CSV 列
        } // 結束 for 迴圈

        System.out.print("是否要新增互動學生並讓其作答？(y/n)："); // 詢問是否新增互動學生
        String addChoice = scanner.nextLine().trim().toLowerCase(); // 讀取並處理輸入
        if (addChoice.equals("y") || addChoice.equals("yes")) { // 如果使用者選是
            System.out.print("要新增幾位互動學生？輸入數字："); // 詢問新增人數
            int addCount = 0; // 初始化新增計數

            try { // 嘗試解析輸入數字
                addCount = Integer.parseInt(scanner.nextLine().trim()); // 解析新增人數
            } catch (Exception var29) { // 解析失敗時處理
                addCount = 0; // 設為 0
            } // 結束 try-catch

            for(int i = 0; i < addCount; ++i) { // 迴圈：為每位互動學生進行作答
                System.out.println("---- 新增學生 " + (i + 1) + " ----"); // 印出新增學生標頭
                System.out.print("輸入學生學號 (ID)："); // 提示輸入 ID
                String id = scanner.nextLine().trim(); // 讀取 ID 並去除空白
                if (id.isEmpty()) { // 若 ID 為空
                    Object[] var10001 = new Object[]{i + 1}; // 建立格式化參數
                    id = "I" + String.format("%03d", var10001); // 建立預設 ID
                } // 結束 if

                System.out.print("輸入學生姓名 (Name)："); // 提示輸入姓名
                String name = scanner.nextLine().trim(); // 讀取姓名並去除空白
                if (name.isEmpty()) { // 若姓名為空
                    name = "InteractiveStudent" + (i + 1); // 使用預設姓名
                } // 結束 if

                Student s = new Student(id, name); // 建立互動學生物件
                ExamSession session = new ExamSession(exam, s); // 建立該學生的考試場次
                System.out.println("請為學生 " + name + " 作答 (輸入 p 表示待人工評分，留空代表略過)："); // 提示如何作答

                for(Question q : exam.getQuestions()) { // 迭代所有題目讓學生作答
                    System.out.println(); // 空行
                    String var45 = q.id; // 取得題目 id（原始 decompile 變數）
                    System.out.println(var45 + ": " + q.content + " (分數: " + q.getScore() + ")"); // 印出題目資訊
                    if (q instanceof SingleChoiceQuestion) { // 如果是單選題
                        System.out.print("[單選] 請輸入你的答案 (單一選項)："); // 提示輸入格式
                        String ans = scanner.nextLine().trim(); // 讀取答案
                        if (ans.equalsIgnoreCase("p")) { // 若輸入 p 表示待評分
                            session.submitAnswer(q, new PendingAnswer()); // 提交待評分
                        } else if (ans.isEmpty()) { // 若留空
                            session.submitAnswer(q, new ChoiceAnswer(Collections.emptySet())); // 提交空選
                        } else { // 一般答案
                            session.submitAnswer(q, new ChoiceAnswer(Set.of(ans))); // 提交答案
                        } // 結束 if-else
                    } else if (!(q instanceof MultipleChoiceQuestion)) { // 若不是多選題（且不是單選）
                        if (q instanceof TrueFalseQuestion) { // 如果是是非題
                            System.out.print("[是非] 請輸入 true/false (或 y/n)："); // 提示輸入格式
                            String line = scanner.nextLine().trim(); // 讀取輸入
                            if (line.equalsIgnoreCase("p")) { // 若輸入 p
                                session.submitAnswer(q, new PendingAnswer()); // 提交待評分
                            } else if (line.isEmpty()) { // 若留空
                                session.submitAnswer(q, new ChoiceAnswer(Collections.emptySet())); // 提交空選
                            } else { // 一般答案
                                session.submitAnswer(q, new ChoiceAnswer(Set.of(line))); // 提交答案
                            } // 結束 if-else
                        } else if (q instanceof FillInBlankQuestion) { // 如果是填空題
                            System.out.print("[填空] 請輸入答案："); // 提示輸入
                            String line = scanner.nextLine(); // 讀取輸入（保留空白）
                            if (line.trim().equalsIgnoreCase("p")) { // 若輸入 p
                                session.submitAnswer(q, new PendingAnswer()); // 提交待評分
                            } else if (line.trim().isEmpty()) { // 若留空
                                session.submitAnswer(q, new TextAnswer("")); // 提交空文字
                            } else { // 一般答案
                                session.submitAnswer(q, new TextAnswer(line)); // 提交答案
                            } // 結束 if-else
                        } else if (q instanceof ShortAnswerQuestion) { // 如果是簡答題
                            System.out.print("[簡答] 請輸入答案 (此類題目通常需人工評分)："); // 提示輸入
                            String line = scanner.nextLine(); // 讀取輸入
                            if (line.trim().equalsIgnoreCase("p")) { // 若輸入 p
                                session.submitAnswer(q, new PendingAnswer()); // 提交待評分
                            } else if (line.trim().isEmpty()) { // 若留空
                                session.submitAnswer(q, new TextAnswer("")); // 提交空文字
                            } else { // 一般答案
                                session.submitAnswer(q, new TextAnswer(line)); // 提交答案
                            } // 結束 if-else
                        } else { // 其他未知題型
                            System.out.print("[未知題型] 請輸入答案："); // 提示輸入
                            String line = scanner.nextLine(); // 讀取輸入
                            session.submitAnswer(q, new TextAnswer(line)); // 提交文字答案
                        } // 結束內部 if-else
                    } else { // 如果是多選題
                        System.out.print("[多選] 請輸入以逗號分隔的選項，例如: OOP,Platform Independent："); // 提示輸入格式
                        String line = scanner.nextLine().trim(); // 讀取輸入
                        if (line.equalsIgnoreCase("p")) { // 若輸入 p
                            session.submitAnswer(q, new PendingAnswer()); // 提交待評分
                        } else if (line.isEmpty()) { // 若留空
                            session.submitAnswer(q, new ChoiceAnswer(Collections.emptySet())); // 提交空選
                        } else { // 有輸入選項
                            String[] parts = line.split(","); // 以逗號分割
                            Set<String> set = new LinkedHashSet(); // 建立維持插入順序的集合

                            for(String p : parts) { // 迭代分割後的每個部分
                                String t = p.trim(); // 去除每個部分前後空白
                                if (!t.isEmpty()) { // 若不是空字串
                                    set.add(t); // 加入集合
                                } // 結束 if
                            } // 結束 for

                            session.submitAnswer(q, new ChoiceAnswer(set)); // 提交多選答案集合
                        } // 結束 if-else
                    } // 結束外層 if-else
                } // 結束題目迴圈

                double totalScore = session.calculateScore(); // 計算該互動學生總分
                GradeReport report = new GradeReport(s, totalScore); // 建立成績報告
                System.out.println("===== Exam Result ====="); // 印出分隔標頭
                System.out.println("\ud83c\udfebStudent ID: " + s.getId()); // 印出學生學號
                System.out.println("\ud83c\udf92Student: " + s.getName()); // 印出學生姓名
                System.out.println("\ud83d\udcafTotal Score: " + totalScore); // 印出總分
                System.out.println("================================"); // 印出分隔線
                System.out.println(report.getSummary()); // 印出成績摘要
                System.out.println(); // 空行
                csvRows.add(new String[]{s.getId(), s.getName(), String.format("%.2f", totalScore)}); // 把成績加入 CSV 列
            } // 結束新增學生 for
        } // 結束 if 新增互動學生

        System.out.print("是否要將所有學生成績匯出為 CSV？(y/n)："); // 詢問是否要匯出 CSV
        String exportChoice = scanner.nextLine().trim().toLowerCase(); // 讀取並處理輸入
        if (exportChoice.equals("y") || exportChoice.equals("yes")) { // 如果選是
            Path out = Paths.get("student_results.csv"); // 設定輸出檔案路徑

            try { // 嘗試匯出 CSV
                CsvExporter.export(out, csvRows, csvHeaders); // 呼叫匯出工具
                System.out.println("已匯出至: " + String.valueOf(out.toAbsolutePath())); // 印出匯出路徑
            } catch (IOException e) { // 匯出失敗時處理
                System.err.println("匯出失敗: " + e.getMessage()); // 印出錯誤訊息
            } // 結束 try-catch
        } // 結束 if 匯出

        scanner.close(); // 關閉 scanner 釋放資源
    } // 結束 main 方法
} // 結束類別
