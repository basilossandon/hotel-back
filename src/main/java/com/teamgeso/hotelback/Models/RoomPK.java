package com.teamgeso.hotelback.Models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class RoomPK implements Serializable {
    private int id;
    private int roomTypeId;

    @Column(name = "id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "roomType_id")
    @Id
    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoomPK roomPK = (RoomPK) o;

        if (id != roomPK.id) return false;
        if (roomTypeId != roomPK.roomTypeId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + roomTypeId;
        return result;
    }
}
