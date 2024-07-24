package selenium.heirarchy;

public class RemoteDriverTest implements JavaScriptExecutorTest, WebDriverTest{

	@Override
	public void wd3() {
		System.out.println("overriden wd3");
	}

	@Override
	public void jse3() {
		System.out.println("overriden jse3");
	}
	
	public void rd1() {
		System.out.println("public rd1");
	}
	
	private void rd2() {
		System.out.println("public rd2");
	}
	
	public void rd3() {
		System.out.println("public rd3");
	}

}