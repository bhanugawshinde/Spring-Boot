package in.ashokit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
	
	//Player Name
	public List<Player> findByPlayerName(String pname);
	public List<Player> findByPlayerNameIn(List<String> names);
	public List<Player> findByPlayerNameAndPlayerAge(String pname, String age);
	public List<Player> findByPlayerNameAndLocation(String pname, String location);
	public List<Player> findByPlayerNameOrPlayerAge(String pname, String age);
	public List<Player> findByPlayerNameOrLocation(String pname, String location);
	
	//Player PlayerAge
	public List<Player> findByPlayerAge(String age);
	public List<Player> findByPlayerAgeIn(List<String> ages);
	public List<Player> findByPlayerAgeBetween(String startPlayerAge, String endPlayerAge);
	public List<Player> findByPlayerAgeBefore(String endPlayerAge);
	public List<Player> findByPlayerAgeAfter(String startPlayerAge);
	public List<Player> findByPlayerAgeOrLocation(String age, String location);
	public List<Player> findByPlayerAgeAndLocation(String age, String location);
	
	//Location
	public List<Player> findByLocation(String location);
	public List<Player> findByLocationAllIgnoreCase(String location);
	public List<Player> findByLocationAllIgnoringCase(String location);
	public List<Player> findByLocationContaining(String locations);
	public List<Player> findByLocationContains(String locations);
	public List<Player> findByLocationEndingWith(String EndWordOflocation);
	public List<Player> findByLocationEndsWith(String EndWordOflocation);
	public List<Player> findByLocationContainsOrderByPlayerAge(String location);

	@Query(value = "From Player")
	public List<Player> getAllPlayerHql();
	
	@Query(value = "select * From CRICKET_PLAYERS", nativeQuery = true)
	public List<Player> getAllPlayerSql();
	
	@Query(value = "From Player where location = :location")
	public List<Player> getAllPlayerByLocationHql(String location);
	
	@Query(value = "select * From CRICKET_PLAYERS where Location = :location", nativeQuery = true)
	public List<Player> getAllPlayerByLocationSql(String location);
	
	@Query(value = "From Player where playerAge = :age AND location = :location")
	public List<Player> getAllPlayerByAgeAndLocationHql(String age, String location);
	
	@Query(value = "select * From CRICKET_PLAYERS where Player_Age = :age AND Location = :location", nativeQuery = true)
	public List<Player> getAllPlayerByAgeAndLocationSql(String age, String location);
	
}
