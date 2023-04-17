import java.util.*;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<HardDrive> drives = new ArrayList<>();
        ArrayList<PhysicalVolume> pvs = new ArrayList<>();
        ArrayList<VolumeGroup> vgs = new ArrayList<>();
        ArrayList<LogicalVolumes> lvs = new ArrayList<>();

        // Load data from file if it exists
        // TODO: Implement this

        while (true) {
            System.out.print("Enter command: ");
            String command = sc.nextLine();

            if (command.equals("exit")) {
                // Save data to file before exiting
                // TODO: Implement this
                break;
            } else if (command.startsWith("install-drive")) {
                String[] params = command.split(" " );
                String name = params[1].substring(1,params[1].length()-1);
                String size = params[2].substring(2,params[2].length()-1);
                boolean alreadyInstalled = false;
                for (HardDrive drive : drives) {
                    if (drive.getName().equals(name)) {
                        System.out.println("Drive already installed.");
                        alreadyInstalled = true;
                        break;
                    }
                }
                if (!alreadyInstalled) {
                    HardDrive drive = new HardDrive(name, Integer.parseInt(size), UUID.randomUUID());
                    drives.add(drive);
                    System.out.println("Drive installed with UUID " + drive.getUUID());
                }
            } else if (command.equals("list-drives")) {
                System.out.println("Drives:");
                for (HardDrive drive : drives) {
                    System.out.println(drive.getName() + " [" + drive.getSize() + "] [" + drive.getUUID() + "]");
                }
            } else if (command.startsWith("pvcreate")) {
                String[] params = command.split(" ");
                String name = params[1].substring(1,params[1].length()-1);
                String driveName = params[2].substring(1,params[2].length()-1);
                boolean driveExists = false;
                for (HardDrive drive : drives) {
                    if (drive.getName().equals(driveName)) {
                        driveExists = true;
                        boolean driveAlreadyUsed = false;
                        for (PhysicalVolume pv : pvs) {
                            if (pv.getHardDrive().equals(drive)) {
                                System.out.println("Drive already used by another PV.");
                                driveAlreadyUsed = true;
                                break;
                            }
                        }
                        if (!driveAlreadyUsed) {
                            boolean nameExists = false;
                            for (PhysicalVolume pv : pvs) {
                                if (pv.getName().equals(name)) {
                                    System.out.println("Physical volume name already exists.");
                                    nameExists = true;
                                    break;
                                }
                            }
                            if (!nameExists) {
                                PhysicalVolume pv = new PhysicalVolume(name, drive.getSize(), UUID.randomUUID(), drive);
                                pvs.add(pv);
                                System.out.println("Physical volume created with UUID " + pv.getUUID());
                            }
                        }
                        break;
                    }
                }
                if (!driveExists) {
                    System.out.println("Drive doesn't exist.");
                }
            } else if (command.equals("pvlist")) {
                System.out.println("Physical Volumes:");
                for (PhysicalVolume pv : pvs) {
                    System.out.print(pv.getName() + ": [" + pv.getHardDrive().getSize() + "]");
                    boolean partOfVG = false;
                    for (VolumeGroup vg : vgs) {
                        if (vg.getPhysicalVolumes() == pvs) {
                            System.out.print(" [" + vg.getName() + "]");
                            partOfVG = true;
                            break;
                        }
                    }
                    if (!partOfVG) {
                        System.out.print(" [Not part of a VG]");
                    }
                    System.out.println(" [" + pv.getUUID() + "]");
                }
            }
        }
    }
}