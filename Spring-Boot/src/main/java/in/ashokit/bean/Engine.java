package in.ashokit.bean;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * Engine class for creating bean life cycle using annotation. 
 */
@Component
public class Engine {
	public Engine() {
		System.out.println("Engile :: Condtrucotor");
	}
	
	/**
	 * bean initialization method.
	 */
	@PostConstruct
	public void init() {
		System.out.println("Initializing Engile Class Bean...");
	}
	
	/**
	 * bean destroy method.
	 */
	@PreDestroy
	public void destroy() {
		System.out.println("Destory Engine Class Bean...");
	}
}
