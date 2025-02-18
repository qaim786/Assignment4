/**
  * Variant of Bloch's Stack example page 60, 3rd edition
  * Used in SWE/CS 332 to discuss mutability and AF/RI
  */

import java.util.*;

public class inClass02A {
	public static void main(String args[]) {
		/*
		Stack s = new Stack();
		s.push(5);
		s.push(6);
		System.out.println(s.pop());
		System.out.println(s.pop());
		*/
		
		Stack s = new Stack();
		s = s.push(5);
		s = s.push(6);
		s = s.pop(); System.out.println(s.top());
		s = s.pop(); System.out.println(s.top());
		
	}
}
/*
class Stack { // mutable

   private Object[] elements;
   private int size = 0;


   public Stack() {
     this.elements = new Object[0];
   }

   public void push (Object e) {
     ensureCapacity();
     elements[size++] = e;
   }

   public Object pop () {
     if (size == 0) throw new IllegalStateException("Stack.pop");
     Object result = elements[--size];
     elements[size] = null;
     return result;
   }

   private void ensureCapacity() {
      if (elements.length == size) {
         Object oldElements[] = elements;
         elements = new Object[2*size + 1];
         System.arraycopy(oldElements, 0, elements, 0, size);
      }
   }
}
*/

class Stack { // immutable

   private Object[] elements;
   private int size = 0;
   private Object top;


   public Stack() {
     this.elements = new Object[0];
   }

/*
   public void push (Object e) {
     ensureCapacity();
     elements[size++] = e;
   }
*/

	// transform Mutator to Producer
	public Stack push (Object e) { 
	  ensureCapacity();
      
	  Stack result = new Stack(size+1);
	  System.arraycopy(elements, 0, result.elements, 0, size);
	  
	  result.elements[result.size++] = e;
	  
	  return result; // returns Stack as opposed to void
   }

   private Stack(int n) { // needed to support the new push()
	   elements = new Object[n];
	   size = n-1;
   }
   
   /*
   public Object pop () {
     if (size == 0) throw new IllegalStateException("Stack.pop");
     Object result = elements[--size];
     elements[size] = null;
     return result;
   }
   */
   
   // transform Mutator to Producer and Observer
   public Stack pop () { 
	  if (size == 0) throw new IllegalStateException("Stack.pop");
      Stack result = new Stack(size);
	  System.arraycopy(elements, 0, result.elements, 0, size);
	  
	  result.top = result.elements[--result.size];
	  result.elements[result.size] = null;
	 
	  return result; // returns Stack as opposed to void
   }
   public Object top() {
	   return top;
   }

   private void ensureCapacity() {
      if (elements.length == size) {
         Object oldElements[] = elements;
         elements = new Object[2*size + 1];
         System.arraycopy(oldElements, 0, elements, 0, size);
      }
   }
}

