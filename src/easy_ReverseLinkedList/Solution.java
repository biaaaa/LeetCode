package easy_ReverseLinkedList;

public class Solution {

	public static ListNode reverseLinkedList(ListNode head, ListNode last){
		ListNode temp=head.getNext();
		head.setNext(last);
		if(temp==null){
			return head;
		}else{
			return reverseLinkedList(temp, head);
		}
	}
	
	public static ListNode reverseLinkedListNew(ListNode head){
		ListNode last=null;
		
		while(head!=null){
			ListNode temp=head.getNext();
			head.setNext(last);
			last=head;
			head=temp;
		}
		
		return last;
	}
	
	public static void main(String [] args){
		ListNode a1=new ListNode(5);
		ListNode a2=new ListNode(6);
		ListNode a3=new ListNode(8);
		ListNode a4=new ListNode(9);
		ListNode a5=new ListNode(15);
		ListNode a6=new ListNode(25);
		ListNode a7=new ListNode(35);
		ListNode a8=new ListNode(45);
		a1.setNext(a2);
		a2.setNext(a3);
		a3.setNext(a4);
		a4.setNext(a5);
		a5.setNext(a6);
		a6.setNext(a7);
		a7.setNext(a8);

		
		ListNode node = a1;
		while(node!=null){
			System.out.print(node.getValue()+", ");
			node=node.getNext();
		}
		System.out.println();
		
		node=reverseLinkedListNew(a1);
		
		while(node!=null){
			System.out.print(node.getValue()+", ");
			node=node.getNext();
		}
		
	}
}

