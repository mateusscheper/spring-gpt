package scheper.mateus.springgpt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import scheper.mateus.springgpt.entity.Client;

import java.util.Date;

@Data
@Builder
public class ClientDTO {

    private Long idClient;

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotBlank(message = "Address cannot be blank")
    private String address;

    @NotNull(message = "Register date cannot be null")
    private Date registerDate;

    @NotNull(message = "Active flag cannot be null")
    private boolean active;

    public Client toClient() {
        return new Client(idClient, name, address, registerDate, active);
    }

    public static ClientDTO fromClient(Client client) {
        return new ClientDTO(
                client.getIdClient(),
                client.getName(),
                client.getAddress(),
                client.getRegisterDate(),
                client.isActive()
        );
    }
}


