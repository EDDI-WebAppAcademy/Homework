package kr.eddi.demo.service.jpa.goodsSale;

import kr.eddi.demo.entity.jpa.goodsSaleBoards.Guest;
import kr.eddi.demo.entity.jpa.goodsSaleBoards.request.JoinRequest;

import java.util.List;

public interface GuestService {
    public List<Guest> list();

    public void join(JoinRequest joinRequest);
}
