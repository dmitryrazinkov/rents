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
}
