import java.util.UUID;
public class HardDrive {
    private UUID uuid;

    private String name;

    private int size;

    public HardDrive(String name, int size, UUID uuid)
    {

        this.uuid = uuid;
        this.name = name;
        this.size = size;


    }

    public UUID getUuid() {
        return uuid;

    }

    public String getName() {
        return name;

    }

    public int getSize() {
        return size;

    }




}
