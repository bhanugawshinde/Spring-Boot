package in.ashokit.generators;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EnumSet;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;
import org.springframework.stereotype.Component;

@Component
public class EmployeeIdGenerator implements BeforeExecutionGenerator {

	private static final long serialVersionUID = 1L;

	private static final String PREFIX = "TCS";

	@Override
	public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue,
			EventType eventType) {
		int suffix = 1;
		String query = "SELECT MAX(CAST(SUBSTRING(id,4) AS UNSIGNED)) FROM EMPLOYEE_DETAILS";

		JdbcConnectionAccess jdbcConnectionAccess = session.getJdbcConnectionAccess();
		if (jdbcConnectionAccess == null) {
			throw new IllegalStateException("JDBC Connection Access is unavailable!");
		}

		try (Connection connection = jdbcConnectionAccess.obtainConnection();
				Statement stmt = connection.createStatement();
				ResultSet resultSet = stmt.executeQuery(query)) {

			if (resultSet.next() && resultSet.getObject(1) != null) {
				suffix = resultSet.getInt(1) + 1; // Increment suffix properly
			}

		} catch (SQLException e) {
			throw new RuntimeException("Error generating custom ID", e);
		}

		return PREFIX + suffix;
	}

	@Override
	public EnumSet<EventType> getEventTypes() {
		return EnumSet.of(EventType.INSERT); // Ensure it generates ID only on INSERT events
	}
}
