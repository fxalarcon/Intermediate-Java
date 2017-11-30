package edu.gcccd.csis;

import java.util.Iterator;

public final class NodeList<E> implements Iterable<E> {

    private Node<E> head;
    Node<E> node1,node2;
	Node<Integer>node3;
    
    private Node<E> getHead(){
    	return head;
    }

    /**
     * @return {@link int} number of nodes in this list
     */
    int getLength() {
        int result = 0;
        Node<E> node = head;
        while (node != null) {
            node = node.getNext();
            result++;
        }
        return result;
    }

    /**
     * Appends the provided element to the end of this list.
     *
     * @param element {@link E} element to be appended.
     */
    public void append(final E element) {
        if (head == null) {
            head = new Node<>(element);
            
        } else {
            Node<E> node = head;
            while (node.getNext() != null) {
            	
                node = node.getNext();
            }
            
            node.setNext(new Node<>(element));
        }
    }

    public NodeList<Integer> add(final NodeList<E> nodeList1, final NodeList<E> nodeList2, final NodeList<Integer> nodeList3,final NodeList<Integer> nodeList4) {
    
    	int l1= nodeList1.getLength();
    	int l2= nodeList2.getLength();
   
    	boolean carry=false;
    	int sum = 0;
    /*	Node<E> node1,node2;
    	Node<Integer>node3;*/
    	 node1= nodeList1.getHead();
    	 node2= nodeList2.getHead();
/////////////////////Adding The Two Lists///////////////////////////////////////////////////
    	 do {
    		 int num1=0,num2=0;
    		 while(num1<l1-1) {
    			 node1=node1.getNext();
    			 num1++;
    		 }
    		 while(num2<l2-1) {
    			 node2=node2.getNext();
    			 num2++;
    		 }
    		 
    		if(l1>=1&&l2>=1) {
    			if(carry==true) {
    			 sum=(int) node1.getElement()+ (int) node2.getElement()+1;
    			 carry=false;
    			}
    			 
    			else {
    				sum=(int) node1.getElement()+ (int) node2.getElement();    	
    			carry=false;
    			}
    		if(sum>=10) {
    			
    			sum=sum%10;
    			carry=true;
    			nodeList3.append(sum);
    			
    		}
    		else {
    			nodeList3.append(sum);
    			carry=false;
    		}
    		l1--;
    		l2--;
    		}
    		
    		else if(l1>=1&&l2==0) {
    			if(carry==true) {
    				sum=(int) node1.getElement()+1;
    				carry=false;
    			}
    			else {
    				sum=(int) node1.getElement();
    				carry=false;
    			}
    		nodeList3.append(sum);	
    		l1--;
    		}
    		else if(l2>=1&&l1==0) {
    			if(carry==true) {
    				sum=(int) node2.getElement()+1;
    				carry=false;
    			}
    			else {
    				sum=(int) node2.getElement();
    				carry=false;
    			}
    		nodeList3.append(sum);	
    		l2--;
    		}
    	
    		
    		 node1= nodeList1.getHead();
        	 node2= nodeList2.getHead();
    		
    	 }while(l1>=1||l2>=1);
    	 
    	 if(carry==true) {
    	 nodeList3.append(1);
    	 }
    	 
//////////////////////Add List////////////////////////////////////////////////////////////////
    	 
    	
//////////////////Reversing The List ///////////////////////////////////////////////////////    	 
    	 int num=0;
    	 int l3= nodeList3.getLength();
    	 
    	  
    	do {	 
    		num=0;
    		node3= nodeList3.getHead();
    		
    	 while(num<l3-1) {
    		 
			 node3=node3.getNext();
			 num++;
    	 }
    	 nodeList4.append((int)node3.getElement());
    	 
		l3--;
		
		
		 
    	 }while(l3>=1);
/////////////////////Reverse List/////////////////////////////////////////////////////////////////////////
    	
           
           return nodeList4;
                
    }
    
    public long getanalysis() {
		return (node1.getCounter()+node2.getCounter()+node3.getCounter());
    	
    }
    
    /**
     * Removes the 1st element from this list that is equal to the provided element.
     *
     * @param element {@link E} element to be removed.
     */
    public void remove(final E element) {
        if (head != null) {
            if (head.getElement().equals(element)) {
                head = head.getNext();
            } else {
                Node<E> node = head;
                while (node.getNext() != null) {
                    if (node.getNext().getElement().equals(element)) {
                        node.setNext(node.getNext().getNext());
                        break;
                    }
                    node = node.getNext();
                }
            }
        }
    }

    /**
     * Checks if this list contains the provided element.
     *
     * @param element {@link E} element to look for.
     * @return {@link boolean} - true if the provided element can be found in this list.
     */
    public boolean contains(final E element) {
        for (E e : this) {
            if (e.equals(element)) {
                return true;
            }
        }
        return false;
    }

    // implement Iterable<E> interface
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public E next() {
                E obj = node.getElement();
                node = node.getNext();
                return obj;
            }
            
          

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}

