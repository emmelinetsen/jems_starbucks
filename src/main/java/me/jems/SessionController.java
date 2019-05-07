package me.jems;

import org.springframework.beans.factory.annotation.Autowired;

public class SessionController {

    @Autowired
    protected SessionsRepository sessionsRepository;

    public Sessions verify(int id){
        return sessionsRepository.findOne(id);
    }

    public Sessions newSession(String username){
       return sessionsRepository.save(new Sessions(username));
    }

    public void deleteSession(int id){
        sessionsRepository.delete(id);
    }


}
