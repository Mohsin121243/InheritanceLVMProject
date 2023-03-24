import java.util.ArrayList;
import java.util.UUID;

public class VolumeGroup extends HardDrive{

    private ArrayList<LogicalVolumes> lvList;

    private ArrayList<PhysicalVolume> pvList;

    public VolumeGroup(String name,int size, UUID uuid){
        super(name, size,uuid);
    }

    public void addLogicalVolumes(LogicalVolumes l){
        lvList.add(l);
    }
    public void addPhysicalVolumes(PhysicalVolume p){
        pvList.add(p);
    }

    public double getNumOfFreeSpace(){
        double lVspace = 0;
        for(int i = 0; i < lvList.size();i++){
            lVspace+=lvList.get(i).getSize();
        }
        double pvSpace = 0;
        for(int j = 0; j < pvList.size();j++){
            pvSpace+=pvList.get(j).getSize();
        }
        if(lVspace- pvSpace>0){
            return lVspace-pvSpace;
        }
        else {return 0;}

    }

}
