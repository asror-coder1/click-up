package asror_uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task_historyDto {
    private Long task_id;
    private String change_field_name;
    private String before;
    private String after;
    private String date;
}
