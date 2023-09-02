package com.ilia.tacos.web;

import com.ilia.tacos.TacoOrder;
import com.ilia.tacos.data.OrderRepository;
import com.ilia.tacos.data.UserRepository;
import com.ilia.tacos.security.user.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepo;
    private final UserRepository userRepository;




    @GetMapping("/current")
    public String currentOrder(TacoOrder order, @AuthenticationPrincipal User user) {
        order.setDeliveryState(user.getState());
        order.setDeliveryCity(user.getCity());
        order.setDeliveryStreet(user.getStreet());
        order.setDeliveryName(user.getFullname());
        order.setDeliveryZip(user.getZip());
        //TODO create orderForm
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order, Errors errors,
                               SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
        if (errors.hasErrors()) {
            return "orderForm";
        }
        /* --this option is to take user from any place in the code
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();*/

//        User user = (User) authentication.getPrincipal();
        log.info("Order submitted: {}", order);
        order.setUser(user);
        orderRepo.save(order);



        sessionStatus.setComplete();
        return "redirect:/";
    }

    @PreAuthorize("hasRole(‘ADMIN’)")
    @PostMapping("/deleteOrders")
    public void deleteAllOrders() {
        orderRepo.deleteAll();
    }

}
