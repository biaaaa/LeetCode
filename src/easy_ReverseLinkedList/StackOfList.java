package easy_ReverseLinkedList;

public class StackOfList {

	private ListNode stackPointer=null;
	
	public void push(ListNode n){
		if(stackPointer==null){
			stackPointer=n;
		}
		else{
			n.setNext(stackPointer);
			stackPointer=n;
		}
	}
	
	public ListNode pop(){
		if(stackPointer==null){
			return null;
		}
		else{
			ListNode temp=stackPointer;
			stackPointer=stackPointer.getNext();
			return temp;
		}
	}
}
