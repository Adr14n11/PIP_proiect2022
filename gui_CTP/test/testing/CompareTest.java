package testing;
import org.junit.Assert;
import org.junit.Test;

import url_read.Compare;

public class CompareTest {

    @Test
    public void testStringCompare() throws Exception {
        int result = Compare.stringCompare("str1", "str2");
        Assert.assertEquals(0, result);
    }
}

