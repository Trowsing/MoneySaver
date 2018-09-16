package com.tr.MoneySaver.ui.view;

import com.tr.MoneySaver.model.Item;

import java.util.List;

public interface ItemListView extends BaseView {
    void showItems(List<Item> items);
}
