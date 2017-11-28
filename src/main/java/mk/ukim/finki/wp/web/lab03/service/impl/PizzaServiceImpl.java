package mk.ukim.finki.wp.web.lab03.service.impl;

import mk.ukim.finki.wp.web.lab03.service.PizzaService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Alek Ivanovski on 11/28/2017.
 */
@Service
public class PizzaServiceImpl implements PizzaService{
    public List<String> getPizzaTypes(){
        List<String> list = Arrays.asList("small", "medium", "large");
        return list;
    }
}
