package com.collections.queue;

import com.designpattern.builderspattern.components.Engine;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.function.Predicate;

import static com.collections.queue.Category.PRINTER;

public class HelpDesk {
    private final Queue<Enquiry> enquiries = new ArrayDeque<>();

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer, category));
    }

    public void processPrinterEnquiry() {
        processEnquiry(
                enq -> enq.getCategory() == PRINTER,
                "Is it out of paper?");
    }

    public void processGeneralEnquiry() {
        processEnquiry(
                enq -> enq.getCategory() != PRINTER,
                "Have you tried turning it off and on again?");
    }

    private void processEnquiry(Predicate<Enquiry> predicate, String message) {
        final Enquiry enquiry = enquiries.peek();
        if (enquiry != null && predicate.test(enquiry)) {
            enquiries.remove();
            enquiry.getCustomer().reply(message);
        } else {
            System.out.println("No work to do, let's have some coffee!");
        }
    }


    public static void main(String[] args) {
        HelpDesk helpDesk = new HelpDesk();

        helpDesk.enquire(Customer.JACK, Category.PHONE);
        helpDesk.enquire(Customer.JILL, PRINTER);

        helpDesk.processPrinterEnquiry();
        helpDesk.processGeneralEnquiry();
        helpDesk.processPrinterEnquiry();
    }
}
