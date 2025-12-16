/*HONOR CODE POLICY: “I will practice academic and personal integrity and excellence of character
and expect the same from others.”
As an academic community, Florida Southern College is firmly committed to honor and integrity in the
pursuit of knowledge. Therefore, as members of this academic community, all students acknowledge
responsibility for their actions and commit themselves to the highest standards of integrity, thereby making
a covenant with the College and all members of the academic community not to engage in any form of
academic dishonesty as defined immediately below. This covenant—Florida Southern College’s Honor
Code—lies at the heart of learning, inquiry, and the critical exploration and dissemination of ideas. Through
it, students affirm the authorship of their own work, and when work is not their own, appropriately attribute
ideas, concepts, data, words, and artistic and creative expressions. Formal subscription to the Honor Code
by all students assures the academic community that breaches of academic integrity will not be tolerated
and fosters learning at its best. */
// Marcos Felipe de Castro Ornelas
// ID : 1308576

public class FSCvouchers {
	// top: reference variable to the top of the stack (same as "head" of linked list)
    private FSCvoucher top;
    
    // CONSTRUCTOR
    public FSCvouchers() {
        top = null;
    }
	
	
	/* Below are MANY methods that are used on stacks.
	 * 
	 * Examples:
	 * isEmpty, PUSH, POP, PEEK, and more.
	 */
	
	
	//
	// boolean | isEmpty()
	//
	public boolean isEmpty() {
		return top == null;
	}
	
	
	//
	// void | PrintStack()
	//
	public void PrintStack() {
        FSCvoucher helpPtr = top;
        // Traverse to correct insertion point
        while (helpPtr != null) {
            // Print the data value of the node
            System.out.printf("           %s %s (%s)\n", helpPtr.getFirstName(), helpPtr.getLastName(), helpPtr.getID());
            // Step one node over
            helpPtr = helpPtr.getNext();
        }
        System.out.println();
	}

	//
	// void | push(int)
	//
	//
	// StackNode | push(StackNode, int)
	//
	public void push(FSCvoucher voucher) {
		// Make a new StackNode with "data" as the data value
		// and set the "next" of this new node to the same address as top
		// * This is the same as addToFront() method for Linked Lists.
        if (voucher != null) {
            voucher.setNext(top);
            top = voucher;
        }
		// Now, return the newly updated top.
	}
	
	
	//
	// StackNode | pop()
	//
	public FSCvoucher pop() {
		// Save a reference to the current top node (because we will change where top points to)
		FSCvoucher temp = top;
		
		// Now, invoke the pop method with top as a parameter.
		// This method will return a new top node.
		top = pop(top);
		
		// Finally, return temp, which is the previous top node that we just "popped" off the list.
		return temp;
	}
	//
	// StackNode | pop(StackNode)
	//
	private FSCvoucher pop(FSCvoucher top) {
		// Set top equal to the next node.
		// This will make top point to the 2nd node instead of the first node.
		top = top.getNext();
		
		// return the address/reference of the new top node
		return top;
	}
	
	
	//
	// int | peek()
	//
	public FSCvoucher peek() {
		// Invoke the peek method with top as a parameter
		// return topValue
		return peek(top);
	}
	//
	// int | peek(StackNode)
	//
	private FSCvoucher peek(FSCvoucher top) {
        if (top == null) {
            System.out.println("Stack is empty");
            return null;
        }
		// Return the data value of the top node.
		// You can see that we do NOT pop. We are only returning the data value.
		return top;
	}

    public void clear() {
        top = null;
    }
}
