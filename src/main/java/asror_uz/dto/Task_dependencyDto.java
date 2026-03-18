package asror_uz.dto;

import asror_uz.model.Task_dependency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task_dependencyDto {
    private Long task_id;
    private Long dependency_task_id;
    private Task_dependency.DependencyType dependency_type;
}
