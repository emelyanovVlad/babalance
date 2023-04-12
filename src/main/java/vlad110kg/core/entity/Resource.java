package vlad110kg.core.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
//@Table(name = "resource")
public class Resource extends IdDatedEntity {

    @Column(name = "title", nullable = false, unique = true)
    private String title;
    @Column(name = "base_url", nullable = false)
    private String baseUrl;
    @Column(name = "auth_type", nullable = false)
    private AuthType authType;
}
