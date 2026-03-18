package asror_uz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    
    @ManyToOne
    private Status status;
    
    @ManyToOne
    private Category category;
    
    @ManyToOne
    private Priority priority;
    
    @ManyToOne
    private Task parent_task;
    
    private Date started_date;
    private boolean start_time_has;
    private Date due_date;
    private boolean due_time_has;
    private Long estimate_time;
    private Date actived_date;
}
