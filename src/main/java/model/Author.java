package model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {


    private String authorName;
    private String authorSurName;
    private String email;
    private String gender;

}
