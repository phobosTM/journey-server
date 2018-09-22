package kz.phobos.tm.core.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event_user_map", schema = "phobos_journey_core", catalog = "")
public class EventUserMap {
    private int id;
    private int eventId;
    private int userId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "event_id")
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventUserMap that = (EventUserMap) o;
        return id == that.id &&
                eventId == that.eventId &&
                userId == that.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, eventId, userId);
    }
}
