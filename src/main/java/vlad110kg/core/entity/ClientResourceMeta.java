package vlad110kg.core.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientResourceMeta extends DatedEntity {

    private Client client;
    private Resource resource;
    private String meta;
}
