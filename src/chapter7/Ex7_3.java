package chapter7;
/*
 *  Stack 쌓아 올린다는 의미로 스택 자료구조라는 것은 자료를 차곡 차곡 쌓아 올린 형태의 구조 
 *  
 *  스택은 같은 구조와 크리의 자료를 top이라고 정한 곳으로만 쌓을수 있고, top으로만 접근하도록 제한하여 만든 자료구조다. 
 *  
 *  후입 선출의 수조 (LIFO, Last in First Out)
 *  
 *  삽입 연산을 push, top을 통한 삭제를 pop이라고 한다. 
 */
public class Ex7_3 {

	public static void main(String[] args) {
		OptExp opt = new OptExp();
		String exp = "(3*5)-(6/2)";
		char postfix[];
		int value;
		System.out.println(exp);
		if(opt.testPair(exp))
			System.out.println("괄호 맞음!");
		else 
			System.out.println("괄호 틀림!!!");			
						
		System.out.printf("\n후위표기식 : ");
		postfix = opt.toPostfix(exp);
		System.out.println(postfix);	
	}// main

}// end class

interface Stack3{
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}//Stack3

class StackNode2{
	char data;	
	StackNode2 link;
}//end class

class LinkedStack2 implements Stack3{
	private StackNode2 top;
		
	public boolean isEmpty(){
		return (top == null);
	}// isEmpty
	
	public void push(char item){
		StackNode2 newNode = new StackNode2();
		newNode.data = item;
		newNode.link = top;
		top = newNode;		
	}// push
	
	public char pop(){
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		}
		else{ 
			char item = top.data;
			top = top.link;
			return item;	
		}// if-else			
	}// pop
	
	public void delete(){
		if(isEmpty()){
			System.out.println("Deleting fail! Linked Stack is empty!!");			
		}
		else {
			top = top.link;
		} //if-else
	}// delete 
	
	public char peek(){
		if(isEmpty()){
			System.out.println("Peeking fail! Linked Stack is empty!!");
			return 0;
		}
		else {
		 return top.data;		
		}// if-else
	}// peek
	
	public void printStack(){
		if(isEmpty())
			System.out.printf("Linked Stack is empty!! %n %n");
		else{
			StackNode2 temp = top;
			System.out.println("Linked Stack>> ");
			while(temp != null){
				System.out.printf("\t %c \n", temp.data);
				temp = temp.link;
			}
			System.out.println();	
		}// if-else
	}// printStack
}// end class

// 표기식 변환 class 
class OptExp{
	private String exp; // 표기식
	private int expSize; //표기식의 사이즈
	private char testCh, openPair;  //
	
	public boolean testPair(String exp){
		this.exp = exp;
		LinkedStack2 S = new LinkedStack2();
		expSize = this.exp.length();
		for(int i=0; i<expSize; i++){
			testCh = this.exp.charAt(i);
			switch(testCh){
				case '(' :
				case '{' :
				case '[' : 
					S.push(testCh); break;				
				case ')' :
				case '}' :
				case ']' : 
					if(S.isEmpty()) return false;
					else{
						openPair = S.pop();
						if((openPair == '(' && testCh != ')') ||
						   (openPair == '{' && testCh != '}') ||
						   (openPair == '[' && testCh != ']'))
						   return false;
					   else break;
					}
			}
		}
		if (S.isEmpty()) return true;
		else return false;
	}
	// 후기 표기식으로 바꾸기 
	public char[] toPostfix(String infix){
		char testCh;		
		exp = infix;	
		int expSize = 10;
		int j=0;
		char postfix[] = new char[expSize];
		LinkedStack2 S = new LinkedStack2();
		
		for(int i=0; i<=expSize; i++){
			testCh = this.exp.charAt(i);
			switch(testCh){
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					postfix[j++] = testCh; break;
					
				case '+' :
				case '-' :
				case '*' :
				case '/' :
					S.push(testCh); break;
					
				case ')' :  postfix[j++] =S.pop(); break;
				
				
				default:
			}// switch
		}//for
		postfix[j] = S.pop();
		return postfix;
	}//toPostfix	
}// end class