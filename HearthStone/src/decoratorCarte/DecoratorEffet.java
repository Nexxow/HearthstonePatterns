package decoratorCarte;

import carte.Serviteur;

public abstract class DecoratorEffet extends Serviteur {
	protected String description;
	protected Serviteur serv;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	public Serviteur getServ() {
		return serv;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
