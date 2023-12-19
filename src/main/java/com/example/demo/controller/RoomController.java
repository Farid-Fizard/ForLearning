package com.example.demo.controller;

import com.example.demo.client.RoomApiClient;
import com.example.demo.domain.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller("restRoomController")
@RequestMapping("/rooms")
public class RoomController {
    private RoomApiClient roomApiClient;

    public RoomController(RoomApiClient roomApiClient) {
        this.roomApiClient = roomApiClient;
    }


    @GetMapping("/")
    public ModelAndView showRooms(){
        ModelAndView mav = new ModelAndView("rooms");
        System.out.println("Web controller roomApiClienti  cagirdi");
        List<Room> roomList= roomApiClient.getRooms();
        System.out.println("roomApiClientden gelen cavab"+roomList);
        mav.addObject("rooms",roomList);
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView roomById(@PathVariable(name = "id")long id){
        ModelAndView mav = new ModelAndView("room");
        System.out.println("Web controller roomApiClienti  cagirdi");
        Optional<Room> roomOptional= roomApiClient.getRoomById(id);
        roomOptional.ifPresent(room -> mav.addObject("room", room));
        return mav;
    }
    @GetMapping("/add")
    public String addRoom(){
        return"new-room";
    }

    @PostMapping("/add")
    public String addNewRoom(@RequestParam(name = "name") String name,
                             @RequestParam(name = "capacity") int capacity,
                             @RequestParam(name = "projector") boolean projector,
                             @RequestParam(name = "whiteboard") boolean whiteboard){
        String view="redirect:/rooms/";

        try{
            Room room = new Room();
            room.setName(name);
            room.setCapacity(capacity);
            room.setProjector(projector);
            room.setWhiteboard(whiteboard);
            System.out.println("***formdan gelenler"+room);
            Room newRoom= roomApiClient.add(room);
            System.out.println("***formdan apiye gedib qayidan"+newRoom);

        }catch (Exception e){
            e.printStackTrace();
            view="error";
        }

        return view;
    }


}
