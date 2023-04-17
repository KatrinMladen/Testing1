import data.TestData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Reader;
import helper.Helper;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestLogMain extends TestBase{
    @BeforeMethod
    public void setup(){
        super.setup();
        System.out.println("BeforeMethod");
    }

    @Test
    public void testLogDuplicates() {
        Map<TestData, Integer> data = Helper.calculateData(super.dataList);

        for (Map.Entry<TestData, Integer> entry : data.entrySet()) {
            Assert.assertEquals((int)entry.getValue(), 1, "Repeated value!!!"+entry.getKey());
        }
    }


    }


