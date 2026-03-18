package asror_uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IconDto {
    private Long attachment_id;
    private String color;
    private String initial_letter;
    private String icon;
}
