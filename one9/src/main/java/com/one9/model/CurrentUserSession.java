package com.one9.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentUserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique =  true)
    private String userId;

    private String uuid;

    private LocalDateTime localDateTime;

    private String type;

    public CurrentUserSession(String userId, String uuid, LocalDateTime localDateTime, String type) {
        this.userId = userId;
        this.uuid = uuid;
        this.localDateTime = localDateTime;
        this.type = type;
    }

    public CurrentUserSession(String uuid) {
        this.uuid = uuid;
    }
}
