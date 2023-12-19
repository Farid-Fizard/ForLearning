package com.example.demo.client;

import com.example.demo.domain.Room;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface RoomApiClient {
    List<Room> getRooms();
    Optional<Room>getRoomById(long id);
    Room add(Room room);
    Room update(Room Room);

}
