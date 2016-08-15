package SirShadow.AdventureBags.common.utils.handler;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

/**
 * Created by TeamRoots on 13.8.2016.
 */
public enum KeyBindings
{

    QUICK_ACCESS("quick_access", Keyboard.KEY_Q);

    public final KeyBinding keyBinding;

    KeyBindings(String keyName, int defaultKeyCode)
    {
        keyBinding = new KeyBinding(keyName, defaultKeyCode, "key.category.adventure_bags");
    }

    public KeyBinding getKeyBid()
    {
        return keyBinding;
    }

    public boolean isPressed()
    {
        return keyBinding.isPressed();
    }
}
