package asror_uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceDto {
    private String name;
    private String color;
    private Long workspace_id;
    private String  initial_letter;
    private Long icon_id;
    private Long avatar_id;
    private Long owner_id;
    private String access_type;
}
