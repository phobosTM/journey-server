package kz.phobos.tm.core.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "route_status", schema = "phobos_journey_core", catalog = "")
public class RouteStatus {
    private int id;
    private String name;
    private String description;

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RouteStatus routeStatus = (RouteStatus) o;
        return id == routeStatus.id &&
                Objects.equals(name, routeStatus.name) &&
                Objects.equals(description, routeStatus.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
