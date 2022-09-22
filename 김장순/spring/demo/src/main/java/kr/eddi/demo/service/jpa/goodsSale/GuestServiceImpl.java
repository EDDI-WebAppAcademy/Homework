package kr.eddi.demo.service.jpa.goodsSale;

import kr.eddi.demo.entity.jpa.goodsSaleBoards.Guest;
import kr.eddi.demo.entity.jpa.goodsSaleBoards.request.JoinRequest;
import kr.eddi.demo.repository.goodsSale.GuestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GuestServiceImpl implements GuestService{

    @Autowired
    GuestRepository guestRepository;

    @Override
    public List<Guest> list(){

        return guestRepository.findAll(Sort.by(Sort.Direction.DESC,"guestNo"));
    }

    @Override
    public void join(JoinRequest joinRequest){
        Guest guest = new Guest();
        guest.setId(joinRequest.getId());
        guest.setPassword(joinRequest.getPassword());
        guest.setEmail(joinRequest.getEmail());

        guestRepository.save(guest);
    }
}
