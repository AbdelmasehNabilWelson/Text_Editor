package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
*
* @author UC San Diego Intermediate Programming MOOC team
* @author Abdelmaseh Nabil Welson
* @param <E> The type of the elements stored in the list
*/
public class MyLinkedList<E> extends AbstractList<E> {
   LLNode<E> head;
   LLNode<E> tail;
   int size;

   public MyLinkedList() {
       this.size = 0;
       this.head = new LLNode<>(null);
       this.tail = new LLNode<>(null);

       head.next = tail;
       tail.prev = head;
   }

   public void addAtHead(E val) {
       LLNode<E> newNode = new LLNode<>(val);
       if (size == 0) {
           newNode.prev = head;
           newNode.next = tail;
           tail.prev = newNode;
       } else {
           LLNode<E> oldNode = head.next;
           newNode.next = oldNode;
           oldNode.prev = newNode;
           newNode.prev = head;
       }
       head.next = newNode;
       size++;
   }

   public void addAtTail(E val) {
       LLNode<E> newNode = new LLNode<>(val);
       if (size == 0) {
           newNode.prev = head;
           newNode.next = tail;

           head.next = newNode;
       } else {
           LLNode<E> oldNode = tail.prev;

           oldNode.next = newNode;
           newNode.prev = oldNode;

           newNode.next = tail;
       }
       tail.prev = newNode;

       size++;
   }

   /**
    * Appends an element to the end of the list
    * @param element The element to add
    */
   public boolean add(E element) throws NullPointerException {
       if (element == null) {
           throw new NullPointerException();
       }
      
       addAtTail(element);
       return false;
   }

   /** Get the element at position index
    * @throws IndexOutOfBoundsException if the index is out of bounds. */
   public E get(int index) throws IndexOutOfBoundsException {
       return getNode(index).data;
   }

   public LLNode<E> getNode(int index) throws IndexOutOfBoundsException
   {
       if (index < 0 || index > this.size - 1) {
           throw new IndexOutOfBoundsException();
       }

       LLNode<E> node = head.next;
       while (index > 0) {
           node = node.next;
           index--;
       }

       return node;
   }

   /**
    * Add an element to the list at the specified index
    * @param index index where the element should be added
    * @param element The element to add
    */
   public void add(int index, E element ) throws NullPointerException, IndexOutOfBoundsException
   {
       if (element == null) {
           throw new NullPointerException();
       }
       

       if (index < 0 || (index > size() - 1 && this.size != 0)) {
    	   System.out.println(index);
           throw new IndexOutOfBoundsException();
       }

       if (index == 0) {
           this.addAtHead(element);
       } else if (index == size - 1) {
           this.addAtTail(element);
       } else {
           index--;
           LLNode<E> nodeBeforeIndex = this.getNode(index);
           LLNode<E> nodeAfterIndex = nodeBeforeIndex.next;
           LLNode<E> newNode = new LLNode<>(element);
           newNode.next = nodeAfterIndex;
           nodeAfterIndex.prev = newNode;

           newNode.prev = nodeBeforeIndex;
           nodeBeforeIndex.next = newNode;
           size++;
       }
   }


   /** @return the size of the list */
   public int size() {
       return this.size;
   }

   /** Remove a node at the specified index and return its data element.
    * @param index The index of the element to remove
    * @return The data element removed
    * @throws IndexOutOfBoundsException If index is outside the bounds of the list
    *
    */
   public E remove(int index) throws IndexOutOfBoundsException {
       if (index < 0 || index > size - 1) {
           throw new IndexOutOfBoundsException();
       }

       if (index < 0 || index > size - 1) {
    	   throw new IndexOutOfBoundsException();
       }
       
       LLNode<E> indexNode = this.getNode(index);
       LLNode<E> nodeBeforeIndex = indexNode.prev;
       LLNode<E> nodeAfterIndex = indexNode.next;

       if (index == 0) {
           head.next = nodeAfterIndex;
           nodeAfterIndex.prev = head;
       } else if (index == size - 1) {
           tail.prev = nodeBeforeIndex;
           nodeBeforeIndex.next = tail;
       } else {
           nodeBeforeIndex.next = nodeAfterIndex;
           nodeAfterIndex.prev = nodeBeforeIndex;
       }

       size--;
       return indexNode.data;
   }

   /**
    * Set an index position in the list to a new element
    * @param index The index of the element to change
    * @param element The new element
    * @return The element that was replaced
    * @throws IndexOutOfBoundsException if the index is out of bounds.
    */
   public E set(int index, E element) throws IndexOutOfBoundsException, NullPointerException {
       if (element == null) {
           throw new NullPointerException();
       }

       if (index < 0 || index > size - 1) {
    	   throw new IndexOutOfBoundsException();
       }
       
       LLNode<E> node = getNode(index);
       E old = node.data;

       node.data = element;
       return old;
   }

   public static void main(String[] args) {
       MyLinkedList<Integer> intList = new MyLinkedList<>();
       intList.add(1);
       intList.add(2);
       intList.add(435);
       intList.printList();
   }

   public void printList() {
       LLNode<E> curr = head.next;
       while (curr != tail) {
           System.out.print(curr.data + " ");
           curr = curr.next;
       }
       System.out.println();
   }

   public void printFromTail() {
       LLNode<E> curr = tail.prev;
       while (curr != head) {
           System.out.print(curr.data + " ");
           curr = curr.prev;
       }
       System.out.println();
   }
}
class LLNode<E>
{
   LLNode<E> prev;
   LLNode<E> next;
   E data;


   public LLNode(E e)
   {
       this.data = e;
       this.prev = null;
       this.next = null;
   }

}
