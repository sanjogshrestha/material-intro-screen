package agency.tango.materialintroscreen.animations;

import android.support.annotation.AnimRes;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import agency.tango.materialintroscreen.animations.translations.NoTranslation;

@SuppressWarnings("WeakerAccess")
public class ViewTranslationWrapper {
    private View view;

    private IViewTranslation enterTranslation;
    private IViewTranslation exitTranslation;
    private IViewTranslation defaultTranslation;
    private Animation errorAnimation;

    public ViewTranslationWrapper(View view) {
        this.view = view;

        this.enterTranslation = new NoTranslation();
        this.exitTranslation = new NoTranslation();
        this.setErrorAnimation(0);
    }

    /**
     * Set translation after passing first slide
     * @param enterTranslation new translation
     */
    public ViewTranslationWrapper setEnterTranslation(IViewTranslation enterTranslation) {
        this.enterTranslation = enterTranslation;
        return this;
    }

    /**
     * Set translation after passing last slide
     * @param exitTranslation new translation
     */
    public ViewTranslationWrapper setExitTranslation(IViewTranslation exitTranslation) {
        this.exitTranslation = exitTranslation;
        return this;
    }

    /**
     * Set default translation
     * @param defaultTranslation new translation
     */
    public ViewTranslationWrapper setDefaultTranslation(IViewTranslation defaultTranslation) {
        this.defaultTranslation = defaultTranslation;
        return this;
    }

    /**
     * Set view on error animation
     * @param errorAnimation new animation
     */
    public ViewTranslationWrapper setErrorAnimation(@AnimRes int errorAnimation) {
        if (errorAnimation != 0) {
            this.errorAnimation = AnimationUtils.loadAnimation(view.getContext(), errorAnimation);
        }
        return this;
    }

    public void enterTranslate(float percentage) {
        this.enterTranslation.translate(view, percentage);
    }

    public void exitTranslate(float percentage) {
        this.exitTranslation.translate(view, percentage);
    }

    public void defaultTranslate(float percentage) {
        this.defaultTranslation.translate(view, percentage);
    }

    public void error() {
        if (errorAnimation != null) {
            this.view.startAnimation(errorAnimation);
        }
    }
}