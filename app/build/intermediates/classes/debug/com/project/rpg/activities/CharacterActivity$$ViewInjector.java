// Generated code from Butter Knife. Do not modify!
package com.project.rpg.activities;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class CharacterActivity$$ViewInjector {
  public static void inject(Finder finder, final com.project.rpg.activities.CharacterActivity target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296321, "field 'mCharacterActionViewPager'");
    target.mCharacterActionViewPager = (android.support.v4.view.ViewPager) view;
    view = finder.findRequiredView(source, 2131296320, "field 'mSlidingTabLayout'");
    target.mSlidingTabLayout = (com.project.rpg.widgets.SlidingTabLayout) view;
    view = finder.findRequiredView(source, 2131296319, "field 'mCharacterTitle'");
    target.mCharacterTitle = (android.widget.TextView) view;
  }

  public static void reset(com.project.rpg.activities.CharacterActivity target) {
    target.mCharacterActionViewPager = null;
    target.mSlidingTabLayout = null;
    target.mCharacterTitle = null;
  }
}
