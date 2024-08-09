package com.example.custom_cardview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;

public class Custom_Card extends CardView {

    public Custom_Card(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomCardView);

        try {
            // Background color
            int backgroundColor = a.getColor(R.styleable.CustomCardView_backgroundColor, Color.WHITE);
            setCardBackgroundColor(backgroundColor);

            // Corner radius
            float radius = a.getDimension(R.styleable.CustomCardView_cornerRadius, 0f);
            setRadius(radius);

            // Gradient
            int startColor = a.getColor(R.styleable.CustomCardView_gradientStartColor, backgroundColor);
            int endColor = a.getColor(R.styleable.CustomCardView_gradientEndColor, backgroundColor);
            boolean useGradient = a.getBoolean(R.styleable.CustomCardView_useGradient, false);
            if (useGradient) {
                setGradientBackground(startColor, endColor);
            }

            // Transparency
            float transparency = a.getFloat(R.styleable.CustomCardView_transparency, 1.0f);
            setCardTransparency(transparency);

            // Glass effect
            boolean useGlassEffect = a.getBoolean(R.styleable.CustomCardView_useGlassEffect, false);
            if (useGlassEffect) {
                applyGlassEffect();
            }

        } finally {
            a.recycle();
        }
    }

    // Setters for customization through code
    public void setCustomBackgroundColor(int color) {
        setCardBackgroundColor(color);
    }

    public void setGradientBackground(int startColor, int endColor) {
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM, new int[]{startColor, endColor});
        setBackground(gradientDrawable);
    }

    public void setCardTransparency(float transparency) {
        setAlpha(transparency);
    }

    public void applyGlassEffect() {
        setCardBackgroundColor(Color.argb(100, 255, 255, 255)); // Semi-transparent white
        setElevation(10); // Adjust as needed
    }
}
