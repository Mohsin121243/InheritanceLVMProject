import java.util.UUID;

public class LogicalVolumes extends HardDrive {
    private VolumeGroup v;
    public LogicalVolumes(String name, int size, UUID uuid, VolumeGroup v){
        super(name,size,uuid);
        this.v = v;
    }

}
