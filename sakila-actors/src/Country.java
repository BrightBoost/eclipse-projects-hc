import java.time.LocalDateTime;

public class Country {
	private long id;
	private String country;
	private LocalDateTime lastUpdate;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}
	
	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", country=" + country + ", lastUpdate=" + lastUpdate + "]";
	}
	
	
	
}
