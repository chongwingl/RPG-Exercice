package com.project.rpg.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.project.rpg.R;
import com.project.rpg.exceptions.AttackMissedException;
import com.project.rpg.exceptions.NoMoreLifeException;
import com.project.rpg.fragments.dialogs.BaseDialogFragment;
import com.project.rpg.intents.BagIntent;
import com.project.rpg.intents.CharacterIntent;
import com.project.rpg.intents.FightingIntent;
import com.project.rpg.models.characters.fighters.AbstractFighter;
import com.project.rpg.models.monsters.AbstractMonster;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by laetitia on 5/14/15.
 */
public class FightingActivity extends ToolbarActivity {

    @InjectView(R.id.monster_life)
    TextView mMonsterLife;

    @InjectView(R.id.fight_history)
    TextView mHistory;

    private AbstractMonster mMonster;
    private AbstractFighter mCharacter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FightingIntent intent = new FightingIntent(getIntent());
        mMonster = intent.getMonster();
        mCharacter = (AbstractFighter) getApp().getCharacter();

        mMonsterLife.setText(getString(R.string.monster_current_life) + " " + mMonster.getLife());
    }

    @OnClick(R.id.attack)
    void onAttack() {
        // 1) character attack
        // a) check if monster attack before
        if (mMonster.willAttackFirst(mCharacter)) {
            try {
                int damage = mMonster.attack(mCharacter);
                if (damage > 1) {
                    mCharacter.removeLife(damage);
                    surpriseAttack(false, damage);
                } else {
                    missedAttack(false);
                }
            } catch (AttackMissedException e) {
                Log.d(getClass().getSimpleName(), e.getMessage());
            } catch (NoMoreLifeException e) {
                noMoreLifeDialog(e);
            }
        }
        // b) normal attack
        try {
            int damage = mCharacter.attack(mMonster);
            if (damage > 1) {
                mMonster.removeLife(damage);
                attackSuccess(true, damage);
            } else {
                missedAttack(true);
            }
        } catch (AttackMissedException e) {
            missedAttack(true);
        } catch (NoMoreLifeException e) {
            noMoreLifeMonsterDialog();
        }
        // TODO PAUSE
        // 2) monster attack
        // a) check if character attack before
        if (mCharacter.willAttackFirst(mMonster)) {
            try {
                int damage = mCharacter.attack(mMonster);
                if (damage > 1) {
                    mMonster.removeLife(damage);
                    surpriseAttack(true, damage);
                } else {
                    missedAttack(true);
                }
            } catch (AttackMissedException e) {
                Log.d(getClass().getSimpleName(), e.getMessage());
            } catch (NoMoreLifeException e) {
                noMoreLifeMonsterDialog();
            }
        }
        // b) normal attack
        try {
            int damage = mMonster.attack(mCharacter);
            if (damage > 1) {
                mCharacter.removeLife(damage);
                attackSuccess(false, damage);
            } else {
                missedAttack(false);
            }
        } catch (AttackMissedException e) {
            missedAttack(false);
        } catch (NoMoreLifeException e) {
            noMoreLifeDialog(e);
        }
    }

    @OnClick(R.id.open_bag)
    void onOpenBag() {
        startActivity(new BagIntent(this));
    }

    @OnClick(R.id.abandon)
    void onAbandon() {
        // TODO display dialog to confirm
        finish();
    }

    @Override
    public int getLayoutResourceId() {
        return R.layout.activity_fighting;
    }

    private void attackSuccess(boolean isCharacter, int damage) {
        if (mHistory.getVisibility() == View.GONE) {
            mHistory.setVisibility(View.VISIBLE);
        }
        String text = mHistory.getText().toString();
        if (isCharacter) {
            text += getString(R.string.attack_success,
                    getString(R.string.attack_success_character1),
                    getString(R.string.attack_success_character2),
                    damage);
            mMonsterLife.setText(mMonster.getLife() + " " + getString(R.string.monster_current_life));
        } else {
            text += getString(R.string.attack_success,
                    mMonster.getName() + getString(R.string.attack_success_monster1),
                    getString(R.string.attack_success_monster2),
                    damage);
        }
        mHistory.setText(text);
    }


    private void missedAttack(boolean isCharacter) {
        if (mHistory.getVisibility() == View.GONE) {
            mHistory.setVisibility(View.VISIBLE);
        }
        String text = mHistory.getText().toString();
        if (isCharacter) {
            text += getString(R.string.attack_missed, getString(R.string.attack_missed_character));
        } else {
            text += getString(R.string.attack_missed, mMonster.getName() + getString(R.string.attack_missed_monster));
        }
        mHistory.setText(text);
    }

    private void surpriseAttack(boolean isCharacter, int damage) {
        if (mHistory.getVisibility() == View.GONE) {
            mHistory.setVisibility(View.VISIBLE);
        }
        String text = mHistory.getText().toString();
        if (isCharacter) {
            text += getString(R.string.attack_surprise,
                    getString(R.string.attack_surprise_character1),
                    mMonster.getName(),
                    getString(R.string.attack_surprise_character3),
                    damage
            );
            mMonsterLife.setText(mMonster.getLife() + " " + getString(R.string.monster_current_life));
        } else {
            text += getString(R.string.attack_surprise,
                    mMonster.getName(),
                    getString(R.string.attack_surprise_monster2),
                    getString(R.string.attack_surprise_monster3),
                    damage
            );
        }
        mHistory.setText(text);
    }

    private void noMoreLifeDialog(NoMoreLifeException e) {
        BaseDialogFragment dialog = BaseDialogFragment.newInstance(R.string.no_more_life_error_message_title,
                e.getMessageRefId(),
                R.string.ok,
                -1
        );
        dialog.setPositiveListener(new BaseDialogFragment.DialogButtonsListener() {
            @Override
            public void onDialogButtonClick(DialogFragment dialog, int buttonTitle) {
                CharacterIntent intent = new CharacterIntent(FightingActivity.this, mCharacter.getCharacterType());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                FightingActivity.this.finish();
            }
        });
        dialog.show(getSupportFragmentManager());
    }

    private void noMoreLifeMonsterDialog() {
        BaseDialogFragment dialog = BaseDialogFragment.newInstance(R.string.character_victory,
                R.string.monster_cannot_fight,
                R.string.ok, -1);
        dialog.setPositiveListener(new BaseDialogFragment.DialogButtonsListener() {
            @Override
            public void onDialogButtonClick(DialogFragment dialog, int buttonTitle) {
                CharacterIntent intent = new CharacterIntent(FightingActivity.this, mCharacter.getCharacterType());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                FightingActivity.this.finish();
            }
        });
        dialog.show(getSupportFragmentManager());
    }

}
