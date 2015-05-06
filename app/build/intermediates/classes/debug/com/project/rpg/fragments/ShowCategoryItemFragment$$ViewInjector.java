// Generated code from Butter Knife. Do not modify!
package com.project.rpg.fragments;

import android.view.View;
import butterknife.ButterKnife.Finder;

public class ShowCategoryItemFragment$$ViewInjector {
  public static void inject(Finder finder, final com.project.rpg.fragments.ShowCategoryItemFragment target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131296329, "field 'mItemViewPager'");
    target.mItemViewPager = (android.support.v4.view.ViewPager) view;
    view = finder.findRequiredView(source, 2131296328, "field 'mSlidingTabLayout'");
    target.mSlidingTabLayout = (com.project.rpg.widgets.SlidingTabLayout) view;
  }

  public static void reset(com.project.rpg.fragments.ShowCategoryItemFragment target) {
    target.mItemViewPager = null;
    target.mSlidingTabLayout = null;
  }
}
