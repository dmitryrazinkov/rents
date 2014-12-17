package rent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rent.entitys.Room;
import rent.repositories.RoomRepository;

import javax.transaction.Transactional;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Transactional
    public Room addRoom(Room room){
        return roomRepository.save(room);
    }

    @Transactional
    public Room findOne(Integer id){
        return roomRepository.findOne(id);
    }

    @Transactional
    public Room update(Integer id, Room room){
        Room updateRoom=roomRepository.findOne(id);
        updateRoom.setFloor(room.getFloor());
        updateRoom.setArea(room.getArea());
        updateRoom.setNum(room.getNum());
        return  roomRepository.save(updateRoom);
    }

    @Transactional
    public void delete(Integer id){
        roomRepository.delete(id);
    }
}
