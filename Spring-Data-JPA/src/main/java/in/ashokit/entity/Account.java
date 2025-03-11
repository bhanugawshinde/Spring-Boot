package in.ashokit.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import in.ashokit.primary_keies.AccountPK;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "ACCOUNT")
public class Account {

	@EmbeddedId
	private AccountPK accPk;

	@Column(name = "BRANCH_NAME")
	private String branchName;
	
	@Column(name = "MINIMUN_BALANCE")
	private Double minBal;	
	
	@CreationTimestamp
	@Column(name = "CREATED_DATE", updatable = false)
	private LocalDate createdDate;
	
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE", insertable = false)
	private LocalDate updatedDate;
	
}
