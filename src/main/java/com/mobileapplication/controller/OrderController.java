package com.mobileapplication.controller;

//import com.mobileapplication.domain.Order;
import com.mobileapplication.domain.Order;
import com.mobileapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(path = "/services", method = RequestMethod.GET)
    public String services() {
        return "services";
    }

    @RequestMapping(path = "/order")
    public String start(@ModelAttribute("order") String order) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WebAuthenticationDetails authDetails = (WebAuthenticationDetails) auth.getDetails();
        String sessionId = authDetails.getSessionId();

        Order order1 = new Order();
        order1.setBucket(0);
        order1.setSessionId(sessionId);
        order1.setDescription(order);
        orderService.saveOrder(order1);

        return "redirect:/services";
        // return null;
    }
    //метод отправляет в корзину с товарами
    @RequestMapping(path = "/order/bucket")
    public String bucket(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WebAuthenticationDetails authDetails = (WebAuthenticationDetails) auth.getDetails();
        String sessionId = authDetails.getSessionId();
        List<Order> orderList = orderService.findOrdersBySessionId(sessionId);
        if (orderList==null) {
            return "client/partials/emptyBucket";
        } else {
            model.addAttribute("order", orderList);
            return "bucket";

        }
    }
    //перенаправляет на страницу для выбора авторизации
    @RequestMapping(path = "/order/sendToAdmin/{orderId}")
    public String sendToAdmin(@PathVariable("orderId") Integer orderId,
                              Model model) {
        Order order = orderService.getOrderById(orderId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WebAuthenticationDetails authDetails = (WebAuthenticationDetails) auth.getDetails();
        String sessionId = authDetails.getSessionId();
        model.addAttribute("order", order);
        return "chooseRole";

    }
    @RequestMapping(path = "order/addOrderByUser/{orderId}")
    public String addOrderByUser(@PathVariable ("orderId") Integer orderId){
        return "redirect:clientAccount/bucket/"+orderId;
    }
    @RequestMapping(path = "order/addOrderFromAnonymous/{orderId}")
    public String addOrderByAnonymous(@PathVariable ("orderId") Integer orderId,
                                      Model model){
        model.addAttribute("orderID", orderId);
        return "formToOrder";
    }
    @RequestMapping(path = "/order/clientContactInfo/{client}")
    public String getClientAnonInfo(String client){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        WebAuthenticationDetails authDetails = (WebAuthenticationDetails) auth.getDetails();
        String sessionId = authDetails.getSessionId();
        List<Order> orderList = orderService.findOrdersBySessionId(sessionId);
       for(Order order: orderList){
           order.setClient(client);
           order.setBucket(1);
           order.setStatus("в работе");
           orderService.update(order);
       }
        //orderList.setClient(client);
      //orderService.update(order);
      return "redirect:/";
    }
}
