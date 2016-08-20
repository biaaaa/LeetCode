package medium_AddTwoNumbers;

public class Solution {

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){

		if(l1==null||l2==null){
			return null;
		}
		int a=0;
		int b=0;
		int sum=0;
		int carry=0;
		ListNode p1=l1.next;
		ListNode p2=l2.next;
		ListNode r=new ListNode((l1.getValue()+l2.getValue())%10);
		ListNode p=r;
//		if(p1!=null||p2!=null){
//			p=new ListNode(0);
//		}else{
//			return r;
//		}
//		p=r;
		while(p1!=null&&p2!=null){
			a=p1.getValue();
			b=p2.getValue();
			sum=a+b+carry;
			ListNode c=new ListNode(sum%10);
			carry=sum/10;
			p.next=c;
			p=c;
			p1=p1.next;
			p2=p2.next;	
		}
		if(p1==null){
			while(p2!=null){
				sum=p2.getValue()+carry;
				ListNode c=new ListNode(sum%10);
				carry=0;
				p.next=c;
				p=c;
				p2=p2.next;
			}
		}else{
			while(p1!=null){
				sum=p1.getValue()+carry;
				ListNode c=new ListNode(sum%10);
				carry=0;
				p.next=c;
				p=c;
				p1=p1.next;
			}
		}
		if(carry!=0){
			ListNode c=new ListNode(carry);
			p.next=c;
		}
		return r;
	}
	
	public static void main(String [] args){
		ListNode a1 = new ListNode(6);
		ListNode a2 = new ListNode(6);
		ListNode a3 = new ListNode(6);
		ListNode b1 = new ListNode(3);
		//ListNode b2 = new ListNode(1);
		//ListNode b3 = new ListNode(7);
		a1.next=a2;
		a2.next=a3;
		//b1.next=b2;
		//b2.next=b3;
		
		ListNode c=addTwoNumbers(a1, b1);
		ListNode p=c;
		while(p!=null){
			System.out.print(p.getValue()+" ");
			p=p.next;
		}
		
		
	}
}
