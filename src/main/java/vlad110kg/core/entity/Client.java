package vlad110kg.core.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
public class Client extends DatedEntity {
    @Id
    @JsonProperty("chat_id")
    @Column(nullable = false, unique = true)
    private Long chatId;
}
