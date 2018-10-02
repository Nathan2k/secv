package slider;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 

@ManagedBean
public class CheckboxView {
	
    private String[] selectedCities;
    private String[] selectedCities2;
	private List<String> cities;
			
	
	@PostConstruct
		public void init() {
        cities = new ArrayList<String>();
        cities.add("Indiferente");
        cities.add("Acre");
        cities.add("Dubai");
	}


	public String[] getSelectedCities() {
		return selectedCities;
	}


	public void setSelectedCities(String[] selectedCities) {
		this.selectedCities = selectedCities;
	}


	public String[] getSelectedCities2() {
		return selectedCities2;
	}


	public void setSelectedCities2(String[] selectedCities2) {
		this.selectedCities2 = selectedCities2;
	}


	public List<String> getCities() {
		return cities;
	}


	public void setCities(List<String> cities) {
		this.cities = cities;
	};
		
	
	
}
