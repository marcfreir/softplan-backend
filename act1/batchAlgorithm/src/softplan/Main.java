package softplan;

public class Main {

    public static void main(String[] args) {

        int tapeAmount = 0;

        Allocation allocation = new Allocation();

        int[] fileList = allocation.getFileSizes();
        int tapeSize = allocation.getTapeSize();

        int temp;

        //Sort the array in descending order
        for (int index = 0; index < fileList.length; index++) {
            for (int jindex = index+1; jindex < fileList.length; jindex++) {
                if(fileList[index] < fileList[jindex]) {
                    temp = fileList[index];
                    fileList[index] = fileList[jindex];
                    fileList[jindex] = temp;
                }
            }
        }

        //Now, read the reordered array
        for (int index = 0; index < fileList.length; index++) {
            for (int jindex = index+1; jindex < fileList.length; jindex++) {
                if (fileList[index] + fileList[jindex] <= tapeSize) {
                    tapeAmount = tapeAmount + 1;
                    index++;
                    break;
                }
                if (fileList[index] == tapeSize) {
                    tapeAmount = tapeAmount + 1;
                    break;
                }
            }
        }

        System.out.println("The number of disk/tape for the given files is: " + tapeAmount + " disks");

    }
}
