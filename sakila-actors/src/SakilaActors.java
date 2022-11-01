import java.sql.*;
import javax.sql.DataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import java.util.Scanner;

public class SakilaActors {
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("App needs two args to run!");
			System.exit(1);
		}

		String username = args[0];
		// maaike refused to set up a password and now you need to make modifications,
		// sorry
		String password = ""; // args[1];

		MysqlDataSource mds = new MysqlDataSource();
		mds.setServerName("localhost");
		mds.setPort(3306);
		mds.setUser(username);
		mds.setPassword(password);
		mds.setDatabaseName("sakila");

		doActorQuery(mds);
		doActorFilmQuery(mds);

	}

	public static void doActorQuery(MysqlDataSource mds) {
		System.out.println("Enter actor last name: ");
		String lastName = scanner.nextLine();

		if (!lastName.equals(null)) {
			try (Connection connection = mds.getConnection();
					PreparedStatement ps = connection
							.prepareStatement("SELECT first_name, last_name FROM actor WHERE last_name = ?;");) {
				ps.setString(1, lastName);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						String s1 = rs.getString("last_name");
						String s2 = rs.getString("first_name");
						System.out.println(s1 + " " + s2);
					}

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void doActorFilmQuery(MysqlDataSource mds) {
		System.out.println("Enter first and last name of actor: ");
		System.out.println("First name: ");
		String firstName = scanner.nextLine();
		System.out.println("Last name: ");
		String lastName = scanner.nextLine();

		try (Connection connection = mds.getConnection();
				PreparedStatement ps = connection.prepareStatement(
						"SELECT title FROM film LEFT JOIN film_actor ON film.film_id = film_actor.film_id LEFT JOIN actor ON film_actor.actor_id = actor.actor_id WHERE first_name = ? and last_name = ? ORDER BY title;");) {
			ps.setString(1, firstName);
			ps.setString(2, lastName);

			try (ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					System.out.println("The matches are:\n ");
					do {
						System.out.printf("Film: %s \n", rs.getString(1));
					}
					while (rs.next());

				} else {
					System.out.println("No matches!");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
