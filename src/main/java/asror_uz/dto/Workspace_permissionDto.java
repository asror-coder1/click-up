package asror_uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Workspace_permissionDto {
    private Long workspace_role_id;
    private String permission_enum;
}
