package in.ashokit;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import in.ashokit.dao.PlayerRepository;
import in.ashokit.dao.ProductRepository;
import in.ashokit.entity.Account;
import in.ashokit.entity.Player;
import in.ashokit.entity.Product;
import in.ashokit.service.AccountService;
import in.ashokit.service.EmployeeService;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

		PlayerRepository playerRepository = context.getBean(PlayerRepository.class);
		ProductRepository productRepository = context.getBean(ProductRepository.class);
		AccountService accountService = context.getBean(AccountService.class);
		EmployeeService employeeService = context.getBean(EmployeeService.class);
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

		System.out.println("Id :: " + playerRepository.findById(1));
		System.out.println();

		Iterable<Player> allById = playerRepository.findAllById(Arrays.asList(2, 3, 4));
		System.out.println("All By Id :: ");
		allById.forEach(SpringDataJpaApplication::printRecord);
		System.out.println();

		System.out.println("Count :: " + playerRepository.count());
		System.out.println();

		System.out.println("Find Id 1 :: " + playerRepository.existsById(1));
		System.out.println();

		System.out.println("Find By Player Name :: " + playerRepository.findByPlayerName("palyer"));
		System.out.println("Find Player player1 and player2 :: "
				+ playerRepository.findByPlayerNameIn(Arrays.asList("palyer1", "palyer2")));
		System.out.println(
				"Find Player player1 and 23 :: " + playerRepository.findByPlayerNameAndPlayerAge("palyer1", "23"));
		System.out.println("Find Player player2 and hyderabad2 :: "
				+ playerRepository.findByPlayerNameAndLocation("palyer2", "hyderabad2"));
		System.out.println(
				"Find Player player1 and 24 :: " + playerRepository.findByPlayerNameOrPlayerAge("palyer1", "24"));
		System.out.println("Find Player player2 and hyderabad2 :: "
				+ playerRepository.findByPlayerNameOrLocation("palyer2", "hyderabad3"));
		System.out.println();

		System.out.println("Find By Player PlayerAge :: " + playerRepository.findByPlayerAge("23"));
		System.out.println("Find By Player PlayerAge In 23, 24 :: "
				+ playerRepository.findByPlayerAgeIn(Arrays.asList("23", "24")));
		System.out.println(
				"Find By Player PlayerAge Between 23, 24 :: " + playerRepository.findByPlayerAgeBetween("23", "24"));
		System.out.println("Find By Player PlayerAge Before 23 :: " + playerRepository.findByPlayerAgeBefore("23"));
		System.out.println("Find By Player PlayerAge After 23 :: " + playerRepository.findByPlayerAgeAfter("23"));
		System.out.println("Find By Player PlayerAge player1 Or PlayerLocation hyderabad2 :: "
				+ playerRepository.findByPlayerAgeOrLocation("23", "hyderabad2"));
		System.out.println("Find By Player PlayerAge player1 And PlayerLocation hyderabad1 :: "
				+ playerRepository.findByPlayerAgeOrLocation("23", "hyderabad"));

		System.out.println();

		System.out.println("Find By Location :: " + playerRepository.findByLocation("hyderabad"));
		System.out
				.println("Find By Location Hyderabad :: " + playerRepository.findByLocationAllIgnoreCase("Hyderabad"));
		System.out.println(
				"Find By Location Hyderabad :: " + playerRepository.findByLocationAllIgnoringCase("Hyderabad"));
		System.out.println("Find By Location Containing :: " + playerRepository.findByLocationContaining("hyderabad2"));
		System.out.println("Find By Location Contains :: " + playerRepository.findByLocationContains("hyderabad2"));
		System.out.println("Find By Location Ending With bad :: " + playerRepository.findByLocationEndingWith("bad"));
		System.out.println("Find By Location  :: " + playerRepository.findByLocationContainsOrderByPlayerAge("bad"));
		System.out.println();

		System.out.println("Get All Player HQL : " + playerRepository.getAllPlayerHql());
		System.out.println();

		System.out.println("Get All Player SQL : " + playerRepository.getAllPlayerSql());
		System.out.println();

		System.out
				.println("Get All Player By Location HQL : " + playerRepository.getAllPlayerByLocationHql("hyderabad"));
		System.out.println();

		System.out
				.println("Get All Player By Location SQL : " + playerRepository.getAllPlayerByLocationSql("hyderabad"));
		System.out.println();

		System.out.println("Get All Player By Age And Location HQL : "
				+ playerRepository.getAllPlayerByAgeAndLocationHql("23", "hyderabad"));
		System.out.println();

		System.out.println("Get All Player By Age And Location SQL : "
				+ playerRepository.getAllPlayerByAgeAndLocationSql("23", "hyderabad"));
		System.out.println();

		// save Product

		/*
		 * Product p1 = new Product("p13",5.1); Product p2 = new Product("p14",3.2);
		 * Product p3 = new Product("p15",5.3); Product p4 = new Product("p16",6.4);
		 * productRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
		 * 
		 * System.out.println("All Product saved ...");
		 */

		// update Product
		/*
		 * Product p1 = new Product(1,"p3",2.3); Product p2 = new Product(2,"p4",2.4);
		 * productRepository.saveAll(Arrays.asList(p1,p2));
		 */
		List<Product> products = productRepository.findAll();

		products.forEach(System.out::println);

		List<Product> sortByPrice = productRepository.findAll(Sort.by("price").descending());
		sortByPrice.forEach(System.out::println);

		List<Product> sortByPriceAndId = productRepository.findAll(Sort.by("price", "id").descending());
		sortByPriceAndId.forEach(System.out::println);

		int pageNo = 2;
		int pageSize = 4;

		PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
		Page<Product> pageData = productRepository.findAll(pageRequest);
		System.out.println("get Page Size : " + pageData.getSize());
		System.out.println("Get Total Pages: " + pageData.getTotalPages());
		List<Product> content = pageData.getContent();
		content.forEach(System.out::println);

		Product p = new Product();
		p.setPrice(2.3);
		Example<Product> example = Example.of(p);
		List<Product> procductByEx = productRepository.findAll(example);
		procductByEx.forEach(System.out::println);

		/*
		 * System.out.println("-- Composite Primary Key -- ");
		 * accountService.saveAccount("bhanu", "saving", "Navi", 3333.3);
		 * accountService.saveAccount("Aatmaj", "current", "Hyd", 3233.3);
		 * accountService.saveAccount("Pavan", "salary", "Mumbai", 3433.3);
		 * accountService.saveAccount("kunal", "prf", "Bareli", 3353.3);
		 * accountService.saveAccount("Jyuti", "saving", "Mp", 3333.3);
		 * accountService.saveAccount("gopi", "saving", "Kn", 4533.3);
		 */
		Optional<Account> accOptional = accountService.getDataUsingPk(2, "bhanu", "saving");
		if (accOptional.isPresent()) {
			Account account = accOptional.get();
			System.out.println(account);
		}
		// accountService.deleteDataByPk(1, "bhanu", "saving");

		System.out.println("Accounts : ");
		List<Account> accounts = accountService.getAllData();
		accounts.forEach(System.out::println);

		try {
			accountService.transferAmmount(2, "bhanu", "saving", 3, "Aatmaj", "current", 500.0);
		} catch (Exception e) {
			System.out.println("not Able to tansfer ammout" + e);
		}

		/*
		 * employeeService.saveEmployee("Bhanu", "Khargone", LocalDate.of(1999, 10, 19),
		 * 1600000.0); employeeService.saveEmployee("Kunal", "Mumbai",
		 * LocalDate.of(2001, 7, 23), 1036000.0); employeeService.saveEmployee("Aatmaj",
		 * "Pune", LocalDate.of(1999, 9, 11), 1230000.0);
		 */
		
		employeeService.getAllEmployee();

	}

	private static void printRecord(Player p) {
		System.out.println(p);
	}

}
