package sll;

public class TestSllQueue {

    static final double NANOSECONDS_PER_MILLISECOND = 1E6;

    public static void main(String[] args) {
        run(10);
        run(100);
        run(1000);
        run(10000);
        run(100000);
        run(1000000);
    }

    public static void run(long itemCount) {

        Queue q = new LLQueue();

        timeEnqueue(q, itemCount);

        timeDequeue(q);

        q = null;

        System.out.println();
        System.out.println("********************************************************");
        System.out.println();

    }

    public static void timeEnqueue(Queue q, long itemCount) {
        long startEnqueueTime = System.nanoTime();

        for(long i = 0; i < itemCount; i++) {
            String s = new String();
            q.enqueue(String.format("%d:%s", i, s.hashCode()));
        }

        long endEnqueueTime = System.nanoTime();

        long nanoSecondsToEnqueue = (endEnqueueTime - startEnqueueTime);

        double millisecondsToEnqueue = nanoSecondsToEnqueue / NANOSECONDS_PER_MILLISECOND;

        String reportEnqueueTime = String.format("Enqueue took %f milliseconds for %d elements",
                millisecondsToEnqueue, itemCount);
        System.out.println(reportEnqueueTime);

        long nanoSecondsPerElement = nanoSecondsToEnqueue / itemCount;
        String reportEnqueueTimePerElement = String.format("%d nano-seconds per element.", nanoSecondsPerElement);
        System.out.println(reportEnqueueTimePerElement);


    }

    public static void timeDequeue(Queue q) {

        long itemsDequeued = 0;
        long startDequeueTime = System.nanoTime();

        while(!q.isEmpty()) {
            q.dequeue();
            itemsDequeued++;
        }

        long endDequeueTime = System.nanoTime();

        long nanoSecondsToEnqueue = (endDequeueTime - startDequeueTime);

        double millisecondsToEnqueue = nanoSecondsToEnqueue / NANOSECONDS_PER_MILLISECOND;

        String reportEnqueueTime = String.format("Dequeue took %f milliseconds for %d elements",
                millisecondsToEnqueue, itemsDequeued);
        System.out.println(reportEnqueueTime);

        long nanoSecondsPerElement = nanoSecondsToEnqueue / itemsDequeued;
        String reportDequeueTimePerElement = String.format("%d nano-seconds per element.", nanoSecondsToEnqueue);
        System.out.println(reportDequeueTimePerElement);


    }
}
