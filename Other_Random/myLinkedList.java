
public static class ListDetail{
	public Node head = null;
	public Node tail = null;
	public int size = 0;
}

public static class Node<T>{
	private Node next = null;
	private Node prev = null;
	private T data = null;
	private ListDetail detail = null;
	
	public Node(T _data, Node _next, Node _prev, ListDetail _detail){
		this.data = _data;
		this.next = _next;
		this.prev = _prev;
		this.detail = _detail;
	}
	
	public Node getNext(){
		return next;
	}
	public Node getPrev(){
		return prev;
	}
	public void insertAfter(T _data){
		Node old = next;
		next = new Node(_data, old, this, detail);
		if(old != null){
			old.setPrev(next);
		}else{
			detail.tail = next;
		}
		detail.size++;
	}
	public void insertBefore(T _data){
		Node old = prev;
		prev = new Node(_data, this, old, detail);
		if(old != null){
			old.setNext(prev);
		}else{
			detail.head = prev;
		}
		detail.size++;
	}
	public void delete(){
		if(next == null){
			detail.tail = prev;
		}else{
			next.setPrev(prev);
		}
		if(prev == null){
			detail.head = next;
		}else{
			prev.setNext(next);
		}
		detail.size--;
	}
	
	public void setNext(Node n){
		next = n;
	}
	
	public void setPrev(Node n){
		prev = n;
	}
	
	public void getSize(){
		return detail.size;
	}
	
	public Node getHead(){
		return detail.head;
	}
	
	public Node getTail(){
		return detail.tail;
	}
	
	public T getData(){
		return data;
	}
	
	public void setData(T _data){
		this.data = _data;
	}
}
