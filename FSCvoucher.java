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
public class FSCvoucher {
    private int arrivalTime;
    private int ID;
    private String firstName;
    private String lastName;
    private String code;
    private int timeStarted;
    private int timeFinished;
    private FSCvoucher next;

    FSCvoucher(int ID, String firstName, String lastName, String code, int timeStarted, int timeFinished) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.code = code;
        this.timeStarted = timeStarted;
        this.timeFinished = timeFinished;
        // set next to null
        this.next = null;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public int getTimeStarted() {
        return timeStarted;
    }
    public void setTimeStarted(int timeStarted) {
        this.timeStarted = timeStarted;
    }
    public int getTimeFinished() {
        return timeFinished;
    }
    public void setTimeFinished(int timeFinished) {
        this.timeFinished = timeFinished;
    }
    public FSCvoucher getNext() {
        return next;
    }
    public void setNext(FSCvoucher next) {
        this.next = next;
    }
}
