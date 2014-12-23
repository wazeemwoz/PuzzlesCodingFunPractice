import java.util.*;

public class MyLinkedList {
	public static void main(String[] args){
		Node<Character> list = stringToLinkedList("FOLLOW UP");
		ctciProblem2_1(list);
	}
	
	public static Node<Character> stringToLinkedList(String str){
		Node<Character> node = new Node<Character>();
		for(int i = 0; i < str.length(); i++){
			node = node.chainNext(str.charAt(i));
		}
		return node.getHead();
	}
	
	public static void ctciProblem2_1(Node<Character> list){
		System.out.println("*-----Problem-2.1-----*");
		
		list.print();
		
		System.out.println("RESULT:");
		list.removeDuplicates(new HashSet<Character>());
		list.print();
	}
	
	static class ListDetail<T>{
		public Node<T> head = null;
		public Node<T> tail = null;
		public int size = 0;
	}

	static class Node<T>{
		private Node<T> next = null;
		private Node<T> prev = null;
		private T data = null;
		private ListDetail<T> detail = null;
		
		public Node(){
			detail = new ListDetail<T>();
			detail.size = 0;
		}
		
		public Node(T _data, Node<T> _next, Node<T> _prev, ListDetail<T> _detail){
			this.data = _data;
			this.next = _next;
			this.prev = _prev;
			this.detail = _detail;
			this.detail.size++;
		}
		
		public Node<T> getNext(){
			return next;
		}
		
		public Node<T> getPrev(){
			return prev;
		}
		
		public Node<T> insertAfter(T _data){
			if(getSize() == 0){
				data = _data;
				detail.size++;
				detail.head = this;
				detail.tail = this;
				return this;
			}
			
			Node<T> old = next;
			next = new Node<T>(_data, old, this, detail);
			if(old != null){
				old.setPrev(next);
			}else{
				detail.tail = next;
			}
			
			return this;
		}
		
		public Node<T> insertBefore(T _data){
			if(getSize() == 0){
				data = _data;
				detail.size++;
				detail.head = this;
				detail.tail = this;
				return this;
			}
			
			Node<T> old = prev;
			prev = new Node<T>(_data, this, old, detail);
			if(old != null){
				old.setNext(prev);
			}else{
				detail.head = prev;
			}
			
			return this;
		}
		
		public boolean delete(){
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
			
			if(detail.size == 0){
				return false;
			}
			
			if(detail.size == 1){
				detail.head = null;
				detail.tail = null;
				detail.size = 0;
				next = null;
				prev = null;
				data = null;
			}
			detail.size--;
			return true;
		}
		
		public Node<T> setNext(Node<T> n){
			next = n;
			return this;
		}
		
		public Node<T> setPrev(Node<T> n){
			prev = n;
			return this;
		}
		
		public int getSize(){
			return detail.size;
		}
		
		public Node<T> getHead(){
			return detail.head;
		}
		
		public Node<T> getTail(){
			return detail.tail;
		}
		
		public T getData(){
			return data;
		}
		
		public Node<T> setData(T _data){
			this.data = _data;
			return this;
		}
		
		public Node<T> chainNext(T _data){
			insertAfter(_data);
			return next == null ? this : next;
		}
		
		public Node<T> chainBefore(T _data){
			insertBefore(_data);
			return prev == null ? this : prev;
		}
		
		public void print(){
			System.out.print(getData());
			if(next == null){
				System.out.println();
				System.out.println("SIZE:" + detail.size);
			}else{
				next.print();
			}
		}
		
		public Node<T> removeDuplicates(Set<T> buffer){
			if(buffer.contains(data)){
				delete();
			}else{
				buffer.add(data);
			}
			if(next == null){
				return detail.head;
			}
			return next.removeDuplicates(buffer);
		}
	}
}
