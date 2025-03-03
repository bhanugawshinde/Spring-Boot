package in.ashokit;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.dao.PlayerRepository;
import in.ashokit.entity.Player;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);
		
		PlayerRepository playerRepository = context.getBean(PlayerRepository.class);
		
		/*
		 * Player player = new Player(1, "palyer", "23", "hyderabad");
		 * 
		 * playerRepository.save(player);
		 * 
		 * Player player2 = new Player(2, "palyer2", "22", "hyderabad2"); Player player3
		 * = new Player(3, "palyer3", "23", "hyderabad3"); Player player4 = new
		 * Player(4, "palyer4", "24", "hyderabad4");
		 * 
		 * playerRepository.saveAll(Arrays.asList(player2,player3,player4));
		 */
		
		Iterable<Player> all = playerRepository.findAll();
		all.forEach(SpringDataJpaApplication::printRecord);
		System.out.println();
		
		System.out.println("Id :: "+playerRepository.findById(1));
		System.out.println();
		
		Iterable<Player> allById = playerRepository.findAllById(Arrays.asList(2,3,4));
		System.out.println("All By Id :: ");
		allById.forEach(SpringDataJpaApplication::printRecord);
		System.out.println();
		
		System.out.println("Count :: "+playerRepository.count());
		System.out.println();
		
		System.out.println("Find Id 1 :: "+playerRepository.existsById(1));
		System.out.println();
		
		System.out.println("Find By Player Name :: "+playerRepository.findByPlayerName("palyer"));
		System.out.println("Find Player player1 and player2 :: "+playerRepository.findByPlayerNameIn(Arrays.asList("palyer1","palyer2")));
		System.out.println("Find Player player1 and 23 :: "+playerRepository.findByPlayerNameAndPlayerAge("palyer1", "23"));
		System.out.println("Find Player player2 and hyderabad2 :: "+playerRepository.findByPlayerNameAndLocation("palyer2", "hyderabad2"));
		System.out.println("Find Player player1 and 24 :: "+playerRepository.findByPlayerNameOrPlayerAge("palyer1", "24"));
		System.out.println("Find Player player2 and hyderabad2 :: "+playerRepository.findByPlayerNameOrLocation("palyer2", "hyderabad3"));
		System.out.println();
			
		System.out.println("Find By Player PlayerAge :: "+playerRepository.findByPlayerAge("23"));
		System.out.println("Find By Player PlayerAge In 23, 24 :: "+playerRepository.findByPlayerAgeIn(Arrays.asList("23","24")));
		System.out.println("Find By Player PlayerAge Between 23, 24 :: "+playerRepository.findByPlayerAgeBetween("23","24"));
		System.out.println("Find By Player PlayerAge Before 23 :: "+playerRepository.findByPlayerAgeBefore("23"));
		System.out.println("Find By Player PlayerAge After 23 :: "+playerRepository.findByPlayerAgeAfter("23"));
		System.out.println("Find By Player PlayerAge player1 Or PlayerLocation hyderabad2 :: "+playerRepository.findByPlayerAgeOrLocation("23","hyderabad2"));
		System.out.println("Find By Player PlayerAge player1 And PlayerLocation hyderabad1 :: "+playerRepository.findByPlayerAgeOrLocation("23","hyderabad"));
		
		System.out.println();
		
		System.out.println("Find By Location :: "+playerRepository.findByLocation("hyderabad"));
		System.out.println("Find By Location Hyderabad :: "+playerRepository.findByLocationAllIgnoreCase("Hyderabad"));
		System.out.println("Find By Location Hyderabad :: "+playerRepository.findByLocationAllIgnoringCase("Hyderabad"));
		System.out.println("Find By Location Containing :: "+playerRepository.findByLocationContaining("hyderabad2"));
		System.out.println("Find By Location Contains :: "+playerRepository.findByLocationContains("hyderabad2"));
		System.out.println("Find By Location Ending With bad :: "+playerRepository.findByLocationEndingWith("bad"));
		System.out.println("Find By Location  :: "+playerRepository.findByLocationContainsOrderByPlayerAge("bad"));
		System.out.println();
    
    System.out.println("Get All Player HQL : "+playerRepository.getAllPlayerHql());
		System.out.println();
		
		System.out.println("Get All Player SQL : "+playerRepository.getAllPlayerSql());
		System.out.println();
		
		System.out.println("Get All Player By Location HQL : "+playerRepository.getAllPlayerByLocationHql("hyderabad"));
		System.out.println();
		
		System.out.println("Get All Player By Location SQL : "+playerRepository.getAllPlayerByLocationSql("hyderabad"));
		System.out.println();
		
		System.out.println("Get All Player By Age And Location HQL : "+playerRepository.getAllPlayerByAgeAndLocationHql("23", "hyderabad"));
		System.out.println();
		
		System.out.println("Get All Player By Age And Location SQL : "+playerRepository.getAllPlayerByAgeAndLocationSql( "23", "hyderabad"));
		System.out.println();
		
	}
	
	private static void printRecord(Player p) {
		System.out.println(p);
	}

}
