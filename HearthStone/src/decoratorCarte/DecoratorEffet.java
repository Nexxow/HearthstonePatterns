package decoratorCarte;

import carte.Carte;

public abstract class DecoratorEffet extends Carte {
	protected String description;
	protected Carte carte;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
