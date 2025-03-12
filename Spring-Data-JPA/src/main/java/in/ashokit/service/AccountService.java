package in.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.ashokit.dao.AccountRepository;
import in.ashokit.entity.Account;
import in.ashokit.primary_keies.AccountPK;
import jakarta.transaction.Transactional;

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
	
	@Transactional(rollbackOn = Exception.class)
	public boolean transferAmmount(
			Integer accId1, String hName1, String accType1,
			Integer accId2, String hName2, String accType2,
			Double amt
	) throws Exception {
		AccountPK pk1 = new AccountPK();
		pk1.setAccId(accId1);
		pk1.setAccType(accType1);
		pk1.setHolderName(hName1);
		
		Optional<Account> acc1 = accountRepository.findById(pk1);
		if(acc1.isPresent()) {
			Account account1 = acc1.get();
			Double minBal = account1.getMinBal();
			if(minBal>amt) {
				account1.setMinBal(minBal-amt);
				accountRepository.save(account1);
				AccountPK pk2 = new AccountPK();
				pk2.setAccId(accId2);
				pk2.setAccType(accType2);
				pk2.setHolderName(hName2);
				Optional<Account> acc2 = accountRepository.findById(pk2);
				if(acc2.isPresent()) {
					Account account2 = acc2.get();
					account2.setMinBal(minBal+amt);
					accountRepository.save(account2);
					System.out.println(amt+" Money Transfered to: "+hName2);
					return true;
				}else {
					throw new Exception("Account2 Data is not Present: "+accId2+", "+hName2+", "+accType2);
				}
			}else {
				throw new Exception("Balance is not enough : Balance="+minBal+ ", amount="+amt);
			}
		}else {
			
			throw new Exception("Account Data is not Present: "+accId1+", "+hName1+", "+accType1);
		}
	}
}
