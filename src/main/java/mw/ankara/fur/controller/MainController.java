package mw.ankara.fur.controller;

import mw.ankara.fur.Context;
import mw.ankara.fur.model.Fur;
import mw.ankara.fur.service.FurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Component
public class MainController {

    @Autowired
    private Context context;

    @Autowired
    private FurService furService;

    @RequestMapping("list")
    @ResponseBody
    public List<Fur> list(@RequestParam int page) {
        return furService.getFursAt(page);
    }

    @RequestMapping("get")
    @ResponseBody
    public Fur get(@RequestParam String id) {
        return furService.getFurBy(id);
    }
}
