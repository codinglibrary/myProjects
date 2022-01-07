package tacos;

import org.apache.catalina.Pipeline;
import org.apache.catalina.Valve;
import org.apache.catalina.authenticator.AuthenticatorBase;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.ApplicationFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.filter.OncePerRequestFilter;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {

		return "home";
	}
}
