// Generated code from Butter Knife. Do not modify!
package com.project.rpg.fragments.knight;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class KnighStateFragment$$ViewInjector {
  public static void inject(Finder finder, final com.project.rpg.fragments.knight.KnighStateFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296333, "field 'mLevel'");
    target.mLevel = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296334, "field 'mGold'");
    target.mGold = (android.widget.TextView) view;
    view = finder.findRequiredView(source, 2131296332, "field 'mLife'");
    target.mLife = (android.widget.TextView) view;
  }

  public static void reset(com.project.rpg.fragments.knight.KnighStateFragment target) {
    target.mLevel = null;
    target.mGold = null;
    target.mLife = null;
  }
}
