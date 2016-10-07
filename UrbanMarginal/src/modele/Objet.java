package modele;

public abstract class Objet {

	protected int posX ;
	protected int posY ;
	protected Label label ;
	
	
	/**
	 * @return the posX
	 */
	public int getPosX() {
		return posX;
	}
	/**
	 * @return the posY
	 */
	public int getPosY() {
		return posY;
	}
	/**
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}
	
	// pour voir si deux objet je touche ou pas 
	public boolean toucheObjet (Objet objet){
		if (objet.label==null){
			return false ;
		}
		else {
			if (objet.label.getjLabel()==null){
				return false ;
			}
		 else {
			int l_obj = objet.label.getjLabel().getWidth();
			int h_obj = objet.label.getjLabel().getHeight();
			int l_this = this.label.getjLabel().getWidth();
			int h_this = this.label.getjLabel().getHeight();
			return (!((this.posX+l_this<objet.posX ||
					this.posX>objet.posX+l_obj) ||
					(this.posY+h_this<objet.posY ||
				    this.posY>objet.posY+h_obj)));
			
			
			
			
		}
	}
	}}

