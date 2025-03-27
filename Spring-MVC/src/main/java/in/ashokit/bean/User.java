package in.ashokit.bean;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@NotEmpty(message = "User id not Empty")
	private String userId;
	
	@NotEmpty(message = "User name not Empty")
	@Size(min=3, message="Minimum 3 character required in name")
	String userName;
	
	@NotNull(message = "Age must not Empty or String ")
	@Min(value=18, message="Minimum age is 18")
	@Max(value = 100 , message="Maximum age is 100")
	Integer userAge;
	
	@NotEmpty(message = "Password id not Empty")
	@Size(min = 3,message = "Minimun 3 character required in password")
	String password;
	
}
