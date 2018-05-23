public class MaxHeap {

    int[] maxHeap;
    int numberOfElements;
    final int emptyValue = 0;

    public MaxHeap() {
        create(10);
    }

    public MaxHeap(int i) {
        create(i);
    }

    private void create(int integer) {
        maxHeap = new int[integer];
        numberOfElements = 0;
    }

    private void increase() {
        int newSize = maxHeap.length * 2;

        int[] temp = new int[newSize];
        for (int i = 0; i < maxHeap.length; i++) {
            temp[i] = maxHeap[i];
        }

        maxHeap = new int[newSize];
        for (int i = 0; i <= newSize; i++) { //store everything from newArray into c
            maxHeap[i] = temp[i];
        }
    }

    public void insert(int integer) {
        if (numberOfElements == maxHeap.length) {
            increase();
        }
        boolean done = false;
        boolean duplicate = false;

        int i = 0;
        while (!done) { //insert number into last available space
            if (maxHeap[i] == integer) {
                duplicate = true;
                done = true;
                continue;
            }

            if (maxHeap[i] == emptyValue) {
                maxHeap[i] = integer;
                done = true;
                numberOfElements++;
            }
            if (!duplicate && !done) {
                i++;
            }
        }

        while (!duplicate && (i > 0 && maxHeap[i] > maxHeap[i / 2])) { //reheap
            int temp = maxHeap[i / 2];
            maxHeap[i / 2] = maxHeap[i];
            maxHeap[i] = temp;
            i = i / 2;
        }
    }

    public void delete(int integer) {
        boolean found = false;
        int i = 0;
        while (!found && i < numberOfElements) {
            if (maxHeap[i] == integer) {
                found = true;
                maxHeap[i] = 0;
            }
            if (!found) {
                i++;
            }
        }

        if (found) {
            while (i >= 0 && numberOfElements > i * 2 + 1  &&
                    ((maxHeap[i] < maxHeap[i * 2]) || (maxHeap[i] < maxHeap[i * 2 + 1])
                    ||
                    (maxHeap[i] < maxHeap[i * 2]) && (maxHeap[i] < maxHeap[i * 2 + 1])
                    )) {
                
                if (maxHeap[i] < maxHeap[i * 2]) {
                    int temp = maxHeap[i * 2];
                    maxHeap[i * 2] = maxHeap[i];
                    maxHeap[i] = temp;
                    i = i * 2;
                }
                if (maxHeap[i] < maxHeap[i * 2 + 1]) {
                    int temp = maxHeap[i * 2 + 1];
                    maxHeap[i * 2 + 1] = maxHeap[i];
                    maxHeap[i] = temp;
                    i = i * 2 + 1;
                }
            }
            numberOfElements--;
            
            
            //makes sure maxheap is a complete tree
            if (numberOfElements > 0 && maxHeap[numberOfElements - 1] == emptyValue){
                maxHeap[numberOfElements - 1] = maxHeap[numberOfElements];
                maxHeap[numberOfElements] = emptyValue;
        }
                
            
        }
    }

    public void printArray() {
        System.out.println("##############################");
        
        int i = 0;
        
        while (i < maxHeap.length && maxHeap[i] != 0 ){
            System.out.println(maxHeap[i]);
            i++;
        }
        System.out.println("##############################");
    }

    public void printShowPreds() {
        for (int i = 0; i < maxHeap.length; i++) {
            if (maxHeap[i] != 0) {
                System.out.println("Node number : " + i);
                System.out.println("Slot member : " + maxHeap[i]);

                if (i * 2 < numberOfElements && i != 0) {
                    System.out.println("Parent 1    : " + maxHeap[i * 2]);
                }
                if (i * 2 + 1 < numberOfElements) {
                    System.out.println("Parent 2    : " + maxHeap[i * 2 + 1]);
                }
                System.out.println("##############################");
            }
        }
    }
///////////////////////////////////////////////////////////////////////////////
}
