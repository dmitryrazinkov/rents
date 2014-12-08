package rent.entitys;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer num;


    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="busId")
    private BussinesCenter bussinesCenter;

    private Integer floor;

    private BigDecimal area;

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
}
