package com.tr.MoneySaver.ui.view;

import com.tr.MoneySaver.model.ConsolidatedStatement;

public interface StatsView extends BaseView {
    void showConsolidatedStatement(ConsolidatedStatement consolidatedStatement);
}
