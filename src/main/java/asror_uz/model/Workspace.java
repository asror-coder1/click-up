package asror_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "workspace")
public class Workspace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1 ga ohib ketadi id
    private Long id;
    private String name;
    private String color;
    @ManyToMany
    private List<User> owner_id;
    private String initial_letter;
    @ManyToMany
    private List<Attachmet> avatar_id;
}
