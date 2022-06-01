package eus.klimu.notification.domain.model;

import eus.klimu.location.domain.model.Location;
import eus.klimu.location.domain.service.definition.LocationService;
import eus.klimu.notification.domain.service.definition.NotificationTypeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String message;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "notification_type_id")
    private NotificationType type;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

    public static Notification generateNotification(
            NotificationDTO notificationDTO, NotificationTypeService notificationTypeService, LocationService locationService
    ) {
        return new Notification(
                notificationDTO.getId(), notificationDTO.getMessage(), notificationDTO.getDate(),
                notificationTypeService.getNotificationType(notificationDTO.getNotificationTypeId()),
                locationService.getLocationById(notificationDTO.getLocationId())
        );
    }

}
