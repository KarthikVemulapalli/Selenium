package topics;

import net.lightbody.bmp.BrowserMobProxyServer;

public class BrowMobProxyServerUsage {

	/* This helps in bypassing values in UI through Network logs of DevTools */
	/* Later these functionalities are provided by Selenium after version 4 */
	
	BrowserMobProxyServer browproxyserv = new BrowserMobProxyServer();
	
	public void activateProxyServer() {
		
		browproxyserv.setTrustAllServers(true);
		
		browproxyserv.addRequestFilter((request, contents, messageInfo) -> {
			var method = request.getMethod().toString().toUpperCase();
			if (method.equals("POST") || method.contains("GET") || method.contains("PUT")) {
				String uri = request.getUri();
				if (uri.contains("authenticate") || uri.contains("refresh") || uri.contains("activateCard")) {
					request.headers().add("x-recaptcha", "<Latest PINGDOM Value>");
				}
				
				byte[] bodyBytes = contents.getBinaryContents();
				contents.setBinaryContents(bodyBytes);
				String bodyString = contents.getTextContents();
				contents.setTextContents(bodyString);
			}
			return null;
		});
		
	}
	
	public static void main(String[] args) {
		
	}

}