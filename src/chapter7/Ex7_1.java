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
public class Ex7_1 {
	// 순차 자료 구조 방식을 이용한 스택 프로그램 
	public static void main(String[] args) {
		int stackSize = 5;  // stack 사이즈 5선언 
		char deletedItem; 
		ArrayStack S = new ArrayStack(stackSize); 
		
		S.push('A');
		S.printStack();
		
		S.push('B');
		S.printStack();
		
		S.push('C');
		S.printStack();
		
		deletedItem = S.pop();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		S.printStack();		
	
	}// main

}// end class


interface Stack{
	boolean isEmpty(); 
	void push(char item); // 삽입메소드 
	char pop();			// top을 통한 삭제 메소드 
	void delete();
	char peek();
}// Stack interface

// 순차 자료구조 Stack 쌓이는 순서를 배열의 인덱스로 표현 
class ArrayStack implements Stack{
	private int top;  // top 변수 
	private int stackSize; // stack의 사이즈 
	private char itemArray[]; // 스택의 데이터 리스트로 구현 
	
	// 생성자 
	public ArrayStack(int stackSize){ // stack의 사이즈가 매개 변수로 들어오면 
		top = -1;				
		this.stackSize = stackSize; 
		itemArray = new char[this.stackSize]; // 스택의 데이터 리스트는 생성.
	}
	
	public boolean isEmpty(){ //스택이 비어있는지 여부 확인 
		return (top == -1); // 비워져있다면 -1 return
	}// isEmpty 메소드 
	
	public boolean isFull(){ // 스택이 가득 차이있는지 여부 확인 
		return (top == this.stackSize-1); // top은 리스트의 (n-1)인덱스에 대항하는 원소의값 넣어줘서 리턴!
	}// isFull 메소드 
	
	public void push(char item){
		// 먼저 스택이 찼는지 확인한다. 
		if(isFull()){ 
			System.out.println("Inserting fail! Array Stack is full!!");
		}
		else{ 	
			// 스택에 여유가 있으면  들어온 값을 넣어준다. 
			itemArray[++top] = item; 
			System.out.println("Inserted Item : " + item);
		}// if-else
	}// push 데이터 삽입 메소드 
	
	public char pop(){
		// 스택이 비어있는지를 확인 ! 비워있으면 못빼니까 데이터를 
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!!");
			return 0;
		}
		else{ 
			// 안비워있다면 itemArray[top--]를 해서 데이터를 빼준다.  인덱스 == top
			return itemArray[top--];	
		}// if-else				
	}//pop 데이터 삭제 
	
	public void delete(){
		if(isEmpty()){
			System.out.println("Deleting fail! Array Stack is empty!!");			
		}
		else {
			top--;
		}// if-else
	}// delete 메소드 
	
	public char peek(){
		if(isEmpty()){
			System.out.println("Peeking fail! Array Stack is empty!!");
			return 0;
		}
		else 
			return itemArray[top];		
	}// peek 메소드 
	
	public void printStack(){
		if(isEmpty())
			System.out.printf("Array Stack is empty!! %n %n");
		else{
			System.out.printf("Array Stack>> ");
			for(int i=0; i<=top; i++) {
				System.out.printf("%c ", itemArray[i]);
			}//for 
			System.out.println();	System.out.println();
		}// if-else
	}// printStack 메소드 
}// end class
