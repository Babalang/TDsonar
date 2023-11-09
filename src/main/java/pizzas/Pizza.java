package pizzas;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pizza {
	private List<Ingredient> composition =new ArrayList<>();
	private String nom;
	private float prix;



	public boolean estRouge(){
		for (Ingredient i:composition){
			if (i.getNom().equals("sauce tomate")) return true;
		}
		return false;
	}

	public boolean estBlanche(){
		boolean sauceTomate=false;
		boolean creme=false;
		for (Ingredient i:composition){
			if (i.getNom().equals("sauce tomate")) sauceTomate=true;
			if (i.getNom().equals("crème fraîche")) creme=true;
		}
		return !sauceTomate&&creme;
	}

	public boolean  estVegetarienne(){
		boolean result=true;
		for (Ingredient i:composition){
			if (!i.isVegetarien()) return false;
		}
		return result;
	}

	public Pizza(String nom, float prix){
		this.nom=nom;
		this.prix=prix;
	}



	public void ajoutIngredient(Ingredient i){
		if (!composition.contains(i)){
			composition.add(i);
		}
	}

	public String getNom() {
		return nom;
	}

	public float getPrix() {
		return prix;
	}
@Override
	public boolean equals(Object o){
		if(o==null || this.getClass() != o.getClass()){
				return false;
		}
		else{
			Pizza po= (Pizza)o;
			return po.getNom() == this.nom && po.getPrix()==this.prix;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(composition, getNom(), getPrix());
	}

	public void veganize() {
		nom=nom+" vegan";
		composition.removeIf(Ingredient::isVegetarien);
	}
	
	public String formattedIngredients() {
		StringBuilder s= new StringBuilder();
		for (Ingredient ing:composition) {
			s.append(ing.getNom());
		}
		return s.toString();
	}
	
	public Ingredient[] ingredients() {
		return composition.toArray(new Ingredient[0]);
	}
}
