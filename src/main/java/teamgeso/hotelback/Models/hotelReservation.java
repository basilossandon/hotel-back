package teamgeso.hotelback.Models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "hotel", catalog = "")
public class hotelReservation {
    private int reservationId;
    private Timestamp start;
    private Timestamp end;
    private Double finalPrice;
    private String code;
    private String documentNumber;
    private String checkinName;
    private int roomId;
    private String type;

    @Id
    @Column(name = "reservation_id")
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Basic
    @Column(name = "start")
    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    @Basic
    @Column(name = "end")
    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    @Basic
    @Column(name = "final_price")
    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    @Basic
    @Column(name = "code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "document_number")
    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Basic
    @Column(name = "checkin_name")
    public String getCheckinName() {
        return checkinName;
    }

    public void setCheckinName(String checkinName) {
        this.checkinName = checkinName;
    }

    @Id
    @Column(name = "room_id")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        hotelReservation that = (hotelReservation) o;
        return reservationId == that.reservationId &&
                roomId == that.roomId &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end) &&
                Objects.equals(finalPrice, that.finalPrice) &&
                Objects.equals(code, that.code) &&
                Objects.equals(documentNumber, that.documentNumber) &&
                Objects.equals(checkinName, that.checkinName) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, start, end, finalPrice, code, documentNumber, checkinName, roomId, type);
    }
}
