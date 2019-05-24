package com.teamgeso.hotelback.Controllers;
import java.util.List;

import com.teamgeso.hotelback.DAO.RoomDAO;
import com.teamgeso.hotelback.Models.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class roomController {

    @Autowired
    RoomDAO roomDAO;

    @GetMapping("/rooms")
    public List<Room> getHabitacionesAll(){
        try{
            return roomDAO.getAll();
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
