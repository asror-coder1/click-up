package asror_uz.dto;

import asror_uz.model.Category_user;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category_userDto {
    private String name;
    private Long category_id;
    private Long user_id;
    private Category_user.TaskPermission task_permission;
}
