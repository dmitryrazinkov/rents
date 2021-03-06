package rent.entitys;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BussinesCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name of center can't be empty")
    private String name;

    @OneToMany(mappedBy = "bussinesCenter", fetch = FetchType.EAGER)
    private List<Room> rooms = new ArrayList<Room>();

    public BussinesCenter(String name) {
        this.name = name;
    }

    public BussinesCenter() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BussinesCenter)) return false;

        BussinesCenter that = (BussinesCenter) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BussinesCenter{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
