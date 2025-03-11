package in.ashokit.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Account;
import in.ashokit.primary_keies.AccountPK;

public interface AccountRepository extends JpaRepository<Account, AccountPK>{

}
