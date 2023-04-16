import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolutionTask {

//    public static void main(String[] args) {
//        List<TestData> testDataList = readLogFile("src/main/java/data.log");
//
//        Map<TestData, Integer> map = new HashMap<>();
//
//        testDataList.forEach(data -> {
//            if(map.containsKey(data)) {
//                map.put(data, map.get(data) + 1);
//            } else {
//                map.put(data, 1);
//            }
//            /*if(map.containsKey(data.getId())){
//                map.put(data.getId(), map.get(data.getId()) + 1);
//            } else {
//                map.put(data.getId(), 1);
//            }*/
//        });
//
//        //System.out.println(map);
//
////        try {
////            checkData(map);
////        } catch (AssertionError error) {
////            System.out.println("Error message: "+error.getMessage());
////        }
////        for (int i=1;i<dataList.size()-1;i++){
////            if(dataList.get(i-1).equals(dataList.get(i))){
////                System.out.println();
////            }
////        }
//
//    }
//
////    public static void checkData(Map<TestData, Integer> data) throws AssertionError {
////        //if(data.containsValue(2)){
////        for (Map.Entry<TestData, Integer> entry : data.entrySet()) {
////            //System.out.println(entry.getKey() + "/" + entry.getValue());
////            if(entry.getValue() == 2) throw new AssertionError(entry.getKey()+ " Repeated value!!!");
////        }
////        //}
////    }

    public static List<TestData> readLogFile(String s){
        List<TestData> dataList = new ArrayList<>();
        try {
            File file = new File(s);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            String id;
            while ((line = bufferedReader.readLine()) != null) {
                String send;
                LocalDateTime date;
                String status = null;
                if (line.contains("TMobClient3:")) {
                    send = line.split("jsonrpc")[0].split("TMobClient3: ")[1].split(":")[0];
                    date = LocalDateTime.parse(line.split("INFO")[0].split("       ")[0], DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
                    if (send.equals("Send")) {
                        id = line.split("id")[1].split(":")[1].split(",")[0].replaceAll("\"", "");
                    } else {
                        id = line.split("} : HTTP")[0].replaceAll("\"", "").split(",id:")[1];
                        status = line.split("Response: ")[1].split(": \\{")[0];
                    }
                    TestData data = new TestData(send, id, date, status);
                    dataList.add(data);
                }

            }
            System.out.println(dataList);
            bufferedReader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return dataList;
    }
}
