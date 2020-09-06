package softplan;

public class Main {

    public static void main(String[] args) {

        int tapeAmount = 0;

        Allocation allocation = new Allocation();

        int[] fileList = allocation.getFileSizes();
        int tapeSize = allocation.getTapeSize();
        int newTape = tapeSize;

        for (int indexFile = 0; indexFile < fileList.length; indexFile++) {

            if (tapeSize >= fileList[indexFile]) {
                tapeSize = tapeSize - fileList[indexFile];
            } else if (tapeSize < fileList[indexFile]) {

                for (int tape = tapeSize; tape <= fileList[indexFile]; tape+=tapeSize) {
                    tapeAmount++;
                }
            }

            if (tapeSize <= 0) {
                tapeAmount++;
                tapeSize = newTape;
            }
        }

        if (tapeSize < newTape) {
            tapeAmount++;
        }
        System.out.println("The number of disk/tape for the given files is: " + tapeAmount + " disks");

    }
}
