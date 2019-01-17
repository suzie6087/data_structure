package chapter5;

public class Ex5_1 {

	public static void main(String[] args) {
		// 1차원 배열 
		int sale[] = new int[] {156, 209, 251, 312};
		
		for(int i = 0 ; i < 4 ; i++) {
			System.out.printf("%d/4 분기 : sale[%d] = %d %n", i + 1, i , sale[i] );
		}//for
	}// end main
}
