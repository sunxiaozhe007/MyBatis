package controller;

import po.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ItemsService;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ItemsController {

    @Resource
    private ItemsService itemsService;
    //��ѯ������Ʒ
    @RequestMapping("list")
    public String list(Model model){

        List<Items> list = itemsService.findAll();
        model.addAttribute("list",list);
        return "itemsList";
    }

    //��ת�޸�ҳ��
    @RequestMapping("edit")
    public String edid(Integer id,Model model){
        //����ID��ѯ��Ʒʵ��ҳ�����
        Items items = itemsService.findById(id);
        model.addAttribute("item",items);
        return "editItem";
    }

    @RequestMapping("saveUpdate")
    public String saveUpdate(Items items){
        itemsService.saveUpdate(items);
        return "redirect:list";
    }

    @RequestMapping("deleteById")
    public String deleteById(Integer id){
        itemsService.deleteById(id);
        return "redirect:list";
    }

    @RequestMapping("deleteByIds")
    public String deleteByIds(Integer[] id){
        for (Integer ids : id){
            itemsService.deleteById(ids);
        }

        return "redirect:list";
    }
}
