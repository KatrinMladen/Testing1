package helper;
import data.TestData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.Reader.readLogFile;


public class Helper {
    private Helper() {
    }
    //static List<TestData> dataList = readLogFile("src/main/java/data.log");
    public static Map<TestData, Integer> calculateData(List<TestData> dataList) {
        Map<TestData, Integer> map = new HashMap<>();

        dataList.forEach(data -> {
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
            /*if(map.containsKey(data.getId())){
                map.put(data.getId(), map.get(data.getId()) + 1);
            } else {
                map.put(data.getId(), 1);
            }*/
        });
        return map;
    }

        //System.out.println(map);
}
