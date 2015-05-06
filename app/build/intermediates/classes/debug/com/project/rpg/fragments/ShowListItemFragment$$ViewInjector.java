// Generated code from Butter Knife. Do not modify!
package com.project.rpg.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ShowListItemFragment$$ViewInjector {
  public static void inject(Finder finder, final com.project.rpg.fragments.ShowListItemFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296344, "field 'mItemListView'");
    target.mItemListView = (android.widget.ExpandableListView) view;
  }

  public static void reset(com.project.rpg.fragments.ShowListItemFragment target) {
    target.mItemListView = null;
  }
}
