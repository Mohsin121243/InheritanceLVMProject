import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Logical Volume Manager!");
        Scanner s = new Scanner(System.in);
        String command = s.nextLine();
        if(command.contains("install-drive sda")){
            String stringSize = command.substring(18,command.length()-2);
            int size = Integer.parseInt(stringSize);
            UUID uuid1 = UUID.randomUUID();
            HardDrive h1 = new HardDrive("sda",size, uuid1);
        }
    }
}