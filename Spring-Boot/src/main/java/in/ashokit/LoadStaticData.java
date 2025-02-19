package in.ashokit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadStaticData implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Loaded static data ...");
	}

}
