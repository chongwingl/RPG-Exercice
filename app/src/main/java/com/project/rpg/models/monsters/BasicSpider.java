package com.project.rpg.models.monsters;

import android.content.Context;

import com.project.rpg.R;
import com.project.rpg.models.powers.Poison;

public class BasicSpider extends AbstractMonster {

    private static final long serialVersionUID = 4845746688480640845L;

    public BasicSpider(Context context) {
		super(context.getString(R.string.monster_name_spider), 50, 20, 20, 20, 20);
		setPower(new Poison());
	}
}
