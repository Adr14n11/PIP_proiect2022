package url_read;


import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;

public class ReadFromWebTest {

	@Test
	public void testReadFromWeb() {
		String testUrl = Paths.get("teste/url_read",("mockTramvaieResponse.txt")).toUri().toString();
		String actual = "";
		
		try {
			actual =  ReadFromWeb.readFromWeb(testUrl);
		} catch (IOException e) {
			assertEquals(e.getMessage(), "");
		}
		
		String expected = "{\"vehicleName\":\"2203\",\"vehicleLat\":\"47.165348\",\"vehicleLong\":\"27.574108\",\"vehicleDate\":\"2022-05-22 22:29:45\"},{\"vehicleName\":\"2203\",\"vehicleLat\":\"47.165348\",\"vehicleLong\":\"27.574108\",\"vehicleDate\":\"2022-05-22 22:29:45\"}";
		assertEquals(actual, expected);
		
	}

}
