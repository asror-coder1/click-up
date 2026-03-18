package asror_uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task_attachmentDto {
    private Long task_id;
    private Long attachment_id;
    private boolean pin_cover_image;
}
