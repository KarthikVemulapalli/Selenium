package SeleniumHeirar;

public interface WebDriverTest {

	public default void wd1() {
		System.out.println("default - wd1");
	}
	
	public static void wd2() {
		System.out.println("static - wd2");
	}
	
	public void wd3();
	
	private void wd4() {
		System.out.println("private - wd4");
	}
	
}
