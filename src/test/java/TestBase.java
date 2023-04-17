import data.TestData;

import java.util.List;

import static utils.Reader.readLogFile;

public class TestBase {
    protected List<TestData> dataList;

    public void setup(){
        System.out.println("BeforeSuite");
        dataList = readLogFile("D:\\study\\Test\\src\\test\\resources\\data.log");
    }
}
