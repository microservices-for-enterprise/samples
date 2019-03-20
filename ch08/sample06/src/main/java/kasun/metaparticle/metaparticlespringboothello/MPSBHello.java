package kasun.metaparticle.metaparticlespringboothello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import io.metaparticle.annotations.Package;
import io.metaparticle.annotations.Runtime;
import static io.metaparticle.Metaparticle.Containerize;


@SpringBootApplication
public class MPSBHello {

	// @Runtime annotation to supply the port(s) to expose.
	// execution environment to 'metaparticle' which will launch the service into the currently configured Kubernetes environment.
	//
    @Runtime(ports = {8080},
            replicas = 1,
            executor = "metaparticle",
			publicAddress = true
	)
	// @Package annotation that describes how to package the application.
    @Package(repository = "kasunindrasiri",
            jarFile = "target/metaparticle-spring-boot-hello-0.0.1-SNAPSHOT.jar",
            publish = true,
            verbose = true)
    public static void main(String[] args) {
        Containerize(() -> SpringApplication.run(MPSBHello.class, args));
    }
}

@RestController
class HelloController {

	@GetMapping("/")
	public String hello(HttpServletRequest request) {
		System.out.printf("[%s]%n", request.getRequestURL());
		return String.format("Hello containers [%s] from %s",
				request.getRequestURL(), System.getenv("HOSTNAME"));
	}
}