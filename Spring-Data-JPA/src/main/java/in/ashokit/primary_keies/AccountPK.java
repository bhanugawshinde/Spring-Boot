package in.ashokit.primary_keies;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class AccountPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ACCOUNT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer accId;
	
	@Column(name = "ACCOUNT_TYPE")
	private String accType;
	
	@Column(name = "HOLDER_NAME")
	private String holderName;
	

}
