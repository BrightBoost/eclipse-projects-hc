import java.util.List;

public class App {
	public static void main(String[] args) {
		SakilaDataManager.setDataSource(args[0], args[1]);
		SakilaDataManager sdm = new SakilaDataManager();
		
		List<Country> countries = sdm.getAllCountries();
		
		for(Country country : countries) {
			System.out.println(country);
		}
	}
}
