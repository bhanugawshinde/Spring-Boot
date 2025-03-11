package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ashokit.dao.AccountRepository;
import in.ashokit.entity.Account;
import in.ashokit.primary_keies.AccountPK;

@Service
public class AccountService {
	private AccountRepository accountRepository;

	public AccountService(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	public boolean saveAccount(
			String hName,
			String accType,
			String branchName,
			Double minBal
	) {
		AccountPK pk = new AccountPK();
		pk.setAccType(accType);
		pk.setHolderName(hName);
		
		Account account = new Account();
		account.setAccPk(pk);
		account.setBranchName(branchName);
		account.setMinBal(minBal);
		
		accountRepository.save(account);
		return true;
	}
	
	public Optional<Account> getDataUsingPk(Integer accId, String hName, String accType) {
		AccountPK pk = new AccountPK();
		pk.setAccId(accId);
		pk.setHolderName(hName);
		pk.setAccType(accType);
		return accountRepository.findById(pk);
	}
	
	public void deleteDataByPk(Integer accId, String hName, String accType) {
		AccountPK pk = new AccountPK();
		pk.setAccId(accId);
		pk.setHolderName(hName);
		pk.setAccType(accType);
		
		accountRepository.deleteById(pk);
		System.out.println(pk+" Account deleted");
	}
	
	public List<Account> getAllData() {
		 return accountRepository.findAll();
	}
}
