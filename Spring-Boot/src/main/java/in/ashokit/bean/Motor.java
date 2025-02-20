package in.ashokit.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * class for create bean life cycle using interface.
 */
@Component
public class Motor implements InitializingBean, DisposableBean {
	
	public Motor() {
		System.out.println("Motor :: Constructor");
	}
	
	/*
	 * method for initializing bean life cycle.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initializing bean");

	}

	/**
	 * method for destroy bean life cycle.
	 */
	@Override
	public void destroy() throws Exception {
		System.out.println("destory bean");
		
	}
}
