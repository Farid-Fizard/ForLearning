package com.example.demo.client;

import com.example.demo.domain.Room;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@Service
public class RoomApiClientRestTemplateImpl implements  RoomApiClient{
    private RestTemplate restTemplate;

    public RoomApiClientRestTemplateImpl() {
        this.restTemplate = new RestTemplate ();
        this.restTemplate.setErrorHandler(new RoomApiErrorHandler());
    }

    @Override
    public List<Room> getRooms() {



        String url="http://localhost:8080/room/api/";
        System.out.println("RestApiClient rooms api-sine sorgu gonderdi");
        List<Room> rooms= restTemplate.getForObject(url,List.class);
        System.out.println("RestApiClient rooms api-sinden api listi aldi"+rooms);
        return rooms;
    }

    @Override
    public Optional<Room> getRoomById(long id) {

        Optional optionalRoom= Optional.empty();
        String url=String.format("http://localhost:8080/room/api/%s",id);
        try {
            System.out.println("RestApiClient rooms api-sine sorgu gonderdi");
            Room room= restTemplate.getForObject(url,Room.class);
            System.out.println("RestApiClient rooms api-sinden room detallarini aldi"+room);
            if (room!=null){
                optionalRoom=Optional.of(room);
            }

        }
        catch ( ResourceNotFound404 e) {
            System.out.println("Bele bir otaq movcud deyil");
        }
        return optionalRoom;
    }

    @Override
    public Room add(Room room) {
        String url="http://localhost:8080/room/api/";
        System.out.println("Rooms rest api ye yeni otaq elave etme sorgusu yollanildi");
        Room newRoom = restTemplate.postForObject(url,room,Room.class);
        System.out.println("Rooms rest api den yeni otaqla bagli cavab geldi"+newRoom);

        return newRoom;
    }

    @Override
    public Room update(Room Room) {
        return null;
    }

}
