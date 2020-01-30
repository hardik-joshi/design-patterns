package com.collections.queue;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

import static com.collections.queue.Category.PHONE;
import static com.collections.queue.Category.COMPUTER;
import static com.collections.queue.Category.PRINTER;

public class PriorityHelpDesk {
    private static final Comparator<Enquiry> BY_CATEGORY = new Comparator<Enquiry>() {
        @Override
        public int compare(final Enquiry o1, final Enquiry o2) {
            return o1.getCategory().compareTo(o2.getCategory());
        }
    };

    private final Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);

    public void enquire(final Customer customer, final Category category) {
        enquiries.offer(new Enquiry(customer, category));
    }

    private void processAllEnquiries() {
        Enquiry enquiry;
        while ((enquiry = enquiries.poll()) != null) {
            enquiry.getCustomer().reply("Have you tried turning it off and on again?");
        }
    }


    public static void main(String[] args) {
        PriorityHelpDesk helpDesk = new PriorityHelpDesk();

        helpDesk.enquire(Customer.JACK, PHONE);
        helpDesk.enquire(Customer.JILL, PRINTER);
        helpDesk.enquire(Customer.MARY, COMPUTER);

        helpDesk.processAllEnquiries();
    }
}
