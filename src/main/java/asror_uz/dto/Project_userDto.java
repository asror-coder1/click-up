package asror_uz.dto;

import asror_uz.model.Project_user;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project_userDto {
    private Long project_id;
    private Long user_id;
    private Project_user.TaskPermission task_permission;
}
