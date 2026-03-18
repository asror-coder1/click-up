package asror_uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String name;
    private String description;
    private Long status_id;
    private Long category_id;
    private Long priority_id;
    private Long parent_task_id;
    private Date started_date;
    private boolean start_time_has;
    private Date due_date;
    private boolean due_time_has;
    private Long estimate_time;
    private Date actived_date;
}
