package softplan;

import java.util.Scanner;

public class Allocation implements Batch {
    @Override
    public int[] getFileSizes() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of files to be stored in tapes: ");
        int fileAmount = scanner.nextInt();

        int[] fileInput = new int[fileAmount];

        System.out.println("Enter the file sizes: ");

        for (int indexFileInput = 0; indexFileInput < fileAmount; indexFileInput++) {
            int userFileInput = Integer.parseInt(scanner.next());
            fileInput[indexFileInput] = userFileInput;
        }


        //return new int[0];
        return fileInput;
    }

    @Override
    public int getTapeSize() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the tape/disk size: ");

        return scanner.nextInt();
    }
}
