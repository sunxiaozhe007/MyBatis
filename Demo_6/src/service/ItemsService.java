package service;

import po.Items;

import java.util.List;

public interface ItemsService {
    List<Items> findAll();

    Items findById(Integer id);

    void saveUpdate(Items items);

    void deleteById(Integer id);
}
