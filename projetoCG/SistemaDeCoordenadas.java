package projetoCG;

public class SistemaDeCoordenadas {
	
	public double ndcx;
	public double ndcy;
	public double dcx;
	public double dcy;
	
	//Para coordenadas normalizadas
	/**
	 * Convers�o para NDCX
	 * @param x - Valor x
	 * @return NDCX
	 */
	public double paraNDCX(double x){
		
		
		ndcx = (x - 0)/ (600 - 0);

		return ndcx;
	}
	/**
	 * Convers�o para NDCY
	 * @param y - Valor Y
	 * @return NDCY
	 */
	public double paraNDCY(double y){
		
		
		ndcy = (y - 0)/( 600 - 0);

		return ndcy;
	}
	//Para coordenadas do dispositivo
	/**
	 * Convers�o para NCX
	 * @param X - Valor X
	 * @return NCX
	 */
	public int paraNCX(){
		
		dcx = ((600-1)* ndcx); 
		dcx = Math.round(dcx);
		
		return (int) dcx;
		
	}
	/**
	 * Convers�o para NCY
	 * @param Y - Valor Y
	 * @return NCY
	 */
	public int paraNCY(){

		
		dcy = ((600-1)* ndcy); 
		dcy = Math.round(dcy);
		
		return (int) dcy;
	}
	
	
}
