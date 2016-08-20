package easy_ReverseLinkedList;

public class List {

	private ListNode header;

	public List() {
		ListNode header = new ListNode(0);
		this.header = header;
	}

	public void create(int value){
		ListNode node= new ListNode(value);
		insert(node);
	}
	
	public void delete(ListNode node){
		if(node==null){
			return;
		}
		
		if(header.getNext() == null){
			return;
		}else{
			ListNode trailer=header;
			ListNode p=header.getNext();
			while(p!=null && node.getValue() != p.getValue()){
				trailer=p;
				p=p.getNext();
			}
			if(p==null){
				return;
			}
			trailer.setNext(p.getNext());
			node.setNext(null);
		}
		
	}
	
	public void insert(ListNode node) {
		if (node == null) {
			return;
		}

		if (header.getNext() == null) {
			header.setNext(node);
			node.setNext(null);
		} else {
			ListNode p = header.getNext();
			ListNode trailer = header;
			while (p != null && node.getValue() > p.getValue()) {
				trailer=p;
				p=p.getNext();
			}
			node.setNext(p);
			trailer.setNext(node);
		}
	}

}
