package kr.eddi.demo.service.jpa.products;

import kr.eddi.demo.entity.jpa.products.Guest;
import kr.eddi.demo.entity.jpa.products.request.JoinRequest;

import java.util.List;

public interface GuestService {
    public List<Guest> list();

    public void join(JoinRequest joinRequest);
}
