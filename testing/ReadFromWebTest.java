package url_read;


import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;

public class ReadFromWebTest {

	@Test
	public void testReadFromWeb() {
		String testUrl = Paths.get("testing/url_read",("mockTramvaieResponse.txt")).toUri().toString();
		String actual = "";
		
		try {
			actual =  ReadFromWeb.readFromWeb(testUrl);
		} catch (IOException e) {
			assertEquals(e.getMessage(), "");
		}
		
		String expected = "{\"vehicleName\":\"2203\",\"vehicleLat\":\"47.151978\",\"vehicleLong\":\"27.621511\",\"vehicleDate\":\"2022-05-24 18:38:16\"}"+",{\"vehicleName\":\"2203\",\"vehicleLat\":\"47.151978\",\"vehicleLong\":\"27.621511\",\"vehicleDate\":\"2022-05-24 18:38:16\"}";
		assertEquals(actual, expected);
		
	}

}