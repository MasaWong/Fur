package mw.ankara.fur.controller;

import mw.ankara.fur.Context;
import mw.ankara.fur.model.Fur;
import mw.ankara.fur.service.FurService;
import net.coobird.thumbnailator.Thumbnailator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@Component
@RequestMapping("ry")
public class WebController {

    private Logger logger = Logger.getLogger(WebController.class);

    @Autowired
    private Context context;

    @Autowired
    private FurService furService;

    @RequestMapping("add")
    public String add() {
        return "add.jsp";
    }

    @RequestMapping("detail")
    public String detail(@RequestParam String id, ModelMap map) {
        map.put("detail", furService.getFurBy(id));
        return "detail.jsp";
    }

    @RequestMapping("list")
    public String list(@RequestParam(required = false) String page, ModelMap map) {
        int p = page == null || page.isEmpty() ? 0 : Integer.parseInt(page);
        map.put("furs", furService.getFursAt(p));
        return "list.jsp";
    }

    @RequestMapping("put")
    public String put(HttpServletRequest request, @RequestParam String name, @RequestParam MultipartFile image) throws IOException {
        //生成uuid作为文件名称
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //获得文件类型（可以判断如果不是图片，禁止上传）
        String contentType = image.getContentType();
        String type = contentType.substring(contentType.indexOf("/") + 1);
        //获得目标路径
        String img = "img/";
        String path = request.getSession().getServletContext().getRealPath(img);
        if (!path.endsWith("/")) {
            path += "/";
        }
        String filename = uuid + "." + type;
        // 写到磁盘
        String original = "ori" + filename;
        File origin = new File(path + original);
        image.transferTo(origin);
        // thumb
        File thumb = new File(path + filename);
        Thumbnailator.createThumbnail(origin, thumb, 175, 210);

        img = "/" + img;
        furService.addFur(new Fur(name, img + filename, img + original));

        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(@RequestParam String id) {
        furService.deleteFur(id);

        return "redirect:list";
    }
}
