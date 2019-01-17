package chapter5;

public class Ex5_2 {
	
	  public  static void main(String srgs[]){
		  //선형리스트를  2차원 배열로 구현 
		  
		int sale[][] = new int[][]{{63, 84, 140, 130},
	                 		   {157, 209, 251, 312}};  // 2차원 배열이므로 배열을 2개를 선언해준다. 
			
	 	for(int i=0; i<2; i++){
		    for(int j=0; j<4; j++)
	                 System.out.printf("%d/4분기 : sale[%d][%d]= %d %n", 
	                                   j+1, i, j, sale[i][j]);
		    System.out.println();
		}// for
	 	
	 	
	  }// main
}// end class


