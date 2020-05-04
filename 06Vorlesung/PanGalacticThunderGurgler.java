import java.util.HashMap;

public class PanGalacticThunderGurgler {

	//es ist zwar n Cocktail, aber er macht trotzdem schaden man!
	
	private String owner;
	private int GargleBlasterDamage;
	private HashMap<String, String> ingredients = new HashMap<>();
	private String howto;
	
	
	
	
	public PanGalacticThunderGurgler(String owner, int gargleBlasterDamage, HashMap<String, String> ingredients,
			String howto) {
		super();
		this.owner = owner;
		GargleBlasterDamage = gargleBlasterDamage;
		this.ingredients = ingredients;
		this.howto = howto;
	}
	
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getGargleBlasterDamage() {
		return GargleBlasterDamage;
	}
	public void setGargleBlasterDamage(int gargleBlasterDamage) {
		GargleBlasterDamage = gargleBlasterDamage;
	}
	public HashMap<String, String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(HashMap<String, String> ingredients) {
		this.ingredients = ingredients;
	}
	public String getHowto() {
		return howto;
	}
	public void setHowto(String howto) {
		this.howto = howto;
	}
	
	
}
