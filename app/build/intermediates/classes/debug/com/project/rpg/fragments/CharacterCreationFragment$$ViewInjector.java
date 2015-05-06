// Generated code from Butter Knife. Do not modify!
package com.project.rpg.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CharacterCreationFragment$$ViewInjector {
  public static void inject(Finder finder, final com.project.rpg.fragments.CharacterCreationFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296330, "field 'fighterName'");
    target.fighterName = (android.widget.EditText) view;
    view = finder.findRequiredView(source, 2131296331, "method 'onFighterCreated'");
    view.setOnClickListener(
      new android.view.View.OnClickListener() {
        @Override public void onClick(
          android.view.View p0
        ) {
          target.onFighterCreated();
        }
      });
  }

  public static void reset(com.project.rpg.fragments.CharacterCreationFragment target) {
    target.fighterName = null;
  }
}
