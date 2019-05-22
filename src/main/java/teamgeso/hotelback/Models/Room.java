package teamgeso.hotelback.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "room", schema = "hotel", catalog = "")
public class Room {
    private int roomId;
    private int roomtypeId;

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Id
    @Column(name = "roomtype_id")
    public int getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(int roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room Room = (Room) o;
        return roomId == Room.roomId &&
                roomtypeId == Room.roomtypeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomtypeId);
    }
}
