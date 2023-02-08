package scheper.mateus.springgpt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClient;

    private String name;
    private String address;
    private Date registerDate;
    private boolean active;

    public void updateClient(Client updatedClient) {
        this.name = updatedClient.getName();
        this.address = updatedClient.getAddress();
        this.registerDate = updatedClient.getRegisterDate();
        this.active = updatedClient.isActive();
    }

}



