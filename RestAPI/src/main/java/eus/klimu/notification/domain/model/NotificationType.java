package eus.klimu.notification.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Entity(name = "notification_type")
public class NotificationType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    private String type; // info, warning, danger, etc.

    public static NotificationType generateNotificationType(NotificationTypeDTO notificationTypeDTO) {
        return new NotificationType(
                notificationTypeDTO.getId(), notificationTypeDTO.getName(),
                notificationTypeDTO.getDescription(), notificationTypeDTO.getType()
        );
    }

}
