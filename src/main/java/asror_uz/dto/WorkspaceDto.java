package asror_uz.dto;

import asror_uz.model.Attachmet;
import asror_uz.model.User;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceDto {
    private String name;
    private String color;
    private List<User> owner_id;
    private String initial_letter;
    private List<Attachmet> avatar_id;
}
