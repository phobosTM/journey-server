package kz.phobos.tm.core.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "route", schema = "phobos_journey_core", catalog = "")
public class Route {
    private int id;
    private String name;
    private int levelId;
    private int length;
    private int duration;
    private int statusId;
    private int racebookBId;
    private int instaBId;

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
    @Column(name = "level_id")
    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    @Basic
    @Column(name = "length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Basic
    @Column(name = "duration")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "status_id")
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "racebook_b_id")
    public int getRacebookBId() {
        return racebookBId;
    }

    public void setRacebookBId(int racebookBId) {
        this.racebookBId = racebookBId;
    }

    @Basic
    @Column(name = "insta_b_id")
    public int getInstaBId() {
        return instaBId;
    }

    public void setInstaBId(int instaBId) {
        this.instaBId = instaBId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id &&
                levelId == route.levelId &&
                length == route.length &&
                duration == route.duration &&
                statusId == route.statusId &&
                racebookBId == route.racebookBId &&
                instaBId == route.instaBId &&
                Objects.equals(name, route.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, levelId, length, duration, statusId, racebookBId, instaBId);
    }
}
