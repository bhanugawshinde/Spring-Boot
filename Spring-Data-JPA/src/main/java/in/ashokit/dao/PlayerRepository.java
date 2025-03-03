package in.ashokit.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.ashokit.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Integer> {

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
