package asror_uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Time_trackedDto {
    private Long task_id;
    private Date started_at;
    private Date stopped_at;
}
