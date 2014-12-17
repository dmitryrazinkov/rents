package rent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.entitys.Room;
import rent.repositories.RoomRepository;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    public Room findOne(Integer id){
        return roomRepository.findOne(id);
    }

    public Room update(Integer id, Room room){
        Room updateRoom=roomRepository.findOne(id);
        updateRoom.setFloor(room.getFloor());
        updateRoom.setArea(room.getArea());
        updateRoom.setNum(room.getNum());
        return  roomRepository.save(updateRoom);
    }

    public void delete(Integer id){
        roomRepository.delete(id);
    }
}
