package algoritmo.operacoes3d;

public class FuncoesDeNormalizacao {

	public static float ndcx;
	public static float ndcy;
	public static float dcx;
	public static float dcy;
	
	static public  float calcularNDCX( float getX) {
        ndcx = (((getX-(-300))/(300-(-300)))*2)-1;
        return ndcx;
    }

    static public float calcularNDCY( float getY) {
        ndcy =  (((getY-(-300))/(300-(-300)))*2)-1;
        return ndcy;
    }

    static public int calcularDCX(int ndh, float ndcx) {
        dcx = ((ndh - 1) * ndcx);
        return Math.round(dcx);
    }

    static public int calcularDCY(int ndv, float ndcy) {
        dcy = ((ndv - 1) * ndcy);
        return Math.round(dcy);
    }
	/*static public float calcularNDCX(float ndh, int dcx) {

		double ndcx = (double) dcx / (ndh - 1);
		return  ndcx;
		
	}
	
	static public double calcularNDCY(float ndv, int dcy){
		
		double ndcy = (double) dcy / (ndv - 1);
		return ndcy;
		
	}
	
	static public int calcularDCX(int ndh, double ndcx){
		dcx = ((ndh-1)* ndcx); 
		return (int) Math.round(dcx);
				
	}
	
	static public int calcularDCY(int ndv, double ndcy){
		dcy = ((ndv-1)* ndcy); 
		return (int) Math.round(dcy);
		
	}*/

}
