package chapter7;

public class Ex7_4 {
	
	public static void main(String args[]){
		OptExp2 opt = new OptExp2();
		int result;
		String exp = "35*62/-";	
		System.out.printf("\n후위표기식 : %s", exp);
		result = opt.evalPostfix(exp);
		System.out.printf("\n 연산결과 =  %d \n", result);		
	}// main
	
}// end class

class StackNode4{
	int data;	
	StackNode4 link;
}// end class

class LinkedStack4{
	private StackNode4 top;  // top 
		
	public boolean isEmpty(){
		return (top == null);
	}// isEmpty
	
	public void push(int item){
		StackNode4 newNode = new StackNode4();
		newNode.data = item;  // 새로운 노드에 매개변수로 들어온 Item 넣어준다.
		newNode.link = top;   
		top = newNode;		
	}// push 
	
	public int pop(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		}
		else{ 
			int item = top.data;
			top = top.link;
			return item;	
		}// if-else				
	}// push	
}// end class

class OptExp2{	
	
	private String exp; 
	
	public int evalPostfix(String postfix){		
		LinkedStack4 S = new LinkedStack4();
		
		exp = postfix;  // 후위 표기식 
		int opr1, opr2, value;			
	    char testCh;  
	    
		for(int i=0; i<7; i++){		
			testCh = exp.charAt(i);
			if(testCh != '+' && testCh != '-' && testCh != '*' && testCh != '/'){ 
				value = testCh - '0';
				S.push(value);
			}
			else{
				opr2 = S.pop();  // 뺴내기 
				opr1 = S.pop();  // 뺴내기 
				switch(testCh){
					case '+' : S.push(opr1 + opr2); break; 
					case '-' : S.push(opr1 - opr2); break; 
					case '*' : S.push(opr1 * opr2); break; 
					case '/' : S.push(opr1 / opr2); break; 
				}// switch
			}// if-else			
		}// for
		return S.pop();		
	}// evalPostfix
}// end class