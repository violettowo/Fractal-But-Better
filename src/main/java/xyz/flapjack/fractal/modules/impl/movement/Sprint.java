package xyz.flapjack.fractal.modules.impl.movement;

/* Custom. */
import xyz.flapjack.fractal.events.impl.TickEvent;
import xyz.flapjack.fractal.modules.Setting;
import xyz.flapjack.fractal.modules.Module;

/* Weave. */
import net.weavemc.loader.api.event.SubscribeEvent;
import net.minecraft.client.settings.KeyBinding;

/* Open. */
import java.util.ArrayList;

public class Sprint extends Module {
    public Sprint() {
        super("Sprint", "Automatically sprints.", Category.Movement, "menu", "toggleable");

        this.registerSetting(new Setting("Keep", this, null, false));
    }

    @SubscribeEvent
    public void clientTick(final TickEvent event) {
        ArrayList<Boolean> checks = new ArrayList<>();
        checks.add(this.mcInstance.inGameHasFocus);
        checks.add(this.enabled);

        if (this.massCheck(checks)) {
            return;
        }

        KeyBinding.setKeyBindState(this.mcInstance.gameSettings.keyBindSprint.getKeyCode(), true);
    }
}
