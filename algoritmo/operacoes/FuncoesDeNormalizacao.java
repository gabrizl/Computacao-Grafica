package algoritmo.operacoes;

public class FuncoesDeNormalizacao {

	public static float ndcx;
	public static float ndcy;
	public static int dcx;
	public static int dcy;
	
	static public  float calcularNDCX( float getX) {
        ndcx = (((getX)/600)*2)-1;
        return ndcx;
    }

    static public float calcularNDCY( float getY) {
        ndcy =  (((getY)/600)*2)-1;
        return ndcy;
    }

    static public int calcularDCX(int ndh, float ndcx) {
        dcx = (int) ((ndh - 1) * (ndcx + 1));
        return Math.round(dcx);
    }

    static public int calcularDCY(int ndv, float ndcy) {
        dcy = (int) ((ndv - 1) * (ndcy + 1)); 
        return Math.round(dcy);
    }
	

}
