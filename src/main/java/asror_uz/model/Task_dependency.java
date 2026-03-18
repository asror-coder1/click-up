package asror_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task_dependency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Task task;
    
    @ManyToOne
    private Task dependency_task;
    
    @Enumerated(EnumType.STRING)
    private DependencyType dependency_type;
    
    public enum DependencyType {
        WAITING, BLOCKING, LINKS
    }
}
