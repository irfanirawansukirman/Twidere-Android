package org.mariotaku.twidere.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.widget.ImageButton;

import org.mariotaku.twidere.R;

/**
 * Created by mariotaku on 14/11/5.
 */
public class ActionIconButton extends ImageButton {

    @ColorInt
    private int mDefaultColor, mActivatedColor, mDisabledColor;

    public ActionIconButton(Context context) {
        this(context, null);
    }

    public ActionIconButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.R.attr.imageButtonStyle);
    }

    public ActionIconButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.IconActionButton,
                R.attr.cardActionButtonStyle, R.style.Widget_CardActionButton);
        mDefaultColor = a.getColor(R.styleable.IconActionButton_iabColor, 0);
        mActivatedColor = a.getColor(R.styleable.IconActionButton_iabActivatedColor, 0);
        mDisabledColor = a.getColor(R.styleable.IconActionButton_iabDisabledColor, 0);
        a.recycle();
        updateColorFilter();
    }

    @ColorInt
    public int getDefaultColor() {
        return mDefaultColor;
    }

    @ColorInt
    public int getActivatedColor() {
        if (mActivatedColor != 0) return mActivatedColor;
        return getDefaultColor();
    }

    @ColorInt
    public int getDisabledColor() {
        if (mDisabledColor != 0) return mDisabledColor;
        return getDefaultColor();
    }

    public void setDefaultColor(@ColorInt int defaultColor) {
        mDefaultColor = defaultColor;
        updateColorFilter();
    }

    public void setActivatedColor(@ColorInt int activatedColor) {
        mActivatedColor = activatedColor;
        updateColorFilter();
    }

    public void setDisabledColor(@ColorInt int disabledColor) {
        mDisabledColor = disabledColor;
        updateColorFilter();
    }

    @Override
    public void setActivated(boolean activated) {
        super.setActivated(activated);
        updateColorFilter();
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        updateColorFilter();
    }

    private void updateColorFilter() {
        if (isActivated()) {
            setColorFilter(getActivatedColor());
        } else if (isEnabled()) {
            setColorFilter(getDefaultColor());
        } else {
            setColorFilter(getDisabledColor());
        }
    }
}
