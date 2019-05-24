package com.teamgeso.hotelback.models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class ReservationPK implements Serializable {
    private int id;
    private int roomId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "room_id")
    @Id
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationPK that = (ReservationPK) o;

        if (id != that.id) return false;
        if (roomId != that.roomId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + roomId;
        return result;
    }
}
