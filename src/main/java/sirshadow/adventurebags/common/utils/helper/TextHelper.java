package sirshadow.adventurebags.common.utils.helper;


import net.minecraft.client.resources.I18n;
import org.lwjgl.input.Keyboard;

/**
 * Created by SirShadow for the mod Roots on 30.7.2016.
 */
public class TextHelper
{
    public static boolean isShiftPressed()
    {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    public static String localize(String text)
    {
        return I18n.format(text);
    }



    public static String deBugText(String text)
    {
        return BLUE + "["+ WHITE + "DeBug" + END + BLUE + "]:" + END + text;
    }

    /**
     * @param text  Your text
     * @param textColor Use a color from TextHelper eg. TextHelper.BLUE
     * @return
     */

    public static String specialText(String text,String textColor)
    {
        return textColor + localize(text)+ END;
    }

    /**
     * All string colours
     */
    public static final String BLACK = (char) 167 + "0";
    public static final String BLUE = (char) 167 + "1";
    public static final String GREEN = (char) 167 + "2";
    public static final String TEAL = (char) 167 + "3";
    public static final String RED = (char) 167 + "4";
    public static final String PURPLE = (char) 167 + "5";
    public static final String ORANGE = (char) 167 + "6";
    public static final String LIGHT_GRAY = (char) 167 + "7";
    public static final String GRAY = (char) 167 + "8";
    public static final String LIGHT_BLUE = (char) 167 + "9";
    public static final String BRIGHT_GREEN = (char) 167 + "a";
    public static final String BRIGHT_BLUE = (char) 167 + "b";
    public static final String LIGHT_RED = (char) 167 + "c";
    public static final String PINK = (char) 167 + "d";
    public static final String YELLOW = (char) 167 + "e";
    public static final String WHITE = (char) 167 + "f";

    public static final String OBFUSCATED = (char) 167 + "k";
    public static final String BOLD = (char) 167 + "l";
    public static final String STRIKETHROUGH = (char) 167 + "m";
    public static final String UNDERLINE = (char) 167 + "n";
    public static final String ITALIC = (char) 167 + "o";
    public static final String END = (char) 167 + "r";

    public static boolean displayShiftForDetail = true;
    public static boolean displayStackCount = false;
}
