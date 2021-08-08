package onlineShop.controller;

import onlineShop.entity.Cart;
import onlineShop.entity.Customer;
import onlineShop.service.CartService;
import onlineShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/cart/getCartById", method = RequestMethod.GET)
    public ModelAndView getCartId(){
        ModelAndView modelAndView = new ModelAndView("cart");
        Authentication loggedInUser  = SecurityContextHolder.getContext().getAuthentication();
        String userName = loggedInUser.getName();
        Customer customer = customerService.getCustomerByUserName(userName);
        modelAndView.addObject("cartId", customer.getCart().getId());
        return modelAndView;
    }

    @RequestMapping(value = "/cart/getCart/{cartId}", method = RequestMethod.GET)
    @ResponseBody
    public Cart getCartItems(@PathVariable(value = "cartId") int cartId){
        return cartService.getCartById(cartId);
    }


}
