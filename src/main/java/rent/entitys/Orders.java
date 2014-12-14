package rent.entitys;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date startDate;

    private Date endDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CompId")
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "RoomId")
    private Room room;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Orders( Date startDate, Date endDate, Company company, Room room) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.company = company;
        company.getOrders().add(this);
        this.room = room;
        room.getOrders().add(this);
    }

    public Orders() {
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", company=" + company +
                ", room=" + room +
                '}';
    }
}
