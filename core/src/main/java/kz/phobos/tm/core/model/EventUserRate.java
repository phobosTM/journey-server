package kz.phobos.tm.core.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "event_user_rate", schema = "phobos_journey_core", catalog = "")
public class EventUserRate {
    private int id;
    private int userId;
    private int eventId;
    private String userComment;
    private int rateValueId;

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
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
    @Column(name = "user_comment")
    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    @Basic
    @Column(name = "rate_value_id")
    public int getRateValueId() {
        return rateValueId;
    }

    public void setRateValueId(int rateValueId) {
        this.rateValueId = rateValueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventUserRate that = (EventUserRate) o;
        return id == that.id &&
                userId == that.userId &&
                eventId == that.eventId &&
                rateValueId == that.rateValueId &&
                Objects.equals(userComment, that.userComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, eventId, userComment, rateValueId);
    }
}
