package rent.entitys;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Enter number.")
    private Integer num;


    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="busId")
    private BussinesCenter bussinesCenter;

    @OneToMany(mappedBy = "room", fetch = FetchType.EAGER)
    List<Orders> orders= new ArrayList<Orders>();

    @NotNull(message = "Enter floor.")
    private Integer floor;

    @NotNull(message = "Enter area.")
    private BigDecimal area;

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BussinesCenter getBussinesCenter() {
        return bussinesCenter;
    }

    public void setBussinesCenter(BussinesCenter bussinesCenter) {
        this.bussinesCenter = bussinesCenter;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Room() {
    }

    public Room(Integer num, BussinesCenter bussinesCenter, Integer floor, BigDecimal area) {
        this.num = num;
        this.bussinesCenter = bussinesCenter;
        bussinesCenter.getRooms().add(this);
        this.floor = floor;
        this.area = area;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", num=" + num +
                ", bussinesCenter=" + bussinesCenter +
                ", floor=" + floor +
                ", area=" + area +
                '}';
    }
}
