import java.util.UUID;

public class Type {
    private UUID id;
    private String name;
    private boolean isUnique;

    public Type(String name, boolean isUnique) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.isUnique = isUnique;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
