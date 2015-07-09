package com.project.rpg.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.fragments.dialogs.BaseDialogFragment;
import com.project.rpg.fragments.dialogs.SingleChoiceDialogFragment;
import com.project.rpg.fragments.dialogs.StringMessageDialogFragment;
import com.project.rpg.generators.ArmorGenerator;
import com.project.rpg.generators.CoinGenerator;
import com.project.rpg.generators.ItemTypeGenerator;
import com.project.rpg.generators.PotionGenerator;
import com.project.rpg.generators.WeaponGenerator;
import com.project.rpg.intents.CharacterIntent;
import com.project.rpg.intents.VictoryIntent;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.enumerations.ItemType;
import com.project.rpg.models.enumerations.MonsterLevel;
import com.project.rpg.models.enumerations.StatType;
import com.project.rpg.models.items.AbstractItem;
import com.project.rpg.models.items.enhancement.healing.AbstractPotion;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by laetitia on 6/30/15.
 */
public class VictoryActivity extends ToolbarActivity {

    private static final int LIFE_WON_WITH_NORMAL = 2;
    private static final int LIFE_WON_WITH_STRONG = 5;
    private static final int STAT_WON_WITH_NORMAL = 1;
    private static final int STAT_WON_WITH_STRONG = 2;

    @InjectView(R.id.layout_potion)
    View mPotionView;

    @InjectView(R.id.layout_victory_choices)
    View mChoicesView;

    @InjectView(R.id.victory_coins_earned)
    TextView mCoins;

    @InjectView(R.id.victory_potion_earned)
    TextView mPotion;

    @InjectView(R.id.victory_confirm_button)
    Button okButton;

    private MonsterLevel mLevel;
    private AbstractFighter mFighter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mFighter = (AbstractFighter) getCharacter();
        final VictoryIntent intent = new VictoryIntent(getIntent());
        mLevel = intent.getMonsterLevel();
        final int monsterStrength = intent.getMonsterStrength();
        final int coinsEarned = CoinGenerator.generateCoins(mLevel, mFighter.getStat().getStrength(), monsterStrength);
        final AbstractPotion potion = PotionGenerator.generatePotion(this, mLevel);

        mCoins.setText(String.valueOf(coinsEarned));
        mFighter.addGold(coinsEarned);

        if (mLevel == MonsterLevel.WEAK) {
            mPotion.setText(potion.getName());
            mFighter.addToBag(potion);
        } else {
            mPotionView.setVisibility(View.GONE);
            mChoicesView.setVisibility(View.VISIBLE);
            okButton.setVisibility(View.GONE);
        }
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_victory;
    }

    @OnClick(R.id.victory_stat_button)
    void onStatButtonClick() {
        final String[] statArray = new String[]{
                getString(StatType.STRENGTH.getRefId()),
                getString(StatType.SPEED.getRefId()),
                getString(StatType.RESISTANCE.getRefId()),
                getString(StatType.ACCURACY.getRefId())

        };

        final int titleRefId;
        final int statPointEarned;
        if (mLevel == MonsterLevel.NORMAL) {
            titleRefId = R.string.victory_stat_title_normal;
            statPointEarned = STAT_WON_WITH_NORMAL;
        } else {
            titleRefId = R.string.victory_stat_title_strong;
            statPointEarned = STAT_WON_WITH_STRONG;
        }

        SingleChoiceDialogFragment dialogFragment = SingleChoiceDialogFragment.newInstance(
                titleRefId,
                R.string.ok,
                statArray
        );
        dialogFragment.setPositiveListener(new SingleChoiceDialogFragment.DialogButtonsListener() {
            @Override
            public void onDialogButtonClick(DialogFragment dialog, int buttonTitle, int selectedOption) {
                String stat = statArray[selectedOption];
                mFighter.addStat(StatType.getStatTypeByName(VictoryActivity.this, stat), statPointEarned);
                goToNextActivity();
            }
        });
        dialogFragment.show(getSupportFragmentManager());
    }

    @OnClick(R.id.victory_life_button)
    void onLifeButtonClick() {
        final int titleRefId;
        final String message;
        final int lifePointsWon;
        if (mLevel == MonsterLevel.NORMAL) {
            titleRefId = R.string.victory_life_title_normal;
            message = getString(R.string.victory_life_message,
                    mFighter.getStat().getLifePoints().getMaxLifePoint(),
                    mFighter.getStat().getLifePoints().getMaxLifePoint() + LIFE_WON_WITH_NORMAL);
            lifePointsWon = LIFE_WON_WITH_NORMAL;
        } else {
            titleRefId = R.string.victory_life_title_strong;
            message = getString(R.string.victory_life_message,
                    mFighter.getStat().getLifePoints().getMaxLifePoint(),
                    mFighter.getStat().getLifePoints().getMaxLifePoint() + LIFE_WON_WITH_STRONG);
            lifePointsWon = LIFE_WON_WITH_STRONG;
        }
        StringMessageDialogFragment dialogFragment = StringMessageDialogFragment.newInstance(
                titleRefId,
                message,
                R.string.ok
        );
        dialogFragment.setPositiveListener(new BaseDialogFragment.DialogButtonsListener() {
            @Override
            public void onDialogButtonClick(DialogFragment dialog, int buttonTitle) {
                dialog.dismiss();
                mFighter.addMaxLife(
                        mFighter.getStat().getLifePoints().getMaxLifePoint() + lifePointsWon
                );
                goToNextActivity();
            }
        });
        dialogFragment.setCancelable(false);
        dialogFragment.show(getSupportFragmentManager());
    }

    @OnClick(R.id.victory_object_button)
    void onObjectButtonClick() {
        ItemType itemType = ItemTypeGenerator.generateItemType(AbstractFighter.mItemProbability);
        final AbstractItem item;
        if (itemType == ItemType.HEALING) {
            item = PotionGenerator.generatePotion(this, mLevel);
        } else if (itemType == ItemType.WEAPON) {
            item = WeaponGenerator.generateWeapon(this, mLevel);
        } else if (itemType == ItemType.ARMOR) {
            item = ArmorGenerator.generateArmor(this, mLevel);
        } else {
            item = PotionGenerator.generatePotion(this, mLevel);
        }
        StringMessageDialogFragment dialogFragment = StringMessageDialogFragment.newInstance(
                R.string.victory_object_title,
                getString(R.string.victory_object_message, item.getName()),
                R.string.ok
        );

        dialogFragment.setPositiveListener(new BaseDialogFragment.DialogButtonsListener() {
            @Override
            public void onDialogButtonClick(DialogFragment dialog, int buttonTitle) {
                mFighter.addToBag(item);
                goToNextActivity();
            }
        });
        
        dialogFragment.setCancelable(false);
        dialogFragment.show(getSupportFragmentManager());
    }

    @OnClick(R.id.victory_confirm_button)
    void onOkButtonClick() {
        goToNextActivity();
    }

    private void goToNextActivity() {
        CharacterIntent intent = new CharacterIntent(this, getCharacter().getCharacterType());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
