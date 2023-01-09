package fr.corentin.roux.x_wing_score_tracker.utils;

import android.content.Context;
import android.content.res.Configuration;

import androidx.appcompat.app.AppCompatDelegate;

import java.util.Locale;

import fr.corentin.roux.x_wing_score_tracker.model.Language;
import fr.corentin.roux.x_wing_score_tracker.model.Setting;

public class LocaleHelper {

    public static Context checkDefaultLanguage(Setting setting, Context context) {
        final Locale locale = getLocaleFromSettings(setting);
        Locale.setDefault(locale);

        final Configuration configuration = context.getResources().getConfiguration();
        configuration.setLocale(locale);
        configuration.setLayoutDirection(locale);

        return context.createConfigurationContext(configuration);
    }

    private static Locale getLocaleFromSettings(Setting setting) {
        Language language;
        if (setting.getLanguage() == null) {
            language = Language.ENGLISH;
        } else {
            language = Language.parseCodeIhm(setting.getLanguage());
        }
        Locale locale;

        switch (language) {
            case FRENCH:
                locale = Locale.FRENCH;
                break;

            case ITALIANO:
                locale = Locale.ITALIAN;
                break;
            case SPANNISH:
                locale = new Locale("es");
                break;
            case DEUTSCH:
                locale = Locale.GERMAN;
                break;
            case CHINOIS:
                locale = Locale.SIMPLIFIED_CHINESE;
                break;
            case ENGLISH:
            default:
                locale = Locale.ENGLISH;
                break;
        }
        return locale;
    }
}
