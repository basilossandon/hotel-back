package com.teamgeso.hotelback.Models;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ReservationPK implements Serializable {
    private int reservationId;
    private int roomId;

    @Column(name = "reservation_id")
    @Id
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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
        return reservationId == that.reservationId &&
                roomId == that.roomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, roomId);
    }
}
