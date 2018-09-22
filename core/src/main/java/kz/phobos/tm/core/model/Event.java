package kz.phobos.tm.core.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "event", schema = "phobos_journey_core", catalog = "")
public class Event {
    private int id;
    private String name;
    private int ownerId;
    private Date startDate;
    private int routeId;
    private int maxParticipants;
    private int statusId;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "owner_id")
    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Basic
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "route_id")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "max_participants")
    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    @Basic
    @Column(name = "status_id")
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                ownerId == event.ownerId &&
                routeId == event.routeId &&
                maxParticipants == event.maxParticipants &&
                statusId == event.statusId &&
                Objects.equals(name, event.name) &&
                Objects.equals(startDate, event.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ownerId, startDate, routeId, maxParticipants, statusId);
    }
}
