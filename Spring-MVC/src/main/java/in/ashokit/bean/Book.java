package in.ashokit.bean;

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
public class Book {
	
	@NotNull(message = "Enter only Integer.")
	private Integer bookId;
	
	@NotEmpty(message = "Name should not empty.")
	@Size(min=3, message = "Min 3 lenght required" )
	private String bookName;
	
	@NotNull
	@Min(value=100, message = "min price value is 100")
	private Double bookPrice;
}
