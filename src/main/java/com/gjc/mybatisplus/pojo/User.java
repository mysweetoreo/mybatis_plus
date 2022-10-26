package com.gjc.mybatisplus.pojo;

import lombok.*;

/*@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode*/
@Data
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;
}
