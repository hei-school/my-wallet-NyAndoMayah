import java.util.UUID;

public class Doc {
    private UUID id;
    private String label;
    private String description;
    private UUID typeId;

    public Doc(String label, String description, UUID typeId) {
        this.id = UUID.randomUUID();
        this.label = label;
        this.description = description;
        this.typeId = typeId;
    }

    public UUID getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getTypeId() {
        return typeId;
    }

    public void setTypeId(UUID typeId) {
        this.typeId = typeId;
    }
}
