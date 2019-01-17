package chapter6;

public class Ex6_1 {
	public static void main(String[] args) {
		LinkedList L = new LinkedList();
		System.out.println("(1) 공백 리스트에 노드 3개 삽입하기");
		L.insertLastNode("월");
		L.insertLastNode("수");
		L.insertLastNode("일");
		L.printList();

		System.out.println("(2) 수 노드 뒤에 금 노드 삽입하기");
		ListNode pre = L.searchNode("수");
		if(pre == null) 
			System.out.println("검색실패>> 찾는 데이터가 없습니다.");
		else{
			L.insertMiddleNode(pre, "금");
			L.printList();
		}

		System.out.println("(3) 리스트의 노드를 역순으로 바꾸기");
		L.reverseList();
		L.printList();

		System.out.println("(4) 리스트의 마지막 노드 삭제하기");      
		L.deleteLastNode();
		L.printList();
	}//main 
}// end class

// 연결자료구조 
class LinkedList{
	private ListNode head; // head 라는 변수를 선언 
	
	//생성자 
	public LinkedList(){
		head = null;
	}// 아무것도 매개변수로 안들올경우 head의 값은 null 이다 
	
	// insertMiddleNode 메소드는 앞의 노드의 주소값과 데이터가 매개변수로 들어와 중간에 Node를 삽입해주는 역활을 한다. 
	public void insertMiddleNode(ListNode pre, String data){    
		
		ListNode newNode = new ListNode(data); // 들어갈 새로운 노드를 만들어주고 
		
		newNode.link = pre.link;	// 새로운 노드의 링크 필드에 들어갈 자리 앞에 노드의 링크를 담아준다. 
		pre.link = newNode;			// pre.link에 새로운 노드의 주소를 담아준다. 
	}//insertMiddleNode
	
	public void insertLastNode(String data){
		ListNode newNode = new ListNode(data); // 빈 객체를 생성
		
		if(head == null){
			this.head = newNode; // 만약 head가 비어있다면 head는 새롭게 만든 노드가 된다. 
		}
		else{
			ListNode temp = head; //temp라는 참조변수에 head객체를 담아주고 ,
			while(temp.link != null) {	// temp.link가 null이 되면 while 끝
				temp = temp.link;
			}// while
			temp.link = newNode; // temp에는 새로운 노드의 값이 담긴다. 
		}// if-else
	}// insertLastNode 마지막자리에 node를 삽입하는 메소드 
	
	public void deleteLastNode(){
		ListNode pre, temp;	// 앞의 노드를 참조할 pre 변수와 임시저장을 할 temp 변수 선언
		
		if(head == null)  return;	//만약 head가 null 이라면 아무것도 없는 리스트임으로 return
		
		if(head.link == null){
			head = null;
		}// 참조할 주소값이 없다면 null
		else{ // 만약 참조할 주소값이 있다면,
			pre = head;   // pre에 head의 값을 넣어주고 
			temp = head.link; // temp에 head가 참조하는 주소값을 넣어준다. 
			while(temp.link != null){ 	// temp.link의 값이 null 이면 while을 stop 
				pre = temp;			// pre는 temp값을 받고 
				temp = temp.link;	// temp는 temp.link의 값을 가진다. 
			}
			pre.link = null; // pre.link의 값을 null처리 :: 항상 노드의 마지막 노드의 링크 필드의 값은 null이다. 
		}//if-else
	}// deleteLastNode
	
	public ListNode searchNode(String data){
		ListNode temp = this.head; // temp변수에 head값 넣어주고
		
		while(temp != null){ 		// temp의 값이 null이 될때까지 while을 돌린다. 
			if(data == temp.getData()) { // 만약에  매개변수로 들어온 data의 값이 tmep에 있는 data일경우 
				
				return temp;  // 해당하는 temp의 값을 반환
			}
			else { 
				temp = temp.link; 
			}// if- else
		}// while
		return  temp;
	}//searchNode
	
	public void reverseList(){
		ListNode next = head;  // next 변수에 head의 값을 넣어준다. 
		ListNode current = null;  // current 변수에 null을 넣어준다. 
		ListNode pre = null;	// pre 변수에 null을 넣어준다. 
		
		while(next != null){ // next의 값이 null이 나올때까지 while문을 돌린다. 
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		}// while
		head = current;
	}//reverseList
	
	public void printList(){
		
		ListNode temp = this.head;
		System.out.printf("L = (");
		
		while(temp != null){
			
			System.out.printf(temp.getData());
			temp = temp.link;
			
			if(temp != null){
				System.out.printf(", ");
			}//if
		}//while
		System.out.println(")");
	}//printList
	
}//end class

//연결 자료구조 방식의 node
class ListNode{ 
	/*
	 *   연결 자료구조 방식은 node라는 원소의 개념을 쓴다. 원소의 데이터 값을 저장하는 데이터 필드(data field)와  주소값을 저장하는 링크 필드(Link field)로 구성되어있다. 
	 *   링크 필드 같은경우 메모리 참조 변수를 사용하여 주소에 대한 참조값을 저장하며, 링크 혹은 참조 라고 한다. 
	 */
	private String data; // 데이터 필드
	public ListNode link; // 링크 필드 
	
	// 생성자 
	public ListNode(){
		this.data = null;
		this.link = null;
	}// 아무것도 안들어오면 null
	public ListNode(String data){
		this.data = data;
		this.link = null;
	}// 데이터 하나만 들어오면 데이터 값만 넣어주고 link는 null 
	public ListNode(String data, ListNode link){
		this.data = data;
		this.link = link;
	}
	// get 메소드 
	public String getData(){
		return  this.data;
	}
}