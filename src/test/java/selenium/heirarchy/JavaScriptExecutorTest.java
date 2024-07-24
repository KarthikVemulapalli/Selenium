package selenium.heirarchy;

public interface JavaScriptExecutorTest {

	
	public default void jse1() {
		System.out.println("default - jse1");
	}
	
	public static void jse2() {
		System.out.println("static - jse2");
	}
	
	public void jse3();
	
	private void jse4() {
		System.out.println("private - jse4");
	}
	
}
