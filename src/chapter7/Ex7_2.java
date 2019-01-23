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
public class Ex7_2 {
	// 연결 자료구조 방식을 이용한 스택의 구현 
	public static void main(String[] args) {
		char deletedItem;
		LinkedStack LS = new LinkedStack();
		
		LS.push('A');
		LS.printStack();
		
		LS.push('B');
		LS.printStack();
		
		LS.push('C');
		LS.printStack();
		
		deletedItem = LS.pop();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LS.printStack();		
	}// main
}//end class

interface Stack2{
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}// Stack2

// 연결자료구조 = node 사용 
class StackNode{
	char data; // 데이터 필드 
	StackNode link; // 링크 필드 
}


class LinkedStack implements Stack2{
	private StackNode top;
		
	public boolean isEmpty(){
		return (top == null);
	}//isEmpty
	
	public void push(char item){
		StackNode newNode = new StackNode(); // 새로운 노드 생성 
		
		newNode.data = item; // push에 들어온 데이터 넣어준다. 
		newNode.link = top;  // top의 주소값 넣어준다. 
		top = newNode;		 // top에는 새로운 node의 값을 넣어준다. 
		System.out.println("Inserted Item : " + item);
	}//push
	
	public char pop(){
		//데이터를 꺼낼때 
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
			return 0;
		}
		else{ 
			char item = top.data; // item에 top.data의값을 넣어준다.
			top = top.link;		  // top은 top.link의 값을 가진다. 
			return item;		  // item 객체 리턴 
		}//if-else			
	}//pop
	
	public void delete(){
		if(isEmpty()){
			System.out.println("Deleting fail! Linked Stack is empty!!");			
		}
		else {
			top = top.link;  // top.link는 top앞에 원소를 가리킨다. 
		}
	}//delete
	
	public char peek(){
		if(isEmpty()){
			System.out.println("Peeking fail! Linked Stack is empty!!");
			return 0;
		}
		else 
			return top.data;		
	}//peek
	
	public void printStack(){
		if(isEmpty())
			System.out.printf("Linked Stack is empty!! %n %n");
		else{
			StackNode temp = top;
			System.out.println("Linked Stack>> ");
			while(temp != null){
				System.out.printf("\t %c \n", temp.data);
				temp = temp.link;
			} //while
			System.out.println();	
		}// if-else
	}//printStack
}