package com.example.gogame.service;

import com.example.gogame.dao.FavoriteDAO;
import com.example.gogame.entity.db.Item;
import com.example.gogame.entity.db.ItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteDAO favoriteDAO;

    public void setFavoriteItem(String userId, Item item) {
        favoriteDAO.setFavoriteItem(userId, item);
    }

    public void unsetFavoriteItem(String userId, String item) {
        favoriteDAO.unsetFavoriteItem(userId, item);
    }

    public Map<String, List<Item>> getFavoriteItem(String userId) {
        Map<String, List<Item>> itemMap = new HashMap<>();
        for (ItemType type : ItemType.values()) {
            itemMap.put(type.toString(), new ArrayList<>());
        }

        Set<Item> favorites = favoriteDAO.getFavoriteItems(userId);

        for (Item item : favorites) {
            itemMap.get(item.getItemType().toString()).add(item);
        }

        return itemMap;
    }
}
