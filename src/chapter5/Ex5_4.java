package chapter5;

// 다항식의 덧셈 뺄셈 프로그램 


class OperatePoly{

    private int degree_A=0, degree_B=0, degree_C=0, index_A=0, index_B=0, index_C=0;
    private int expo_A, expo_B; // 지수 
    private float coef_A, coef_B, coef_C; //계수

    public Polynomial addPoly(Polynomial A, Polynomial B){
    	// 주어진  두 다항식 A와 B를 더하여 결과 다항식 C를 반환하는 알고리즘.
    	
         degree_A = A.getDegree();
         degree_B = B.getDegree();
         expo_A = degree_A;
         expo_B = degree_B;
         
         if(degree_A >= degree_B) { 
        	 degree_C=degree_A;
         } else {
        	 degree_C=degree_B;
         }// if 
         
         Polynomial C = new Polynomial(degree_C);
         
         while(index_A <= degree_A && index_B <= degree_B){
              if(expo_A > expo_B){
                  C.setCoef(index_C++, A.getCoef(index_A++));
                  expo_A--;
              }
              else if(expo_A == expo_B){		// 두항의 지수가 같으면 계수를 더해서 만든 항을 다항식 C에 추가 한다. 
                  C.setCoef(index_C++, A.getCoef(index_A++)+B.getCoef(index_B++));
                  expo_A--; expo_B--;
              } 
              else {
                  C.setCoef(index_C++, B.getCoef(index_B++));
                  expo_B--;
              } // if-else
         }// while
        return C;
    }
}// end class

// 다항식 VO
class Polynomial{
   private int degree; //
   private float coef[]=new float[20]; // 계수의 배열 선언

   // 생성자 
   Polynomial (int degree, float coef[]){
        this.degree = degree;
        this.coef = coef;
   }
   Polynomial (int degree){
        this.degree = degree;
        for(int i=0; i<=degree; i++)
            this.coef[i] = 0;
   }
   
   // get,set메소드 
   public int getDegree(){
       return this.degree;
   }
   public float getCoef(int i){
       return this.coef[i];
   }
   public float setCoef(int i, float coef){
       return this.coef[i]=coef;
   }
   
   // 출력 메소드 
   public void printPoly(){
       int temp= this.degree;	
        for(int i=0; i<=this.degree; i++){
           System.out.printf("%3.0fx^%d", this.coef[i], temp--);
        }
	
        System.out.println();        
   }// printPoly
}//end class


public class Ex5_4 {
	
	 public static void main(String args[]){
         float a[]= new float[] {4,3,5,0};
         float b[]= new float[] {3,1,0,2,1};
         
         Polynomial A = new Polynomial(3, a);
         Polynomial B = new Polynomial(4, b);
         
         OperatePoly optPoly = new OperatePoly();
         
         Polynomial C = optPoly.addPoly(A,B);
         //출력 
         System.out.printf("A(x)="); A.printPoly();
         System.out.printf("B(x)="); B.printPoly();
         System.out.printf("C(x)="); C.printPoly();
   }
}
