package asror_uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceUserDto {
    private Long workspace_id;
    private Long user_id;
    private Long workspace_role_id;
    private LocalDateTime date_invited;
    private Date date_joined;
}
