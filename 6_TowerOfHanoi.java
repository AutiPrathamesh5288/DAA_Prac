

public class TowerOfHanoi {

    public static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Move n-1 disks from source to auxiliary peg using destination peg
        towerOfHanoi(n - 1, source, destination, auxiliary);

        // Move the nth disk from source to destination peg
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Move the n-1 disks from auxiliary peg to destination peg using source peg
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        char source = 'A', auxiliary = 'B', destination = 'C';

        System.out.println("Tower of Hanoi solution for " + n + " disks:");
        towerOfHanoi(n, source, auxiliary, destination);
    }
}

