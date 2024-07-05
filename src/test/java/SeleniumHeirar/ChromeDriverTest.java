package SeleniumHeirar;

public class ChromeDriverTest extends RemoteDriverTest {
	
	public void cd1() {
		System.out.println("public cd1");
	}
	
	private void cd2() {
		System.out.println("public cd2");
	}
	
	public void rd3() {
		System.out.println("overridden rd3");
	}
	
}