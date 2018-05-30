package service;

import po.Items;
import mapper.ItemsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Resource
    private ItemsMapper itemsMapper;
    @Override
    public List<Items> findAll() {
        List<Items> list = itemsMapper.findAll();
        return list;
    }

    @Override
    public Items findById(Integer id) {
        Items items = itemsMapper.selectByPrimaryKey(id);
        return items;
    }

    @Override
    public void saveUpdate(Items items) {
        itemsMapper.updateByPrimaryKey(items);
    }

    @Override
    public void deleteById(Integer id) {
        itemsMapper.deleteByPrimaryKey(id);
    }
}
