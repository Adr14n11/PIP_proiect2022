package url_read;

import org.junit.Assert;
import org.junit.Test;

public class ReadFromWebTest {

    @Test
    public void testReadFromWeb() throws Exception {
        java.lang.String result = ReadFromWeb.readFromWeb("webURL");
        Assert.assertEquals("replaceMeWithExpectedResult", result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme