package io.scsr.scsr.domain;

import lombok.*;

import jakarta.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
}
