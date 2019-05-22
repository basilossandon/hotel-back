package teamgeso.hotelback.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "roomtype", schema = "hotel", catalog = "")
public class Roomtype {
    private int roomtypeId;
    private String type;
    private Double price;

    @Id
    @Column(name = "roomtype_id")
    public int getRoomtypeId() {
        return roomtypeId;
    }

    public void setRoomtypeId(int roomtypeId) {
        this.roomtypeId = roomtypeId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roomtype that = (Roomtype) o;
        return roomtypeId == that.roomtypeId &&
                Objects.equals(type, that.type) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomtypeId, type, price);
    }
}
