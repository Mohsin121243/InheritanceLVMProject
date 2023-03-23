import java.util.UUID;
import java.util.ArrayList;

public class PhysicalVolume extends HardDrive{

    private HardDrive hd;

    public PhysicalVolume(String name, int size, UUID uuid){
        super(name,size,uuid);
    }

    public void addHardDrive(HardDrive hd){
        this.hd = hd;
    }

    public HardDrive getHd() {
        return hd;
    }
}
