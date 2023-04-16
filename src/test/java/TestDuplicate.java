import org.junit.gen5.api.Assertions;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDuplicate {
    List<TestData> testDataList = SolutionTask.readLogFile("src/main/java/data.log");
    @Test
    void testDuplicateIds() {

        Map<TestData, Integer> map = new HashMap<>();
        // Then
        for (TestData data : testDataList) {
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }
        if(map.containsValue(2)){
        for (Map.Entry<TestData, Integer> entry : map.entrySet()) {
            //System.out.println(entry.getKey() + "/" + entry.getValue());
            if(entry.getValue() == 2) throw new AssertionError(entry.getKey()+ " Repeated value!!!");
        }
        }
    }
    }


