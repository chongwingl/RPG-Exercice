// Generated code from Butter Knife. Do not modify!
package com.project.rpg.activities;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class HomeActivity$$ViewInjector {
  public static void inject(Finder finder, final com.project.rpg.activities.HomeActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296324, "field 'characterList'");
    target.characterList = (android.widget.ListView) view;
  }

  public static void reset(com.project.rpg.activities.HomeActivity target) {
    target.characterList = null;
  }
}
