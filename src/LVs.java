import java.util.UUID;
public class LVs {
    private UUID uuid;

    private String name;

    private int size;

    private int volumeGroup;


    public LVs(String name, int size, int volumeGroup)
    {
        uuid = UUID.randomUUID()
        this.name = name;
        this.size = size;
        this.volumeGroup = volumeGroup;
    }


}
