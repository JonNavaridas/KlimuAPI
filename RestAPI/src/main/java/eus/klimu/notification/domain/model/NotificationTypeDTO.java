package eus.klimu.notification.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class NotificationTypeDTO implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String type;

}
