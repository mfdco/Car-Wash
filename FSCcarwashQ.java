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

public class FSCcarwashQ {
	// top: reference variable to the top of the stack (same as "head" of linked list)
    private FSCmember front;
	private FSCmember back;
    
    // CONSTRUCTOR
    public FSCcarwashQ() {
        front = back = null;
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
		return front == null;
	}
	
	
	//
	// void | enqueue(int)
	//
	public void enqueue(FSCmember member) {

        // VERY IMPORTANT SO THAT YOU DON'T LINK TO OLD NODES
        member.setNext(null);

		if (isEmpty()) {
			front = back = member;
		}
		else {
            back.setNext(member);
			back = member;
		}

	}
	//
	// QueueNode | enqueue(QueueNode, QueueNode, int)
	//
	
	//
	// QueueNode | dequeue()
	//
	public FSCmember dequeue() {
        if (isEmpty()) {
            return null;
        }

        FSCmember temp = front;
		front = dequeue(front);

		if (front == null)
			back = null;

        // SAME REASONING DON'T LINK TO OLD NODES
        temp.setNext(null);

		return temp;
	}
	//
	// QueueNode | dequeue(QueueNode)
	//
	private FSCmember dequeue(FSCmember front) {
		front = front.getNext();
		return front;
	}
	
	
	//
	// int | peek()
	//
	public FSCmember peek() {
		// Invoke the peek method with front as a parameter
		// return topValue
		return peek(front);
	}
	//
	// int | peek(QueueNode)
	//
	private FSCmember peek(FSCmember front) {
		// Return the data value of the front node.
		// You can see that we do NOT dequeue. We are only returning the data value.
		return front;
	}

    public void clear() {
        front = back = null;
    }
}
