package asror_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category_user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @ManyToOne
    private Category category;
    
    @ManyToOne
    private User user;
    
    @Enumerated(EnumType.STRING)
    private TaskPermission task_permission;
    
    public enum TaskPermission {
        READ, WRITE, ADMIN
    }
}
