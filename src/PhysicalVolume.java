import java.util.UUID;
import java.util.ArrayList;

public class PhysicalVolume extends HardDrive{

    private HardDrive hd;

    public PhysicalVolume(String name, int size, UUID uuid, HardDrive hd){
        super(name,size,uuid);
        this.hd = hd;
    }

    public HardDrive getHardDrive() {
        return hd;
    }
}
