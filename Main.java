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
import java.util.*;
class Main {
    public static void main(String[] args) {

        // initialize day count to keep track of the days (FOR PRINTING)
        int daysCount = 1;

        // Create a scanner
        Scanner in = new Scanner(System.in);

        // maxQ determine the maximum number of people in the waiting queue
        // made it a plus one because you don't count the car being serviced
        int maxQ = in.nextInt() + 1;

        // how many days is the car wash open
        int numDays = in.nextInt();

        // create welcome statement
        System.out.println("Welcome to the FSC Car Clean Simulator\n");

        // To make the car was work will be a while loop for the days
        // Inside the days loop will be a for loop to queue everyone in the outside line and nested while loops that will progressively queue cars from the outside queue into the inside queue
        // As well as a bunch of if statements
        while (numDays > 0){

            // get the time for a wash, wax, and vacuum
            int washTime =  in.nextInt();
            int waxTime =  in.nextInt();
            int vacTime = in.nextInt();

            // get number of customers
            int customers =  in.nextInt();

            // eat the next line
            in.nextLine();

            // create the outside queue from CUSTOM queue class
            FSCcarwashQ outsideQ =  new FSCcarwashQ();

            // loop through the customer size and queue in all customers into outsideQ
            for (int i = 0; i < customers; i++) {

                // get the customers
                String c = in.nextLine();
                // split customer line
                String[] split = c.split(" ");

                // create customer object
                FSCmember newMember = new FSCmember(Integer.parseInt(split[0]), Integer.parseInt(split[1]), split[2], split[3], split[4]);

                // SET the duration of the wash for each customer
                // setMinutesRemaining will be decremented
                // setMinutesStatic will not be touch and used to calculate time
                if (newMember.getCode().equals("WWV")) {
                    newMember.setMinutesRemaining(washTime + waxTime + vacTime);
                    newMember.setMinutesStatic(washTime + waxTime + vacTime);
                }
                else if (newMember.getCode().equals("WW")) {
                    newMember.setMinutesRemaining(washTime + waxTime);
                    newMember.setMinutesStatic(washTime + waxTime);
                }
                else if (newMember.getCode().equals("W")) {
                    newMember.setMinutesRemaining(washTime);
                    newMember.setMinutesStatic(washTime);
                }

                // once all the data fields for the customer have been recorded, add them to the queue
                outsideQ.enqueue(newMember);
            }

            // create the inside queue and voucher STACK
            FSCcarwashQ insideQ = new FSCcarwashQ();
            FSCvouchers voucher = new FSCvouchers();

            // keep track of the number of customers inside the insideQ
            int numCustomersInside = 0;

            // initialize the minutes
            int minutes = 0;

            // create the days counter
            System.out.println("**********");
            System.out.printf("Day %d:\n",  daysCount);
            System.out.println("**********");
            System.out.println();
            // increment days
            daysCount++;

            // this while loop will keep track of minutes that the car wash is open and if there are any customers inside
            // use OR so that if time goes over but there are still customers inside they still get their car washed
            while (minutes < 360 || numCustomersInside > 0) {

                // this loop will ADD customer into the inside queue and dequeue them from the outside queue IF outside queue is not empty AND
                // the customers arrival time IS EQUAL to the minutes
                while (!outsideQ.isEmpty() && outsideQ.peek().getArrivalTime() == minutes) {

                    // IF the insideQ is not full process the car into the insideQ
                    if (numCustomersInside < maxQ) {

                        // IF there is no one else in the line, the car immediately gets washed
                        if (insideQ.isEmpty()) {
                            System.out.printf("%s  %s %s arrived at the FSC Car Clean and immediately started Class %s service.\n", timeConverter(minutes), outsideQ.peek().getFirstName(), outsideQ.peek().getLastName(), outsideQ.peek().getCode());
                            FSCmember member = outsideQ.dequeue();
                            member.setTimeStarted(minutes);
                            insideQ.enqueue(member);
                        }
                        // ELSE they wait in the line until it is their time
                        else {
                            System.out.printf("%s  %s %s arrived at the FSC Car Clean and entered Wash Queue.\n", timeConverter(minutes), outsideQ.peek().getFirstName(), outsideQ.peek().getLastName());
                            FSCmember member = outsideQ.dequeue();
                            // DONT set time started here BECAUSE they are waiting
                            insideQ.enqueue(member);
                        }

                        // increment the number of customer in line
                        numCustomersInside++;
                    }
                    // ELSE they have to leave, dequeue from outside line ONLY
                    else {
                        System.out.printf("%s  %s %s arrived at the FSC Car Clean. Unfortunately, the Wash Queue is full, and the customer left disappointed.\n", timeConverter(minutes), outsideQ.peek().getFirstName(), outsideQ.peek().getLastName());
                        outsideQ.dequeue();
                    }
                }

                // IF the inside queue is NOT empty then wash the car
                if (!insideQ.isEmpty()) {

                    // IF the car is not the MINION wash the car
                    if (!insideQ.peek().getCode().equals("Z")) {

                        // decrement the car to simulate the car being washed according to their code
                        insideQ.peek().setMinutesRemaining(insideQ.peek().getMinutesRemaining() - 1);

                        // ONCE the car has been washed create their voucher, state how long they waited, service time, and total time, as well as address who is next
                        if (insideQ.peek().getMinutesRemaining() == 0) {

                            // calculate the customers time in line and service
                            int finished = minutes + 1;
                            int wait = (insideQ.peek().getTimeStarted() - insideQ.peek().getArrivalTime());
                            int service = insideQ.peek().getMinutesStatic();
                            int total = wait + service;

                            // make the voucher
                            FSCvoucher newVouch = new FSCvoucher(insideQ.peek().getID(), insideQ.peek().getFirstName(), insideQ.peek().getLastName(), insideQ.peek().getCode(), insideQ.peek().getTimeStarted(), finished);

                            // push voucher into stack
                            voucher.push(newVouch);

                            // print out the stats
                            System.out.printf("%s  The car for %s %s is now finished.%n           Waiting time in line: %d minutes%n           Service time: %d minutes%n           Total time: %d minutes%n",
                                    timeConverter(minutes + 1), insideQ.peek().getFirstName(), insideQ.peek().getLastName(), wait, service, total
                            );

                            // remove the customer from the line
                            insideQ.dequeue();
                            // decrement the number of customers in the line
                            numCustomersInside--;

                            // IF the insideQ is not empty, then state the next customer
                            if (insideQ.peek() != null) {
                                // set the next customers start time to the previous customer finish time
                                insideQ.peek().setTimeStarted(finished);
                                // print out who has started the next service
                                System.out.printf("%s  %s %s has now started Class %s service.\n", timeConverter(finished), insideQ.peek().getFirstName(), insideQ.peek().getLastName(), insideQ.peek().getCode());
                            }
                        }
                    }

                    // ELSE, the lowly minion has come in the middle of the day
                    // record the vouchers, clear the stack, dequeue the minion, and decrement customers inside
                    else {
                        System.out.printf("%s  LOWLY Minion came and collected the following vouchers:\n", timeConverter(minutes));
                        voucher.PrintStack();
                        voucher.clear();
                        insideQ.dequeue();
                        numCustomersInside--;
                    }
                }
                // increment minutes
                minutes++;
            }

            // IF the minion comes at the end of the day do the same as before
            System.out.println(" 4:00 PM:  LOWLY Minion came and collected the following vouchers:");
            voucher.PrintStack();

            voucher.clear();
            insideQ.clear();
            outsideQ.clear();

            // decrement days
            numDays--;
            // new line for correct output
            System.out.println();
        }

    }

    // This method will server as converting the minutes into time between 10 AM to 4 PM
    public static String timeConverter(int minutes) {

        // every 60 minutes is an hour and add 10 because the car wash starts at 10 PM
        int hour = 10 + (minutes / 60);
        // mod 60 to get remainder which is the minutes
        int minute = (minutes % 60);

        // car wash starts in the morning
        String timeOfDay = "AM";

        // if the hour is greater or equal to 12 then timeOfDay is PM
        if (hour >= 12) {
            timeOfDay = "PM";

            // Need to adjust for after twelve (not military time)
            if (hour > 12) {
                hour -= 12;
                return String.format(" %d:%02d %s:", hour, minute, timeOfDay);
            }
        }

        // format the string so it prints as hour:minute tOd:
        return String.format("%d:%02d %s:", hour, minute, timeOfDay);

    }
}