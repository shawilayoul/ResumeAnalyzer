package com.shawilTech.resumeanalyzer.dto;
import jakarta.persistence.*;

import lombok.*;

@Getter
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private  Long id;
    private  String email;
    private  String role;
}
